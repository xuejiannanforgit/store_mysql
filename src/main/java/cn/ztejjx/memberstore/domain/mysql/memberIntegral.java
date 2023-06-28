package cn.ztejjx.memberstore.domain.mysql;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
@TableName("memberIntegral")
public class memberIntegral  extends Model<memberIntegral> implements Serializable {

    private String integralId;

    private String integralType;

    private BigDecimal integralNum;

    private String memberId;

    private String memberName;

    private String memberPhone;

    private String addintegralReason;

    private String applicationItems;

    private String orderId;

    private Integer enabledFlag;

    private Date createdDate;

    private String remark;

    private String lastUpdatedBy;

    private Date lastUpdatedDate;

    public String getIntegralId() {
        return integralId;
    }

    public void setIntegralId(String integralId) {
        this.integralId = integralId;
    }

    public String getIntegralType() {
        return integralType;
    }

    public void setIntegralType(String integralType) {
        this.integralType = integralType;
    }

    public BigDecimal getIntegralNum() {
        return integralNum;
    }

    public void setIntegralNum(BigDecimal integralNum) {
        this.integralNum = integralNum;
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

    public String getAddintegralReason() {
        return addintegralReason;
    }

    public void setAddintegralReason(String addintegralReason) {
        this.addintegralReason = addintegralReason;
    }

    public String getApplicationItems() {
        return applicationItems;
    }

    public void setApplicationItems(String applicationItems) {
        this.applicationItems = applicationItems;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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
}
