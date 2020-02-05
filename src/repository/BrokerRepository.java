package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import vn.com.vndirect.brokerinsight.model.entity.Broker;
import vn.com.vndirect.brokerinsight.repository.custom.BrokerRepositoryCustom;

import java.util.Optional;

@Repository
public interface BrokerRepository extends JpaRepository<Broker, Long>, JpaSpecificationExecutor<Broker>, BrokerRepositoryCustom {
    Optional<Broker> findByBrokerUserNameIgnoreCaseAndBrokerTypeAndStatus(String userName, String brokerType, String status);

    Optional<Broker> findByBrokerCustomerId(String customerId);

    Optional<Broker> findByBrokerUserNameIgnoreCase(String userName);

    long countAllByVndirectMail(String vndirectMail);

    long countAllByHrCode(String hrCode);

    long countAllByBrokerCustomerId(String brokerCustomerId);

    long countAllByBrokerId(String brokerId);

    long countAllByUserId(Long userId);

    long countAllByBrokerUserName(String userName);
}


