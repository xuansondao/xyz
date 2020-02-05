package model.response;

import com.fasterxml.jackson.databind.JsonNode;
import vn.com.vndirect.brokerinsight.common.converter.GenderConverter;
import vn.com.vndirect.brokerinsight.common.converter.JsonNodeConverter;
import vn.com.vndirect.brokerinsight.common.type.Gender;

import javax.persistence.Convert;

public class BrokerResponse {
    private Long id;
    private Long userId;
    private String brokerId;
    private String brokerName;
    @Convert(converter = GenderConverter.class)
    private Gender gender;
    private String brokerUserName;
    private String department;
    private String vndirectMail;
    private String groupId;
    private String groupName;
    private String careByGroupId;
    private String careByGroupName;
    private String dob;
    private String brokerType;
    private String location;
    private Integer experience;
    private String brokerCustomerId;
    private String hrCode;
    private String status;
    @Convert(converter = JsonNodeConverter.class)
    private JsonNode perpective;
    @Convert(converter = JsonNodeConverter.class)
    private JsonNode specializeAnalytics;

    public String getCareByGroupId() {
        return careByGroupId;
    }

    public void setCareByGroupId(String careByGroupId) {
        this.careByGroupId = careByGroupId;
    }

    public String getCareByGroupName() {
        return careByGroupName;
    }

    public void setCareByGroupName(String careByGroupName) {
        this.careByGroupName = careByGroupName;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getBrokerId() {
        return brokerId;
    }

    public void setBrokerId(String brokerId) {
        this.brokerId = brokerId;
    }

    public String getBrokerName() {
        return brokerName;
    }

    public void setBrokerName(String brokerName) {
        this.brokerName = brokerName;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getBrokerUserName() {
        return brokerUserName;
    }

    public void setBrokerUserName(String brokerUserName) {
        this.brokerUserName = brokerUserName;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public JsonNode getSpecializeAnalytics() {
        return specializeAnalytics;
    }

    public void setSpecializeAnalytics(JsonNode specializeAnalytics) {
        this.specializeAnalytics = specializeAnalytics;
    }

    public String getBrokerCustomerId() {
        return brokerCustomerId;
    }

    public void setBrokerCustomerId(String brokerCustomerId) {
        this.brokerCustomerId = brokerCustomerId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getBrokerType() {
        return brokerType;
    }

    public void setBrokerType(String brokerType) {
        this.brokerType = brokerType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHrCode() {
        return hrCode;
    }

    public void setHrCode(String hrCode) {
        this.hrCode = hrCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public JsonNode getPerpective() {
        return perpective;
    }

    public void setPerpective(JsonNode perpective) {
        this.perpective = perpective;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getVndirectMail() {
        return vndirectMail;
    }

    public void setVndirectMail(String vndirectMail) {
        this.vndirectMail = vndirectMail;
    }
}
