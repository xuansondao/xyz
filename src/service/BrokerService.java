package service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.com.vndirect.brokerinsight.common.state.BrokerState;
import vn.com.vndirect.brokerinsight.model.entity.Broker;
import vn.com.vndirect.brokerinsight.model.request.BrokerFilterRequest;
import vn.com.vndirect.brokerinsight.model.request.BrokerRequest;
import vn.com.vndirect.brokerinsight.model.response.BrokerResponse;
import vn.com.vndirect.brokerinsight.model.specifications.BrokerSpecification;
import vn.com.vndirect.brokerinsight.repository.BrokerRepository;
import vn.com.vndirect.brokerinsight.service.exception.BrokerException;
import vn.com.vndirect.brokerinsight.service.exception.UpdateFalseException;
import vn.com.vndirect.brokerinsight.service.utils.ErrorCode;
import vn.com.vndirect.brokerinsight.service.utils.PageUtils;
import vn.com.vndirect.brokerinsight.transformer.BrokerTransformer;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BrokerService {
    private static final Logger logger = LoggerFactory.getLogger(BrokerService.class);

    private BrokerRepository repository;
    private BrokerTransformer transformer;


    @Autowired
    public BrokerService(BrokerRepository repository,
                         BrokerTransformer transformer) {
        this.repository = repository;
        this.transformer = transformer;
    }

    public BrokerService() {
    }

    public Broker get(Long userId) {
        return repository.findById(userId).orElseThrow(() -> new BrokerException("Customer Service not found with userId: " + userId));
    }

    public Broker getByUserNameAndBrokerType(String userName, String brokerType) {
        Optional<Broker> broker = repository.findByBrokerUserNameIgnoreCaseAndBrokerTypeAndStatus(userName, brokerType, "A");

        return broker.orElseThrow(() -> new BrokerException("Not found broker with username=" + userName + " And brokerType = " + brokerType));

    }

    public Broker getByUserName(String userName) {
        Optional<Broker> broker = repository.findByBrokerUserNameIgnoreCase(userName);

        return broker.orElseThrow(() -> new BrokerException("Not found broker with username=" + userName));
    }

    public List<BrokerResponse> getByUserNameLike(BrokerFilterRequest brokerFilterRequest) {
        Pageable pageable = PageUtils.createPageable(brokerFilterRequest.getPageIndex(), brokerFilterRequest.getPageSize(), brokerFilterRequest.getSortBy());

        List<Broker> brokers = repository.findBrokersBy(brokerFilterRequest.getUserName(), "A", brokerFilterRequest.getBrokerType(), pageable);

        return brokers.stream().map(transformer::toBrokerResponse).collect(Collectors.toList());
    }

    public Broker getByCustomerId(String customerId) {
        Optional<Broker> broker = repository.findByBrokerCustomerId(customerId);

        return broker.orElseThrow(() -> new BrokerException("Not found broker with customerId=" + customerId));

    }

    public BrokerResponse getBroker(BrokerFilterRequest filterRequest) {
        Optional<Broker> broker = repository.findOne(BrokerSpecification.withFilterBroker(filterRequest));

        broker.orElseThrow(() -> new BrokerException("Not found broker with username=" + filterRequest.getUserName() + " brokerType = " + filterRequest.getBrokerType()));

        return transformer.toBrokerResponse(broker.get());
    }


    public BrokerResponse getBrokerResponse(Long userId) {
        return transformer.toBrokerResponse(get(userId));
    }

    public BrokerResponse getBrokerResponseByUserNameAndBrokerType(String userName, String brokerType) {
        Broker broker = getByUserNameAndBrokerType(userName, brokerType);

        return transformer.toBrokerResponse(broker);
    }

    public BrokerResponse getBrokerByUserName(String userName) {
        Broker broker = getByUserName(userName);


        return transformer.toBrokerResponse(broker);
    }

    public Broker save(Broker broker) {
        logger.info("Add broker with userId: {} ", broker.getUserId());

        return repository.save(broker);
    }

    public BrokerResponse createBroker(BrokerRequest request) {
        Broker broker = transformer.toBroker(request);
        broker.setState(BrokerState.APPROVE);
        repository.save(broker);
        return transformer.toBrokerResponse(broker);
    }

    public BrokerResponse createBrokerExternal(BrokerRequest request) {
        Broker broker = transformer.toBroker(request);
        broker.setState(BrokerState.PENDING);
        repository.save(broker);
        return transformer.toBrokerResponse(broker);
    }

    public BrokerResponse updateBroker(Long id, BrokerRequest request) {
        Optional<Broker> brokerExist = repository.findById(id);

        brokerExist.orElseThrow(() -> new BrokerException("Not found broker with id=" + id));

        Broker broker = transformer.toBroker(request);
        if (broker.getUserId() != null && !broker.getUserId().equals( brokerExist.get().getUserId())) {
            if (repository.countAllByUserId(broker.getUserId()) > 0)
                throw new UpdateFalseException(ErrorCode.Code.USER_ID);
        }
        if (broker.getBrokerCustomerId() != null && !broker.getBrokerCustomerId().equals(brokerExist.get().getBrokerCustomerId()) ) {
            if (repository.countAllByBrokerCustomerId(broker.getBrokerCustomerId()) > 0)
                throw new UpdateFalseException(ErrorCode.Code.BROKER_CUSTOMER_ID);
        }
        if ( broker.getBrokerId() != null && !broker.getBrokerId().equals(brokerExist.get().getBrokerId())) {
            if (repository.countAllByBrokerId(broker.getBrokerId()) > 0)
                throw new UpdateFalseException(ErrorCode.Code.BROKER_ID);
        }
        if (broker.getBrokerUserName() != null && !broker.getBrokerUserName().equals(brokerExist.get().getBrokerUserName())) {
            if (repository.countAllByBrokerUserName(broker.getBrokerUserName()) > 0)
                throw new UpdateFalseException(ErrorCode.Code.BROKER_USERNAME);
        }
        if (broker.getHrCode() != null && !broker.getHrCode().equals(brokerExist.get().getHrCode())) {
            if (repository.countAllByHrCode(broker.getHrCode()) > 0)
                throw new UpdateFalseException(ErrorCode.Code.HR_CODE_EXISTED);
        }
        if (broker.getVndirectMail() != null && !broker.getVndirectMail().equals(brokerExist.get().getVndirectMail())) {
            if (repository.countAllByVndirectMail(broker.getVndirectMail()) > 0)
                throw new UpdateFalseException(ErrorCode.Code.VND_EMAIL);
        }

        copyOldToNewBroker(brokerExist.get(), broker);
        broker.setState(BrokerState.PENDING);
        System.out.println(broker.getGender());
        broker.setId(id);

        return transformer.toBrokerResponse(repository.save(broker));
    }

    public BrokerResponse updateBrokerExternal(Long id, BrokerRequest request) {
        Optional<Broker> brokerExist = repository.findById(id);

        brokerExist.orElseThrow(() -> new BrokerException("Not found broker with id=" + id));

        Broker broker = transformer.toBroker(request);
        if (broker.getUserId() != null && !broker.getUserId().equals(brokerExist.get().getUserId())) {
            if (repository.countAllByUserId(broker.getUserId()) > 0)
                throw new UpdateFalseException(ErrorCode.Code.USER_ID);
        }
        if (broker.getBrokerCustomerId() != null && !broker.getBrokerCustomerId().equals(brokerExist.get().getBrokerCustomerId())) {
            if (repository.countAllByBrokerCustomerId(broker.getBrokerCustomerId()) > 0)
                throw new UpdateFalseException(ErrorCode.Code.BROKER_CUSTOMER_ID);
        }
        if (broker.getBrokerId() != null && !broker.getBrokerId().equals(brokerExist.get().getBrokerId())) {
            if (repository.countAllByBrokerId(broker.getBrokerId()) > 0)
                throw new UpdateFalseException(ErrorCode.Code.BROKER_ID);
        }
        if (broker.getBrokerUserName() != null && !broker.getBrokerUserName().equals(brokerExist.get().getBrokerUserName())) {
            if (repository.countAllByBrokerUserName(broker.getBrokerUserName()) > 0)
                throw new UpdateFalseException(ErrorCode.Code.BROKER_USERNAME);
        }
        if (broker.getHrCode() != null && !broker.getHrCode().equals(brokerExist.get().getHrCode())) {
            if (repository.countAllByHrCode(broker.getHrCode()) > 0)
                throw new UpdateFalseException(ErrorCode.Code.HR_CODE_EXISTED);
        }
        if (broker.getVndirectMail() != null && !broker.getVndirectMail().equals(brokerExist.get().getVndirectMail())) {
            if (repository.countAllByVndirectMail(broker.getVndirectMail()) > 0)
                throw new UpdateFalseException(ErrorCode.Code.VND_EMAIL);
        }

        copyOldToNewBroker(brokerExist.get(), broker);
        broker.setState(BrokerState.PENDING);
        System.out.println(broker.getGender());
        broker.setId(id);

        return transformer.toBrokerResponse(repository.save(broker));
    }

    public BrokerResponse updateStatus(long id,Boolean state){
        Optional<Broker> broker = repository.findById(id);
        broker.get().setState(state);
        return transformer.toBrokerResponse(repository.save(broker.get()));
    }




    @Transactional(rollbackFor = Exception.class)
    public void delete(long id) {
        repository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public Page<BrokerResponse> getBrokers(BrokerFilterRequest request) {
        logger.info("Get brokers with filter request = {}", request);

        Pageable pageable = PageUtils.createPageable(request.getPageIndex(), request.getPageSize(), request.getSortBy());

        List<Broker> brokers = repository.findAllByProperties(request);
        List<BrokerResponse> responses = brokers
                .stream()
                .map(transformer::toBrokerResponse)
                .collect(Collectors.toList());

        return new PageImpl<>(responses);
    }

    public Page<BrokerResponse> getBrokersInternal(BrokerFilterRequest filterRequest) {
        logger.info("Get brokers Internal with filter request = {}", filterRequest);

        Pageable pageable = PageUtils.createPageable(filterRequest.getPageIndex(), filterRequest.getPageSize(), filterRequest.getSortBy());

        List<Broker> brokers = repository.findAll(BrokerSpecification.withFilterFull(filterRequest), pageable).getContent();
        List<BrokerResponse> responses = brokers
                .stream()
                .map(transformer::toBrokerResponse)
                .collect(Collectors.toList());

        return new PageImpl<>(responses);
    }

    @Transactional(rollbackFor = Exception.class)
    public BrokerResponse getBrokerByCustomerId(String customerId) {
        Broker broker = getByCustomerId(customerId);

        if (Objects.nonNull(broker))
            return transformer.toBrokerResponse(broker);

        return null;
    }

    private void copyOldToNewBroker(Broker oldBroker, Broker newBroker) {
        Field[] fieldOldBrokers = oldBroker.getClass().getDeclaredFields();
        Field[] fieldNewBrokers = newBroker.getClass().getDeclaredFields();

        try {
            for (int i = 0; i < fieldNewBrokers.length; i++) {
                Field field = fieldOldBrokers[i];
                String name = field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
                String methodGet = "get" + name;
                Method methodOld = oldBroker.getClass().getMethod(methodGet);
                Method methodNew = newBroker.getClass().getMethod(methodGet);
                if (methodNew.invoke(newBroker) == null && methodOld.invoke(oldBroker) != null) {
                    fieldNewBrokers[i].setAccessible(true);
                    fieldNewBrokers[i].set(newBroker, methodNew.invoke(oldBroker));
                }
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}
