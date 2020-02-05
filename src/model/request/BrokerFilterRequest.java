package model.request;

import vn.com.vndirect.brokerinsight.common.converter.GenderConverter;
import vn.com.vndirect.brokerinsight.common.type.Gender;

import javax.persistence.Convert;

public class BrokerFilterRequest extends CommonFilterRequest {
    private Integer fromAge;
    private Integer toAge;
    private String userName;
    @Convert(converter = GenderConverter.class)
    private Gender gender;
    private String location;
    private String status = "A";
    private String groupId;
    private String brokerType;
    private String hrCode;
    private String careByGroupId;
    private String brokerCustomerId;
    private String specializeAnalytics;
    private Integer experience;
    private String department;
    private String brokerId;

    public Integer getFromAge() {
        return fromAge;
    }

    public void setFromAge(Integer fromAge) {
        this.fromAge = fromAge;
    }

    public Integer getToAge() {
        return toAge;
    }

    public void setToAge(Integer toAge) {
        this.toAge = toAge;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSpecializeAnalytics() {
        return specializeAnalytics;
    }

    public void setSpecializeAnalytics(String specializeAnalytics) {
        this.specializeAnalytics = specializeAnalytics;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getBrokerType() {
        return brokerType;
    }

    public void setBrokerType(String brokerType) {
        this.brokerType = brokerType;
    }

    public String getHrCode() {
        return hrCode;
    }

    public void setHrCode(String hrCode) {
        this.hrCode = hrCode;
    }

    public String getCareByGroupId() {
        return careByGroupId;
    }

    public void setCareByGroupId(String careByGroupId) {
        this.careByGroupId = careByGroupId;
    }

    public String getBrokerCustomerId() {
        return brokerCustomerId;
    }

    public void setBrokerCustomerId(String brokerCustomerId) {
        this.brokerCustomerId = brokerCustomerId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getBrokerId() {
        return brokerId;
    }

    public void setBrokerId(String brokerId) {
        this.brokerId = brokerId;
    }
}
