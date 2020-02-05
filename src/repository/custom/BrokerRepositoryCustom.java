package repository.custom;

import org.springframework.data.domain.Pageable;
import vn.com.vndirect.brokerinsight.model.entity.Broker;
import vn.com.vndirect.brokerinsight.model.request.BrokerFilterRequest;

import java.util.List;

public interface BrokerRepositoryCustom {
    List<Broker> findAllByProperties(BrokerFilterRequest brokerFilterRequest);

    long countAllByProperties(BrokerFilterRequest brokerFilterRequest);

    List<Broker> findBrokersBy(String userName, String status, String type, Pageable pageable);
}
