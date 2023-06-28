package cn.ztejjx.memberstore.domain.mysql;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
@TableName("oil_record")
public class oilPrice implements Serializable{
    private String oilpriceId;

    private BigDecimal oilprice;

    private String dept;

    private Date createdDate;

    private String createdBy;

    private String useFlag;

    private String oilClass;

    private String oilType;

    private String deptId;

    private Integer enabledFlag;

    private String area;

    public String getOilType() {
        return oilType;
    }

    public void setOilType(String oilType) {
        this.oilType = oilType;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getOilpriceId() {
        return oilpriceId;
    }

    public void setOilpriceId(String oilpriceId) {
        this.oilpriceId = oilpriceId == null ? null : oilpriceId.trim();
    }

    public BigDecimal getOilprice() {
        return oilprice;
    }

    public void setOilprice(BigDecimal oilprice) {
        this.oilprice = oilprice;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept == null ? null : dept.trim();
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
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    public String getUseFlag() {
        return useFlag;
    }

    public void setUseFlag(String useFlag) {
        this.useFlag = useFlag == null ? null : useFlag.trim();
    }

    public String getOilClass() {
        return oilClass;
    }

    public void setOilClass(String oilClass) {
        this.oilClass = oilClass == null ? null : oilClass.trim();
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId == null ? null : deptId.trim();
    }

    public Integer getEnabledFlag() {
        return enabledFlag;
    }

    public void setEnabledFlag(Integer enabledFlag) {
        this.enabledFlag = enabledFlag;
    }
}