package cn.ztejjx.memberstore.domain.mysql;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


@TableName("config_product_brands")
public class configProductBrands implements Serializable {
    private String productBrandsid;

    private String productClassifyid;

    private String productBrandsname;

    private String productBrandsimage;

    private Integer enabledFlag;

    private String createdBy;

    private Date createdDate;

    private String lastUpdatedBy;

    private Date lastUpdatedDate;

    private String remark;

    private Integer sortOrder;

    private String productFullbrandsname;

    private String productClassifyname;

    private List<configProduct> ConfigProductList;

    public List<configProduct> getConfigProductList() {
        return ConfigProductList;
    }

    public void setConfigProductList(List<configProduct> configProductList) {
        ConfigProductList = configProductList;
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

    public String getProductBrandsname() {
        return productBrandsname;
    }

    public void setProductBrandsname(String productBrandsname) {
        this.productBrandsname = productBrandsname == null ? null : productBrandsname.trim();
    }

    public String getProductBrandsimage() {
        return productBrandsimage;
    }

    public void setProductBrandsimage(String productBrandsimage) {
        this.productBrandsimage = productBrandsimage == null ? null : productBrandsimage.trim();
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

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getProductFullbrandsname() {
        return productFullbrandsname;
    }

    public void setProductFullbrandsname(String productFullbrandsname) {
        this.productFullbrandsname = productFullbrandsname == null ? null : productFullbrandsname.trim();
    }

    public String getProductClassifyname() {
        return productClassifyname;
    }

    public void setProductClassifyname(String productClassifyname) {
        this.productClassifyname = productClassifyname == null ? null : productClassifyname.trim();
    }
}