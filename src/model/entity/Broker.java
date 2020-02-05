package model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import vn.com.vndirect.brokerinsight.common.converter.GenderConverter;
import vn.com.vndirect.brokerinsight.common.converter.JsonNodeConverter;
import vn.com.vndirect.brokerinsight.common.type.Gender;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Broker {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "broker_seq")
    @SequenceGenerator(sequenceName = "broker_seq", allocationSize = 1, name = "broker_seq")
    @Column(name = "id")
    private Long id;
    @Column(name = "user_id", unique = true)
    private Long userId;
    @Column(name = "avatar")
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
    @Column(name = "consulting_experience")
    private String consultingExperience;
    @Column(name = "personal_status")
    private String personalStatus;
    private String perspective;
    @Column(name = "specialize_analytics")
    @Convert(converter = JsonNodeConverter.class)
    private JsonNode specializeAnalytics;
    @Column(name = "broker_name")
    private String brokerName;
    @Column(name = "broker_user_name")
    private String brokerUserName;
    @Column(name = "vndirect_mail")
    private String vndirectMail;
    @Column(name = "mobile_phone")
    private String mobilePhone;
    @Column(name = "service_fee")
    private String serviceFee;
    @Column(name = "relations")
    @Convert(converter = JsonNodeConverter.class)
    private JsonNode relations;
    @Column(name = "broker_id")
    private String brokerId;
    @Column(name = "broker_customer_id")
    private String brokerCustomerId;
    @Column(name = "consulting_skill")
    private BigDecimal consultingSkill;
    @Column(name = "communicating_skill")
    private BigDecimal communicatingSkill;
    @Column(name = "evaluating_skill")
    private BigDecimal evaluatingSkill;
    @Column(name = "stock_trading_major")
    private String stockTradingMajor;
    @Column(name = "derivative_trading_major")
    private String derivativeTradingMajor;
    @Column(name = "bond_major")
    private String bondMajor;
    @Column(name = "fundMajor")
    private String fundMajor;
    @Column(name = "customer_total")
    private Integer customerTotal;
    @Column(name = "nav_total")
    private BigDecimal navTotal;
    @Column(name = "monthly_fee")
    private BigDecimal monthlyFee;
    @Column(name = "customer_transaction_fee")
    private BigDecimal customerTransactionFee;
    @Column(name = "pending_task")
    private Integer pendingTask;
    @Column(name = "pending_cross_sales")
    private Integer pendingCrossSales;
    @Column(name = "upsales_service")
    private Integer upsalesService;
    @Column(name = "active_customers")
    private Integer activeCustomers;
    @Column(name = "hr_code")
    private String hrCode;
    @Column(name = "join_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDate joinDate;
    @Column(name = "leave_date")
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDate leaveDate;
    @Column(name = "education")
    private String education;
    @Column(name = "job_title")
    private String jobTitle;
    @Column(name = "group_name")
    private String groupName;
    @Column(name = "group_id")
    private String groupId;
    @Column(name = "leader")
    private String leader;
    @Column(name = "director")
    private String director;
    @Column(name = "status")
    private String status;
    @Column(name = "broker_level_id")
    private String brokerLevelId;
    @Column(name = "broker_level")
    private String brokerLevel;
    @Column(name = "broker_type")
    private String brokerType;
    @Column(name = "rating")
    private BigDecimal rating;
    @Column(name = "disciplincary_violation")
    private Integer disciplincaryViolation;
    @Column(name = "training_score")
    private BigDecimal trainingScore;
    @Convert(converter = JsonNodeConverter.class)
    private JsonNode certificate;
    @Column(name = "language")
    private String language;
    @Column(name = "care_by_group_id")
    private String careByGroupId;
    @Column(name = "care_by_group_name")
    private String careByGroupName;
    @Column(name = "department")
    private String department;
    @Column
    private boolean state;

    @Column(name = "created_date")
    @CreatedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDateTime createdDate;
    @Column(name = "updated_date")
    @LastModifiedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private LocalDateTime updatedDate;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(LocalDateTime updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Broker{" +
                "id=" + id +
                ", userId=" + userId +
                ", avatar='" + avatar + '\'' +
                ", dob=" + dob +
                ", gender=" + gender +
                ", location='" + location + '\'' +
                ", experience=" + experience +
                ", nav='" + nav + '\'' +
                ", reason='" + reason + '\'' +
                ", service=" + service +
                ", consultingExperience='" + consultingExperience + '\'' +
                ", personalStatus='" + personalStatus + '\'' +
                ", perspective='" + perspective + '\'' +
                ", specializeAnalytics=" + specializeAnalytics +
                ", brokerName='" + brokerName + '\'' +
                ", brokerUserName='" + brokerUserName + '\'' +
                ", vndirectMail='" + vndirectMail + '\'' +
                ", mobilePhone='" + mobilePhone + '\'' +
                ", serviceFee='" + serviceFee + '\'' +
                ", relations=" + relations +
                ", brokerId='" + brokerId + '\'' +
                ", brokerCustomerId='" + brokerCustomerId + '\'' +
                ", consultingSkill=" + consultingSkill +
                ", communicatingSkill=" + communicatingSkill +
                ", evaluatingSkill=" + evaluatingSkill +
                ", stockTradingMajor='" + stockTradingMajor + '\'' +
                ", derivativeTradingMajor='" + derivativeTradingMajor + '\'' +
                ", bondMajor='" + bondMajor + '\'' +
                ", fundMajor='" + fundMajor + '\'' +
                ", customerTotal=" + customerTotal +
                ", navTotal=" + navTotal +
                ", monthlyFee=" + monthlyFee +
                ", customerTransactionFee=" + customerTransactionFee +
                ", pendingTask=" + pendingTask +
                ", pendingCrossSales=" + pendingCrossSales +
                ", upsalesService=" + upsalesService +
                ", activeCustomers=" + activeCustomers +
                ", hrCode='" + hrCode + '\'' +
                ", joinDate=" + joinDate +
                ", leaveDate=" + leaveDate +
                ", education='" + education + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", groupName='" + groupName + '\'' +
                ", groupId='" + groupId + '\'' +
                ", leader='" + leader + '\'' +
                ", director='" + director + '\'' +
                ", status='" + status + '\'' +
                ", brokerLevelId='" + brokerLevelId + '\'' +
                ", brokerLevel='" + brokerLevel + '\'' +
                ", brokerType='" + brokerType + '\'' +
                ", rating=" + rating +
                ", disciplincaryViolation=" + disciplincaryViolation +
                ", trainingScore=" + trainingScore +
                ", certificate=" + certificate +
                ", language='" + language + '\'' +
                ", careByGroupId='" + careByGroupId + '\'' +
                ", careByGroupName='" + careByGroupName + '\'' +
                ", department='" + department + '\'' +
                ", createdDate=" + createdDate +
                ", updatedDate=" + updatedDate +
                '}';
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }
}
