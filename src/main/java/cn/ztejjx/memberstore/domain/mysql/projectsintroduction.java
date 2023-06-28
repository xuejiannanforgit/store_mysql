package cn.ztejjx.memberstore.domain.mysql;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;



@TableName("projectsintroduction")
public class projectsintroduction implements Serializable {
    private String projectsintroductionId;

    private String projectsitemId;

    private Integer projectsintroductionType;

    private String driveNote;

    private String driveContent;

    private String driveProcess;

    private String driveExamnote;

    private String projectsitemName;

    private String applicationFee;

    private Integer applicationFeetype;

    private String trainingDays;

    private String examDays;

    private String lodging;

    private String documentType;

    private String note;

    private String remark;

    @JsonIgnore
    private Integer enabledFlag;

    @JsonIgnore
    private Date createdDate;

    public String getProjectsintroductionId() {
        return projectsintroductionId;
    }

    public void setProjectsintroductionId(String projectsintroductionId) {
        this.projectsintroductionId = projectsintroductionId;
    }

    public String getProjectsitemId() {
        return projectsitemId;
    }

    public void setProjectsitemId(String projectsitemId) {
        this.projectsitemId = projectsitemId;
    }

    public Integer getProjectsintroductionType() {
        return projectsintroductionType;
    }

    public void setProjectsintroductionType(Integer projectsintroductionType) {
        this.projectsintroductionType = projectsintroductionType;
    }

    public String getDriveNote() {
        return driveNote;
    }

    public void setDriveNote(String driveNote) {
        this.driveNote = driveNote;
    }

    public String getDriveContent() {
        return driveContent;
    }

    public void setDriveContent(String driveContent) {
        this.driveContent = driveContent;
    }

    public String getDriveProcess() {
        return driveProcess;
    }

    public void setDriveProcess(String driveProcess) {
        this.driveProcess = driveProcess;
    }

    public String getDriveExamnote() {
        return driveExamnote;
    }

    public void setDriveExamnote(String driveExamnote) {
        this.driveExamnote = driveExamnote;
    }



    public String getProjectsitemName() {
        return projectsitemName;
    }

    public void setProjectsitemName(String projectsitemName) {
        this.projectsitemName = projectsitemName;
    }

    public String getApplicationFee() {
        return applicationFee;
    }

    public void setApplicationFee(String applicationFee) {
        this.applicationFee = applicationFee;
    }

    public Integer getApplicationFeetype() {
        return applicationFeetype;
    }

    public void setApplicationFeetype(Integer applicationFeetype) {
        this.applicationFeetype = applicationFeetype;
    }

    public String getTrainingDays() {
        return trainingDays;
    }

    public void setTrainingDays(String trainingDays) {
        this.trainingDays = trainingDays;
    }

    public String getExamDays() {
        return examDays;
    }

    public void setExamDays(String examDays) {
        this.examDays = examDays;
    }

    public String getLodging() {
        return lodging;
    }

    public void setLodging(String lodging) {
        this.lodging = lodging;
    }

    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }



    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getEnabledFlag() {
        return enabledFlag;
    }

    public void setEnabledFlag(Integer enabledFlag) {
        this.enabledFlag = enabledFlag;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
