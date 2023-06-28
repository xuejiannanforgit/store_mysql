package cn.ztejjx.memberstore.domain.mysql;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;



@TableName("customer_order")
public class customerOrder implements Serializable {
    private String orderId;

    private Integer enabledFlag;

    private String createdBy;

    private Date createdDate;

    private String lastUpdatedBy;

    private Date lastUpdatedDate;

    private String remark;

    private String openid;

    private String nickname;

    private String avatarurl;

    private String customerName;

    private String customerAddress;

    private String customerPhone;

    private String customerId;


    private BigDecimal integralAmount;

    private String orderNum;

    private String orderStatus;

    @JsonFormat(pattern = "yyyy-MM-dd",locale="zh",timezone="GMT+8")
    private Date payTime;

    private String orderConfirmEmployeeid;

    private String orderConfirmEmployeename;

    private String payType;

    private String orderTitle;

    private String orderType;

    private String customerDept;

    private BigDecimal customerIntegral;

    private BigDecimal customerIntegralbalance;

   private List<customerOrderDetail> customerOrderDetaillist;

    public List<customerOrderDetail> getCustomerOrderDetaillist() {
        return customerOrderDetaillist;
    }

    public void setCustomerOrderDetaillist(List<customerOrderDetail> customerOrderDetaillist) {
        this.customerOrderDetaillist = customerOrderDetaillist;
    }

    public String getCustomerDept() {
        return customerDept;
    }

    public void setCustomerDept(String customerDept) {
        this.customerDept = customerDept;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public Integer getEnabledFlag() {
        return enabledFlag;
    }

    public void setEnabledFlag(Integer enabledFlag) {
        this.enabledFlag = enabledFlag;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getLastUpdatedBy() {
        return lastUpdatedBy;
    }

    public void setLastUpdatedBy(String lastUpdatedBy) {
        this.lastUpdatedBy = lastUpdatedBy == null ? null : lastUpdatedBy.trim();
    }

    public Date getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Date lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    public String getAvatarurl() {
        return avatarurl;
    }

    public void setAvatarurl(String avatarurl) {
        this.avatarurl = avatarurl == null ? null : avatarurl.trim();
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress == null ? null : customerAddress.trim();
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone == null ? null : customerPhone.trim();
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId == null ? null : customerId.trim();
    }

    public BigDecimal getIntegralAmount() {
        return integralAmount;
    }

    public void setIntegralAmount(BigDecimal integralAmount) {
        this.integralAmount = integralAmount;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum == null ? null : orderNum.trim();
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus == null ? null : orderStatus.trim();
    }

    public Date getPayTime() {
        return payTime;
    }

    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }

    public String getOrderConfirmEmployeeid() {
        return orderConfirmEmployeeid;
    }

    public void setOrderConfirmEmployeeid(String orderConfirmEmployeeid) {
        this.orderConfirmEmployeeid = orderConfirmEmployeeid == null ? null : orderConfirmEmployeeid.trim();
    }

    public String getOrderConfirmEmployeename() {
        return orderConfirmEmployeename;
    }

    public void setOrderConfirmEmployeename(String orderConfirmEmployeename) {
        this.orderConfirmEmployeename = orderConfirmEmployeename == null ? null : orderConfirmEmployeename.trim();
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType == null ? null : payType.trim();
    }

    public String getOrderTitle() {
        return orderTitle;
    }

    public void setOrderTitle(String orderTitle) {
        this.orderTitle = orderTitle == null ? null : orderTitle.trim();
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType == null ? null : orderType.trim();
    }

    public BigDecimal getCustomerIntegral() {
        return customerIntegral;
    }

    public void setCustomerIntegral(BigDecimal customerIntegral) {
        this.customerIntegral = customerIntegral;
    }

    public BigDecimal getCustomerIntegralbalance() {
        return customerIntegralbalance;
    }

    public void setCustomerIntegralbalance(BigDecimal customerIntegralbalance) {
        this.customerIntegralbalance = customerIntegralbalance;
    }
}