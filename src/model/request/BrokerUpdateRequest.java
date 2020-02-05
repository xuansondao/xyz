package model.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.JsonNode;
import vn.com.vndirect.brokerinsight.common.converter.GenderConverter;
import vn.com.vndirect.brokerinsight.common.converter.JsonNodeConverter;
import vn.com.vndirect.brokerinsight.common.type.Gender;

import javax.persistence.Convert;
import java.math.BigDecimal;
import java.time.LocalDate;

public class BrokerUpdateRequest {
    private Long userId;
    private String avatar;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDate dob;
    @Convert(converter = GenderConverter.class)
    private Gender gender;
    private String location;
    private Integer experience;
    private String nav;
    private String reason;
    @Convert(converter = JsonNodeConverter.class)
    private JsonNode service;
    private String consultingExperience;
    private String personalStatus;
    private String perspective;
    @Convert(converter = JsonNodeConverter.class)
    private JsonNode specializeAnalytics;
    private String brokerName;
    private String brokerUserName;
    private String vndirectMail;
    private String mobilePhone;
    private String serviceFee;
    @Convert(converter = JsonNodeConverter.class)
    private JsonNode relations;
    private String brokerId;
    private String brokerCustomerId;
    private BigDecimal consultingSkill;
    private BigDecimal communicatingSkill;
    private BigDecimal evaluatingSkill;
    private String stockTradingMajor;
    private String derivativeTradingMajor;
    private String bondMajor;
    private String fundMajor;
    private Integer customerTotal;
    private BigDecimal navTotal;
    private BigDecimal monthlyFee;
    private BigDecimal customerTransactionFee;
    private Integer pendingTask;
    private Integer pendingCrossSales;
    private Integer upsalesService;
    private Integer activeCustomers;
    private String hrCode;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDate joinDate;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDate leaveDate;
    private String education;
    private String jobTitle;
    private String groupName;
    private String groupId;
    private String leader;
    private String director;
    private String status;
    private String brokerLevelId;
    private String brokerLevel;
    private String brokerType;
    private BigDecimal rating;
    private Integer disciplincaryViolation;
    private BigDecimal trainingScore;
    @Convert(converter = JsonNodeConverter.class)
    private JsonNode certificate;
    private String language;
    private String careByGroupId;
    private String careByGroupName;
    private String department;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
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

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public String getNav() {
        return nav;
    }

    public void setNav(String nav) {
        this.nav = nav;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public JsonNode getService() {
        return service;
    }

    public void setService(JsonNode service) {
        this.service = service;
    }

    public String getConsultingExperience() {
        return consultingExperience;
    }

    public void setConsultingExperience(String consultingExperience) {
        this.consultingExperience = consultingExperience;
    }

    public String getPersonalStatus() {
        return personalStatus;
    }

    public void setPersonalStatus(String personalStatus) {
        this.personalStatus = personalStatus;
    }

    public String getPerspective() {
        return perspective;
    }

    public void setPerspective(String perspective) {
        this.perspective = perspective;
    }

    public JsonNode getSpecializeAnalytics() {
        return specializeAnalytics;
    }

    public void setSpecializeAnalytics(JsonNode specializeAnalytics) {
        this.specializeAnalytics = specializeAnalytics;
    }

    public String getBrokerName() {
        return brokerName;
    }

    public void setBrokerName(String brokerName) {
        this.brokerName = brokerName;
    }

    public String getBrokerUserName() {
        return brokerUserName;
    }

    public void setBrokerUserName(String brokerUserName) {
        this.brokerUserName = brokerUserName;
    }

    public String getVndirectMail() {
        return vndirectMail;
    }

    public void setVndirectMail(String vndirectMail) {
        this.vndirectMail = vndirectMail;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }

    public void setMobilePhone(String mobilePhone) {
        this.mobilePhone = mobilePhone;
    }

    public String getServiceFee() {
        return serviceFee;
    }

    public void setServiceFee(String serviceFee) {
        this.serviceFee = serviceFee;
    }

    public JsonNode getRelations() {
        return relations;
    }

    public void setRelations(JsonNode relations) {
        this.relations = relations;
    }

    public String getBrokerId() {
        return brokerId;
    }

    public void setBrokerId(String brokerId) {
        this.brokerId = brokerId;
    }

    public String getBrokerCustomerId() {
        return brokerCustomerId;
    }

    public void setBrokerCustomerId(String brokerCustomerId) {
        this.brokerCustomerId = brokerCustomerId;
    }

    public BigDecimal getConsultingSkill() {
        return consultingSkill;
    }

    public void setConsultingSkill(BigDecimal consultingSkill) {
        this.consultingSkill = consultingSkill;
    }

    public BigDecimal getCommunicatingSkill() {
        return communicatingSkill;
    }

    public void setCommunicatingSkill(BigDecimal communicatingSkill) {
        this.communicatingSkill = communicatingSkill;
    }

    public BigDecimal getEvaluatingSkill() {
        return evaluatingSkill;
    }

    public void setEvaluatingSkill(BigDecimal evaluatingSkill) {
        this.evaluatingSkill = evaluatingSkill;
    }

    public String getStockTradingMajor() {
        return stockTradingMajor;
    }

    public void setStockTradingMajor(String stockTradingMajor) {
        this.stockTradingMajor = stockTradingMajor;
    }

    public String getDerivativeTradingMajor() {
        return derivativeTradingMajor;
    }

    public void setDerivativeTradingMajor(String derivativeTradingMajor) {
        this.derivativeTradingMajor = derivativeTradingMajor;
    }

    public String getBondMajor() {
        return bondMajor;
    }

    public void setBondMajor(String bondMajor) {
        this.bondMajor = bondMajor;
    }

    public String getFundMajor() {
        return fundMajor;
    }

    public void setFundMajor(String fundMajor) {
        this.fundMajor = fundMajor;
    }

    public Integer getCustomerTotal() {
        return customerTotal;
    }

    public void setCustomerTotal(Integer customerTotal) {
        this.customerTotal = customerTotal;
    }

    public BigDecimal getNavTotal() {
        return navTotal;
    }

    public void setNavTotal(BigDecimal navTotal) {
        this.navTotal = navTotal;
    }

    public BigDecimal getMonthlyFee() {
        return monthlyFee;
    }

    public void setMonthlyFee(BigDecimal monthlyFee) {
        this.monthlyFee = monthlyFee;
    }

    public BigDecimal getCustomerTransactionFee() {
        return customerTransactionFee;
    }

    public void setCustomerTransactionFee(BigDecimal customerTransactionFee) {
        this.customerTransactionFee = customerTransactionFee;
    }

    public Integer getPendingTask() {
        return pendingTask;
    }

    public void setPendingTask(Integer pendingTask) {
        this.pendingTask = pendingTask;
    }

    public Integer getPendingCrossSales() {
        return pendingCrossSales;
    }

    public void setPendingCrossSales(Integer pendingCrossSales) {
        this.pendingCrossSales = pendingCrossSales;
    }

    public Integer getUpsalesService() {
        return upsalesService;
    }

    public void setUpsalesService(Integer upsalesService) {
        this.upsalesService = upsalesService;
    }

    public Integer getActiveCustomers() {
        return activeCustomers;
    }

    public void setActiveCustomers(Integer activeCustomers) {
        this.activeCustomers = activeCustomers;
    }

    public String getHrCode() {
        return hrCode;
    }

    public void setHrCode(String hrCode) {
        this.hrCode = hrCode;
    }

    public LocalDate getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(LocalDate joinDate) {
        this.joinDate = joinDate;
    }

    public LocalDate getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(LocalDate leaveDate) {
        this.leaveDate = leaveDate;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getBrokerLevelId() {
        return brokerLevelId;
    }

    public void setBrokerLevelId(String brokerLevelId) {
        this.brokerLevelId = brokerLevelId;
    }

    public String getBrokerLevel() {
        return brokerLevel;
    }

    public void setBrokerLevel(String brokerLevel) {
        this.brokerLevel = brokerLevel;
    }

    public String getBrokerType() {
        return brokerType;
    }

    public void setBrokerType(String brokerType) {
        this.brokerType = brokerType;
    }

    public BigDecimal getRating() {
        return rating;
    }

    public void setRating(BigDecimal rating) {
        this.rating = rating;
    }

    public Integer getDisciplincaryViolation() {
        return disciplincaryViolation;
    }

    public void setDisciplincaryViolation(Integer disciplincaryViolation) {
        this.disciplincaryViolation = disciplincaryViolation;
    }

    public BigDecimal getTrainingScore() {
        return trainingScore;
    }

    public void setTrainingScore(BigDecimal trainingScore) {
        this.trainingScore = trainingScore;
    }

    public JsonNode getCertificate() {
        return certificate;
    }

    public void setCertificate(JsonNode certificate) {
        this.certificate = certificate;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

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

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }
}
