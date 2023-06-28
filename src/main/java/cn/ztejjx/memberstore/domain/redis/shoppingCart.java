package cn.ztejjx.memberstore.domain.redis;

import java.math.BigDecimal;
import java.util.Date;

public class shoppingCart {

    private String productId;

    private String openid;

    private String productName;

    private BigDecimal retailPrice;

    private String productClassifyid;

    private String productBrandsid;  //品牌ID

    private String productBrands; //品牌名称

    private String productCoverimg; //封面图片

    private String productDescription; //产品描述

    private BigDecimal clubPrice; //会员价

    private BigDecimal costPrice; //成本价

    private BigDecimal  num  ;       //商品数量

    private String  productBarcode;   //商品编码

    private String  productUnit;  //商品单位

    private String  productSpecification;  //商品规格

    private String  supplierId;  //供应商ID

    private String  supplierName;      //供应商名称

    private BigDecimal productNum;

    private String belongDept; //归属业务部门（驾驶培训，建筑培训，洗停车。。。）

    private String productType; //商品类型，优惠卷，礼品....

    private BigDecimal couponPrice;  //优惠卷抵扣金额

    private String useDept;  //优惠卷使用分校（驾驶培训）

    private String useStdclass;  //优惠卷使用班型（驾驶培训）

    private String useApplymodel;  //优惠卷使用车型（驾驶培训）

    private Date startDate;  //有效期起

    private Date endStart;   //有效期止

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

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
    }

    public String getProductClassifyid() {
        return productClassifyid;
    }

    public void setProductClassifyid(String productClassifyid) {
        this.productClassifyid = productClassifyid;
    }

    public String getProductBrandsid() {
        return productBrandsid;
    }

    public void setProductBrandsid(String productBrandsid) {
        this.productBrandsid = productBrandsid;
    }

    public String getProductBrands() {
        return productBrands;
    }

    public void setProductBrands(String productBrands) {
        this.productBrands = productBrands;
    }

    public String getProductCoverimg() {
        return productCoverimg;
    }

    public void setProductCoverimg(String productCoverimg) {
        this.productCoverimg = productCoverimg;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public BigDecimal getClubPrice() {
        return clubPrice;
    }

    public void setClubPrice(BigDecimal clubPrice) {
        this.clubPrice = clubPrice;
    }

    public BigDecimal getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(BigDecimal costPrice) {
        this.costPrice = costPrice;
    }

    public BigDecimal getNum() {
        return num;
    }

    public void setNum(BigDecimal num) {
        this.num = num;
    }

    public String getProductBarcode() {
        return productBarcode;
    }

    public void setProductBarcode(String productBarcode) {
        this.productBarcode = productBarcode;
    }

    public String getProductUnit() {
        return productUnit;
    }

    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit;
    }

    public String getProductSpecification() {
        return productSpecification;
    }

    public void setProductSpecification(String productSpecification) {
        this.productSpecification = productSpecification;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public BigDecimal getProductNum() {
        return productNum;
    }

    public void setProductNum(BigDecimal productNum) {
        this.productNum = productNum;
    }

    @Override
    public String toString() {
        return "shoppingCart{" +
                "productId='" + productId + '\'' +
                ", openid='" + openid + '\'' +
                ", productName='" + productName + '\'' +
                ", retailPrice=" + retailPrice +
                ", productClassifyid='" + productClassifyid + '\'' +
                ", productBrandsid='" + productBrandsid + '\'' +
                ", productBrands='" + productBrands + '\'' +
                ", productCoverimg='" + productCoverimg + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", clubPrice=" + clubPrice +
                ", costPrice=" + costPrice +
                ", num=" + num +
                ", productBarcode='" + productBarcode + '\'' +
                ", productUnit='" + productUnit + '\'' +
                ", productSpecification='" + productSpecification + '\'' +
                ", supplierId='" + supplierId + '\'' +
                ", supplierName='" + supplierName + '\'' +
                ", productNum=" + productNum +
                ", belongDept='" + belongDept + '\'' +
                ", productType='" + productType + '\'' +
                ", couponPrice=" + couponPrice +
                ", useDept='" + useDept + '\'' +
                ", useStdclass='" + useStdclass + '\'' +
                ", useApplymodel='" + useApplymodel + '\'' +
                ", startDate=" + startDate +
                ", endStart=" + endStart +
                '}';
    }
}
