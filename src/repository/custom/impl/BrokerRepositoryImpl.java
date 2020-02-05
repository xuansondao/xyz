package repository.custom.impl;

import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import vn.com.vndirect.brokerinsight.model.entity.Broker;
import vn.com.vndirect.brokerinsight.model.request.BrokerFilterRequest;
import vn.com.vndirect.brokerinsight.repository.custom.BrokerRepositoryCustom;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.List;

@Repository
public class BrokerRepositoryImpl implements BrokerRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    public static final int LEVEL_1 = 0;
    public static final int LEVEL_2 = 1;
    public static final int LEVEL_3 = 2;
    public static final int LEVEL_4 = 3;

    @Override
    public List<Broker> findAllByProperties(BrokerFilterRequest brokerFilterRequest) {
        StringBuilder sql = buildQuery(brokerFilterRequest);
        sql.append(" ORDER BY RANDOM()");

        Query query = entityManager.createNativeQuery(sql.toString(), Broker.class);

        query.setFirstResult(brokerFilterRequest.getPageIndex());
        query.setMaxResults(brokerFilterRequest.getPageSize());

        return query.getResultList();
    }

    @Override
    public long countAllByProperties(BrokerFilterRequest brokerFilterRequest) {
        StringBuilder sql = buildQuery(brokerFilterRequest);

        Query query = entityManager.createNativeQuery(sql.toString());

        return Long.parseLong(query.getSingleResult().toString());
    }

    @Override
    public List<Broker> findBrokersBy(String userName, String status, String type, Pageable pageable) {
        StringBuilder sql = new StringBuilder(" SELECT bro FROM Broker bro WHERE 1 = 1");
        if (userName != null) {
            sql.append(" AND bro.brokerUserName LIKE '%").append(userName).append("%'");
        }
        if (type != null) {
            sql.append(" AND bro.brokerType = '").append(type).append("'");
        }
        sql.append(" AND bro.status = '").append(status).append("'");

        Query query = entityManager.createQuery(sql.toString(), Broker.class);
        query.setFirstResult(pageable.getPageNumber());
        query.setMaxResults(pageable.getPageSize());


        return query.getResultList();
    }

    private StringBuilder buildQuery(BrokerFilterRequest brokerFilterRequest) {
        StringBuilder sql = new StringBuilder(" SELECT * FROM broker WHERE 1 = 1 ");
        if (brokerFilterRequest.getLocation() != null) {
            sql.append(" AND location = '").append(brokerFilterRequest.getLocation()).append("\'");
        }
        if (brokerFilterRequest.getGender() != null) {
            sql.append(" AND gender = '").append(brokerFilterRequest.getGender().getValue()).append("'");
        }
        if (brokerFilterRequest.getFromAge() != null) {
            sql.append(" AND EXTRACT(YEAR FROM dob) <= ").append(LocalDate.now().getYear() - brokerFilterRequest.getFromAge());
        }
        if (brokerFilterRequest.getToAge() != null) {
            sql.append(" AND EXTRACT(YEAR FROM dob) >= ").append(LocalDate.now().getYear() - brokerFilterRequest.getToAge());
        }
        if (brokerFilterRequest.getExperience() != null) {
            switch (brokerFilterRequest.getExperience()) {
                case LEVEL_1:
                    sql.append(" AND experience BETWEEN ").append(1).append(" AND ").append(2);
                    break;
                case LEVEL_2:
                    sql.append(" AND experience BETWEEN ").append(3).append(" AND ").append(5);
                    break;
                case LEVEL_3:
                    sql.append(" AND experience BETWEEN ").append(6).append(" AND ").append(10);
                    break;
                case LEVEL_4:
                    sql.append(" AND experience > 10 ");
                    break;
            }
        }
        if (brokerFilterRequest.getGroupId() != null) {
            sql.append(" AND group_id = '").append(brokerFilterRequest.getGroupId()).append("'");
        }
        if (brokerFilterRequest.getCareByGroupId() != null) {
            sql.append(" AND care_by_group_id = '").append(brokerFilterRequest.getCareByGroupId()).append("'");
        }
        if (brokerFilterRequest.getBrokerCustomerId() != null) {
            sql.append(" AND broker_customer_id = '").append(brokerFilterRequest.getBrokerCustomerId()).append("'");
        }
        if (brokerFilterRequest.getHrCode() != null) {
            sql.append(" AND hr_code != '").append(brokerFilterRequest.getHrCode()).append("'");
        }

        return sql;
    }
}
