package cn.ztejjx.memberstore.domain.mysql;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


//@Data
//@NoArgsConstructor
//@AllArgsConstructor
@TableName("memberInfo")
public class memberInfo  extends Model<memberInfo> implements Serializable {

    private String memberId;

    private String memberName;

    private String memberPhone;

    private String memberType;

    private String memberIdcard;

    private Integer memberIntegral;

    private Integer enabledFlag;

    private Date createdDate;

    private String openid;

    private String remark;

    private String memberSource;

    private String memberImageurl;

    private String memberPosition;

    private String memberDept;

    private String wecharNumber;

    private String email;

    private String deptAddress;

    private String lastUpdatedBy;

    private Date lastUpdatedDate;

    private String createdBy;

    private String applymodels;

    private String dept;

    private Integer visitCount;

    private Integer shareCount;

    private Integer voteNum;

    public Integer getVoteNum() {
        return voteNum;
    }

    public void setVoteNum(Integer voteNum) {
        this.voteNum = voteNum;
    }

    public Integer getShareCount() {
        return shareCount;
    }

    public void setShareCount(Integer shareCount) {
        this.shareCount = shareCount;
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

    public String getMemberPhone() {
        return memberPhone;
    }

    public void setMemberPhone(String memberPhone) {
        this.memberPhone = memberPhone;
    }

    public String getMemberType() {
        return memberType;
    }

    public void setMemberType(String memberType) {
        this.memberType = memberType;
    }

    public String getMemberIdcard() {
        return memberIdcard;
    }

    public void setMemberIdcard(String memberIdcard) {
        this.memberIdcard = memberIdcard;
    }

    public Integer getMemberIntegral() {
        return memberIntegral;
    }

    public void setMemberIntegral(Integer memberIntegral) {
        this.memberIntegral = memberIntegral;
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

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getMemberSource() {
        return memberSource;
    }

    public void setMemberSource(String memberSource) {
        this.memberSource = memberSource;
    }

    public String getMemberImageurl() {
        return memberImageurl;
    }

    public void setMemberImageurl(String memberImageurl) {
        this.memberImageurl = memberImageurl;
    }

    public String getMemberPosition() {
        return memberPosition;
    }

    public void setMemberPosition(String memberPosition) {
        this.memberPosition = memberPosition;
    }

    public String getMemberDept() {
        return memberDept;
    }

    public void setMemberDept(String memberDept) {
        this.memberDept = memberDept;
    }

    public String getWecharNumber() {
        return wecharNumber;
    }

    public void setWecharNumber(String wecharNumber) {
        this.wecharNumber = wecharNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDeptAddress() {
        return deptAddress;
    }

    public void setDeptAddress(String deptAddress) {
        this.deptAddress = deptAddress;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy;
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getApplymodels() {
        return applymodels;
    }

    public void setApplymodels(String applymodels) {
        this.applymodels = applymodels;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public Integer getVisitCount() {
        return visitCount;
    }

    public void setVisitCount(Integer visitCount) {
        this.visitCount = visitCount;
    }

    @Override
    public String toString() {
        return "memberInfo{" +
                "memberId='" + memberId + '\'' +
                ", memberName='" + memberName + '\'' +
                ", memberPhone='" + memberPhone + '\'' +
                ", memberType='" + memberType + '\'' +
                ", memberIdcard='" + memberIdcard + '\'' +
                ", memberIntegral=" + memberIntegral +
                ", enabledFlag=" + enabledFlag +
                ", createdDate=" + createdDate +
                ", openid='" + openid + '\'' +
                ", remark='" + remark + '\'' +
                ", memberSource='" + memberSource + '\'' +
                ", memberImageurl='" + memberImageurl + '\'' +
                ", memberPosition='" + memberPosition + '\'' +
                ", memberDept='" + memberDept + '\'' +
                ", wecharNumber='" + wecharNumber + '\'' +
                ", email='" + email + '\'' +
                ", deptAddress='" + deptAddress + '\'' +
                ", lastUpdatedBy='" + lastUpdatedBy + '\'' +
                ", lastUpdatedDate=" + lastUpdatedDate +
                ", createdBy='" + createdBy + '\'' +
                ", applymodels='" + applymodels + '\'' +
                ", dept='" + dept + '\'' +
                ", visitCount=" + visitCount +
                ", shareCount=" + shareCount +
                '}';
    }
}
