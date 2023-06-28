package cn.ztejjx.memberstore.domain.mysql;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;



@TableName("registerinfo")
public class registerinfo  extends Model<registerinfo> implements Serializable{

    private String registerinfoId;

    private String projectsintroductionId;

    private Integer projectsintroductionType;

    private String projectsitemName;

    private String remark;

    private String username;

    private String phone;

    @JsonIgnore
    private Integer enabledFlag;

    @JsonFormat(pattern="yyyy-MM-dd",timezone = "GMT+8")
    private Date createdDate;

    private String memberId;

    private String memberName;

    private String memberDept;

    private String projectsclassname;

    private String dept;

    private String memberPosition;

    private String memberType;

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getMemberPosition() {
        return memberPosition;
    }

    public void setMemberPosition(String memberPosition) {
        this.memberPosition = memberPosition;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public String getProjectsclassname() {
        return projectsclassname;
    }

    public void setProjectsclassname(String projectsclassname) {
        this.projectsclassname = projectsclassname;
    }

    public String getRegisterinfoId() {
        return registerinfoId;
    }

    public void setRegisterinfoId(String registerinfoId) {
        this.registerinfoId = registerinfoId;
    }

    public String getProjectsintroductionId() {
        return projectsintroductionId;
    }

    public void setProjectsintroductionId(String projectsintroductionId) {
        this.projectsintroductionId = projectsintroductionId;
    }

    public Integer getProjectsintroductionType() {
        return projectsintroductionType;
    }

    public void setProjectsintroductionType(Integer projectsintroductionType) {
        this.projectsintroductionType = projectsintroductionType;
    }

    public String getProjectsitemName() {
        return projectsitemName;
    }

    public void setProjectsitemName(String projectsitemName) {
        this.projectsitemName = projectsitemName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberDept() {
        return memberDept;
    }

    public void setMemberDept(String memberDept) {
        this.memberDept = memberDept;
    }


    @Override
    public String toString() {
        return "registerinfo{" +
                "registerinfoId='" + registerinfoId + '\'' +
                ", projectsintroductionId='" + projectsintroductionId + '\'' +
                ", projectsintroductionType=" + projectsintroductionType +
                ", projectsitemName='" + projectsitemName + '\'' +
                ", remark='" + remark + '\'' +
                ", username='" + username + '\'' +
                ", phone='" + phone + '\'' +
                ", enabledFlag=" + enabledFlag +
                ", createdDate=" + createdDate +
                ", memberId='" + memberId + '\'' +
                ", memberName='" + memberName + '\'' +
                ", memberDept='" + memberDept + '\'' +
                ", projectsclassname='" + projectsclassname + '\'' +
                ", dept='" + dept + '\'' +
                ", memberPosition='" + memberPosition + '\'' +
                ", memberType='" + memberType + '\'' +
                '}';
    }
}
