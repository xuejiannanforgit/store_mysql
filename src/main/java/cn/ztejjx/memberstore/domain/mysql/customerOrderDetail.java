package cn.ztejjx.memberstore.domain.mysql;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;


@TableName("customer_order_detail")
public class customerOrderDetail implements Serializable {
    private String orderDetailId;

    private String orderId;

    private String customerId;

    private String customerPhone;

    private String customerName;

    private String openid;

    private String productId;

    private BigDecimal num;

    private BigDecimal costprice;

    private BigDecimal clubprice;

    private BigDecimal retailprice;

    private BigDecimal sumretailprice;

    private BigDecimal sumcostprice;

    private String supplierid;

    private String suppliername;

    private String productclassifyid;

    private String productspecification;

    private String productbrandsid;

    private String productbrands;

    private String productunit;

    private String productname;

    private String productcoverimg;

    private String productbarcode;

    private Integer enabledFlag;

    private Date createdDate;

    private String createdBy;

    private String lastUpdatedBy;

    private Date lastUpdatedDate;

    private String remark;

    private String orderConfirmEmployeeid;

    private String orderConfirmEmployeename;

    private String orderConfirmEmployeephone;

    private String verificationCode;

    private String verificationCodeUrl;

    private String customerDept;

    private String belongDept; //归属业务部门（驾驶培训，建筑培训，洗停车。。。）

    private String productType; //商品类型，优惠卷，礼品....

    private BigDecimal couponPrice;  //优惠卷抵扣金额

    private String useDept;  //优惠卷使用分校（驾驶培训）

    private String useStdclass;  //优惠卷使用班型（驾驶培训）

    private String useApplymodel;  //优惠卷使用车型（驾驶培训）
    @JsonFormat(pattern = "yyyy-MM-dd",locale="zh",timezone="GMT+8")
    private Date startDate;  //有效期起
    @JsonFormat(pattern = "yyyy-MM-dd",locale="zh",timezone="GMT+8")
    private Date endStart;   //有效期止

    private String verificationStatus; //核销状态

    public String getVerificationStatus() {
        return verificationStatus;
    }

    public void setVerificationStatus(String verificationStatus) {
        this.verificationStatus = verificationStatus;
    }

    public String getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(String orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public BigDecimal getNum() {
        return num;
    }

    public void setNum(BigDecimal num) {
        this.num = num;
    }

    public BigDecimal getCostprice() {
        return costprice;
    }

    public void setCostprice(BigDecimal costprice) {
        this.costprice = costprice;
    }

    public BigDecimal getClubprice() {
        return clubprice;
    }

    public void setClubprice(BigDecimal clubprice) {
        this.clubprice = clubprice;
    }

    public BigDecimal getRetailprice() {
        return retailprice;
    }

    public void setRetailprice(BigDecimal retailprice) {
        this.retailprice = retailprice;
    }

    public BigDecimal getSumretailprice() {
        return sumretailprice;
    }

    public void setSumretailprice(BigDecimal sumretailprice) {
        this.sumretailprice = sumretailprice;
    }

    public BigDecimal getSumcostprice() {
        return sumcostprice;
    }

    public void setSumcostprice(BigDecimal sumcostprice) {
        this.sumcostprice = sumcostprice;
    }

    public String getSupplierid() {
        return supplierid;
    }

    public void setSupplierid(String supplierid) {
        this.supplierid = supplierid;
    }

    public String getSuppliername() {
        return suppliername;
    }

    public void setSuppliername(String suppliername) {
        this.suppliername = suppliername;
    }

    public String getProductclassifyid() {
        return productclassifyid;
    }

    public void setProductclassifyid(String productclassifyid) {
        this.productclassifyid = productclassifyid;
    }

    public String getProductspecification() {
        return productspecification;
    }

    public void setProductspecification(String productspecification) {
        this.productspecification = productspecification;
    }

    public String getProductbrandsid() {
        return productbrandsid;
    }

    public void setProductbrandsid(String productbrandsid) {
        this.productbrandsid = productbrandsid;
    }

    public String getProductbrands() {
        return productbrands;
    }

    public void setProductbrands(String productbrands) {
        this.productbrands = productbrands;
    }

    public String getProductunit() {
        return productunit;
    }

    public void setProductunit(String productunit) {
        this.productunit = productunit;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public String getProductcoverimg() {
        return productcoverimg;
    }

    public void setProductcoverimg(String productcoverimg) {
        this.productcoverimg = productcoverimg;
    }

    public String getProductbarcode() {
        return productbarcode;
    }

    public void setProductbarcode(String productbarcode) {
        this.productbarcode = productbarcode;
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

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getOrderConfirmEmployeeid() {
        return orderConfirmEmployeeid;
    }

    public void setOrderConfirmEmployeeid(String orderConfirmEmployeeid) {
        this.orderConfirmEmployeeid = orderConfirmEmployeeid;
    }

    public String getOrderConfirmEmployeename() {
        return orderConfirmEmployeename;
    }

    public void setOrderConfirmEmployeename(String orderConfirmEmployeename) {
        this.orderConfirmEmployeename = orderConfirmEmployeename;
    }

    public String getVerificationCode() {
        return verificationCode;
    }

    public void setVerificationCode(String verificationCode) {
        this.verificationCode = verificationCode;
    }

    public String getVerificationCodeUrl() {
        return verificationCodeUrl;
    }

    public void setVerificationCodeUrl(String verificationCodeUrl) {
        this.verificationCodeUrl = verificationCodeUrl;
    }

    public String getCustomerDept() {
        return customerDept;
    }

    public void setCustomerDept(String customerDept) {
        this.customerDept = customerDept;
    }

    public String getBelongDept() {
        return belongDept;
    }

    public void setBelongDept(String belongDept) {
        this.belongDept = belongDept;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public BigDecimal getCouponPrice() {
        return couponPrice;
    }

    public void setCouponPrice(BigDecimal couponPrice) {
        this.couponPrice = couponPrice;
    }

    public String getUseDept() {
        return useDept;
    }

    public void setUseDept(String useDept) {
        this.useDept = useDept;
    }

    public String getUseStdclass() {
        return useStdclass;
    }

    public void setUseStdclass(String useStdclass) {
        this.useStdclass = useStdclass;
    }

    public String getUseApplymodel() {
        return useApplymodel;
    }

    public void setUseApplymodel(String useApplymodel) {
        this.useApplymodel = useApplymodel;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndStart() {
        return endStart;
    }

    public void setEndStart(Date endStart) {
        this.endStart = endStart;
    }

    public String getOrderConfirmEmployeephone() {
        return orderConfirmEmployeephone;
    }

    public void setOrderConfirmEmployeephone(String orderConfirmEmployeephone) {
        this.orderConfirmEmployeephone = orderConfirmEmployeephone;
    }

    @Override
    public String toString() {
        return "customerOrderDetail{" +
                "orderDetailId='" + orderDetailId + '\'' +
                ", orderId='" + orderId + '\'' +
                ", customerId='" + customerId + '\'' +
                ", customerPhone='" + customerPhone + '\'' +
                ", customerName='" + customerName + '\'' +
                ", openid='" + openid + '\'' +
                ", productId='" + productId + '\'' +
                ", num=" + num +
                ", costprice=" + costprice +
                ", clubprice=" + clubprice +
                ", retailprice=" + retailprice +
                ", sumretailprice=" + sumretailprice +
                ", sumcostprice=" + sumcostprice +
                ", supplierid='" + supplierid + '\'' +
                ", suppliername='" + suppliername + '\'' +
                ", productclassifyid='" + productclassifyid + '\'' +
                ", productspecification='" + productspecification + '\'' +
                ", productbrandsid='" + productbrandsid + '\'' +
                ", productbrands='" + productbrands + '\'' +
                ", productunit='" + productunit + '\'' +
                ", productname='" + productname + '\'' +
                ", productcoverimg='" + productcoverimg + '\'' +
                ", productbarcode='" + productbarcode + '\'' +
                ", enabledFlag=" + enabledFlag +
                ", createdDate=" + createdDate +
                ", createdBy='" + createdBy + '\'' +
                ", lastUpdatedBy='" + lastUpdatedBy + '\'' +
                ", lastUpdatedDate=" + lastUpdatedDate +
                ", remark='" + remark + '\'' +
                ", orderConfirmEmployeeid='" + orderConfirmEmployeeid + '\'' +
                ", orderConfirmEmployeename='" + orderConfirmEmployeename + '\'' +
                ", verificationCode='" + verificationCode + '\'' +
                ", verificationCodeUrl='" + verificationCodeUrl + '\'' +
                ", customerDept='" + customerDept + '\'' +
                ", belongDept='" + belongDept + '\'' +
                ", productType='" + productType + '\'' +
                ", couponPrice=" + couponPrice +
                ", useDept='" + useDept + '\'' +
                ", useStdclass='" + useStdclass + '\'' +
                ", useApplymodel='" + useApplymodel + '\'' +
                ", startDate=" + startDate +
                ", endStart=" + endStart +
                ", verificationStatus='" + verificationStatus + '\'' +
                '}';
    }
}