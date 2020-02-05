package model.specifications;

import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.data.jpa.domain.Specification;
import vn.com.vndirect.brokerinsight.common.type.Gender;
import vn.com.vndirect.brokerinsight.model.entity.Broker;
import vn.com.vndirect.brokerinsight.model.request.BrokerFilterRequest;

import java.time.LocalDate;

public final class BrokerSpecification {

     public static final int LEVEL_1 = 0;
    public static final int LEVEL_2 = 1;
    public static final int LEVEL_3 = 2;
    public static final int LEVEL_4 = 3;

    private BrokerSpecification() {
    }

    public static Specification<Broker> withFilter(BrokerFilterRequest filter) {

        return Specification.where(
                withFromAge(filter.getFromAge()))
                .and(withToAge(filter.getToAge()))
                .and(withGender(filter.getGender()))
                .and(withLocation(filter.getLocation()))
                .and(withExperience(filter.getExperience()))
                .and(withStatus(filter.getStatus()))
                .and(withGroupId(filter.getGroupId()))
                .and(withCareByGroupId(filter.getCareByGroupId()))
                .and(withCustomerId(filter.getBrokerCustomerId()))
                .and(withHrCode(filter.getHrCode()))
                .and(withBrokerType(filter.getBrokerType()));
    }

    public static Specification<Broker> withFilterFull(BrokerFilterRequest filter) {

        return Specification.where(withBrokerUserName(filter.getUserName()))
                .and(withGender(filter.getGender()))
                .and(withLocation(filter.getLocation()))
                .and(withStatus(filter.getStatus()))
                .and(withGroupId(filter.getGroupId()))
                .and(withCareByGroupId(filter.getCareByGroupId()))
                .and(withCustomerId(filter.getBrokerCustomerId()))
                .and(withHrCode(filter.getHrCode()))
                .and(withBrokerId(filter.getBrokerId()))
                .and(withDepartment(filter.getDepartment()));
    }


    public static Specification<Broker> withFilterBroker(BrokerFilterRequest filter) {
        return Specification.where(withBrokerUserName(filter.getUserName()))
                .and(withBrokerType(filter.getBrokerType()))
                .and(withStatus(filter.getStatus()));
    }

    public static Specification<Broker> withFilterBrokerLike(BrokerFilterRequest filter){
        return Specification.where(withBrokerUserNameLike(filter.getUserName()))
                .and(withBrokerType(filter.getBrokerType()))
                .and(withStatus(filter.getStatus()));
    }

    private static Specification<Broker> withFromAge(Integer fromAge) {
        if (fromAge == null) return null;

        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.lessThanOrEqualTo(
                criteriaBuilder.function("YEAR", Integer.class, root.get("dob")), LocalDate.now().getYear() - fromAge);
    }

    private static Specification<Broker> withToAge(Integer toAge) {
        if (toAge == null) return null;

        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(
                criteriaBuilder.function("YEAR", Integer.class, root.get("dob")), LocalDate.now().getYear() - toAge);
    }

    private static Specification<Broker> withGender(Gender gender) {
        if (gender == null) return null;

        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("gender"), gender);
    }

    private static Specification<Broker> withBrokerId(String brokerId) {
        if (brokerId == null) return null;

        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("brokerId"), brokerId);
    }

    private static Specification<Broker> withStatus(String status) {
        if (status == null) return null;

        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("status"), status);
    }

    private static Specification<Broker> withLocation(String location) {
        if (location == null) return null;

        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("location"), location);

    }

    private static Specification<Broker> withDepartment(String department) {
        if (department == null) return null;

        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("department"), department);

    }

    private static Specification<Broker> withCareByGroupId(String careByGroupId) {
        if (careByGroupId == null) return null;

        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("careByGroupId"), careByGroupId);
    }

    private static Specification<Broker> withGroupId(String groupId) {
        if (groupId == null) return null;

        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("groupId"), groupId);
    }

    private static Specification<Broker> withHrCode(String hrCode) {
        if (hrCode == null) return null;

        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("hrCode"), hrCode);
    }

    private static Specification<Broker> withCustomerId(String brokerCustomerId) {
        if (brokerCustomerId == null) return null;

        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("brokerCustomerId"), brokerCustomerId);
    }

    private static Specification<Broker> withBrokerType(String brokerType) {
        if (brokerType == null) return null;

        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("brokerType"), brokerType);
    }

    private static Specification<Broker> withBrokerUserName(String userName) {
        if (userName == null) return null;

        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("brokerUserName"), userName);
    }

    private static Specification<Broker> withBrokerUserNameLike(String userName){
        if (userName == null) return null;

        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.like(root.get("brokerUserName"), userName);
    }


    private static Specification<Broker> withExperience(Integer experience) {
        if (experience == null) return null;

        switch (experience) {
            case LEVEL_1:
                return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.between(root.get("experience"), 1, 2);
            case LEVEL_2:
                return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.between(root.get("experience"), 3, 5);
            case LEVEL_3:
                return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.between(root.get("experience"), 6, 10);
            case LEVEL_4:
                return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.greaterThan(root.get("experience"), 10);
            default:
                return null;
        }

    }

    private static Specification<Broker> withSpecializeAnalytics(String key) {
        if (key == null) return null;

        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.isTrue(
                criteriaBuilder.function(
                        "jsonb_exists",
                        Boolean.class,
                        root.<JsonNode>get("specializeAnalytics"),
                        criteriaBuilder.literal(key)
                ));
    }
}
