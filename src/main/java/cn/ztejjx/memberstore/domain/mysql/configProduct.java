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


@TableName("config_product")
public class configProduct implements Serializable {
    private String productId;

    private String productBrandsid;

    private String productClassifyid;

    private String productName;

    private String productSpecification;

    private String productUnit;

    private BigDecimal retailPrice;

    private BigDecimal clubPrice;

    private BigDecimal costPrice;

    private BigDecimal productNum;

    private String productBarcode;

    private Integer productSales;

    private Integer sortOrder;

    private Integer expiration;

    private String supplierId;

    private String supplierName;

    private Integer enabledFlag;

    private String createdBy;

    private Date createdDate;

    private String productCoverimg;

    private String showflag;

    private Integer num;

    private String productDescription;

    private String productBrands;

    private Integer unfixPrice;

    private Integer checkProduct;

    private String productOrigin;

    private Integer useFlag;

    private String lastUpdatedBy;

    private Date lastUpdatedDate;

    private String remark;

    private String productClassifyname;

    private Integer platformFlag;



    private String belongDept; //归属业务部门（驾驶培训，建筑培训，洗停车。。。）

    private String productType; //商品类型，优惠卷，礼品....

    private Integer couponPrice;  //优惠卷抵扣金额

    private String useDept;  //优惠卷使用分校（驾驶培训）

    private String useStdclass;  //优惠卷使用班型（驾驶培训）

    private String useApplymodel;  //优惠卷使用车型（驾驶培训）

    @JsonFormat(pattern = "yyyy-MM-dd",locale="zh",timezone="GMT+8")
    private Date startDate;  //有效期起

    @JsonFormat(pattern = "yyyy-MM-dd",locale="zh",timezone="GMT+8")
    private Date endStart;   //有效期止

    private String recommended;

    private String recommendedDept;

    private List<configProductImage> productImagelist;

    private List<configProductImage>  configProductImagelist;



    public String getRecommended() {
        return recommended;
    }

    public void setRecommended(String recommended) {
        this.recommended = recommended;
    }

    public String getRecommendedDept() {
        return recommendedDept;
    }

    public void setRecommendedDept(String recommendedDept) {
        this.recommendedDept = recommendedDept;
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

    public Integer getCouponPrice() {
        return couponPrice;
    }

    public void setCouponPrice(Integer couponPrice) {
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




    public List<configProductImage> getProductImagelist() {
        return productImagelist;
    }

    public void setProductImagelist(List<configProductImage> productImagelist) {
        this.productImagelist = productImagelist;
    }

    public List<configProductImage> getConfigProductImagelist() {
        return configProductImagelist;
    }

    public void setConfigProductImagelist(List<configProductImage> configProductImagelist) {
        this.configProductImagelist = configProductImagelist;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    public String getProductBrandsid() {
        return productBrandsid;
    }

    public void setProductBrandsid(String productBrandsid) {
        this.productBrandsid = productBrandsid == null ? null : productBrandsid.trim();
    }

    public String getProductClassifyid() {
        return productClassifyid;
    }

    public void setProductClassifyid(String productClassifyid) {
        this.productClassifyid = productClassifyid == null ? null : productClassifyid.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public String getProductSpecification() {
        return productSpecification;
    }

    public void setProductSpecification(String productSpecification) {
        this.productSpecification = productSpecification == null ? null : productSpecification.trim();
    }

    public String getProductUnit() {
        return productUnit;
    }

    public void setProductUnit(String productUnit) {
        this.productUnit = productUnit == null ? null : productUnit.trim();
    }

    public BigDecimal getRetailPrice() {
        return retailPrice;
    }

    public void setRetailPrice(BigDecimal retailPrice) {
        this.retailPrice = retailPrice;
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

    public BigDecimal getProductNum() {
        return productNum;
    }

    public void setProductNum(BigDecimal productNum) {
        this.productNum = productNum;
    }

    public String getProductBarcode() {
        return productBarcode;
    }

    public void setProductBarcode(String productBarcode) {
        this.productBarcode = productBarcode == null ? null : productBarcode.trim();
    }

    public Integer getProductSales() {
        return productSales;
    }

    public void setProductSales(Integer productSales) {
        this.productSales = productSales;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Integer getExpiration() {
        return expiration;
    }

    public void setExpiration(Integer expiration) {
        this.expiration = expiration;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(String supplierId) {
        this.supplierId = supplierId == null ? null : supplierId.trim();
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName == null ? null : supplierName.trim();
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

    public String getProductCoverimg() {
        return productCoverimg;
    }

    public void setProductCoverimg(String productCoverimg) {
        this.productCoverimg = productCoverimg == null ? null : productCoverimg.trim();
    }

    public String getShowflag() {
        return showflag;
    }

    public void setShowflag(String showflag) {
        this.showflag = showflag == null ? null : showflag.trim();
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription == null ? null : productDescription.trim();
    }

    public String getProductBrands() {
        return productBrands;
    }

    public void setProductBrands(String productBrands) {
        this.productBrands = productBrands == null ? null : productBrands.trim();
    }

    public Integer getUnfixPrice() {
        return unfixPrice;
    }

    public void setUnfixPrice(Integer unfixPrice) {
        this.unfixPrice = unfixPrice;
    }

    public Integer getCheckProduct() {
        return checkProduct;
    }

    public void setCheckProduct(Integer checkProduct) {
        this.checkProduct = checkProduct;
    }

    public String getProductOrigin() {
        return productOrigin;
    }

    public void setProductOrigin(String productOrigin) {
        this.productOrigin = productOrigin == null ? null : productOrigin.trim();
    }

    public Integer getUseFlag() {
        return useFlag;
    }

    public void setUseFlag(Integer useFlag) {
        this.useFlag = useFlag;
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

    public String getProductClassifyname() {
        return productClassifyname;
    }

    public void setProductClassifyname(String productClassifyname) {
        this.productClassifyname = productClassifyname == null ? null : productClassifyname.trim();
    }

    public Integer getPlatformFlag() {
        return platformFlag;
    }

    public void setPlatformFlag(Integer platformFlag) {
        this.platformFlag = platformFlag;
    }


}