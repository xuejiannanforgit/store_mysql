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
@TableName("oil_card")
public class oilCard implements Serializable {



    private String oilcardId;

    private String oilcardNum;

    private String oilcardDept;

    private Integer enabledFlag;

    private String createdBy;

    private Date createdDate;

    private BigDecimal oilcardRemain;

    private String station;

    private String addr;

    private String remark;

    public String getOilcardId() {
        return oilcardId;
    }

    public void setOilcardId(String oilcardId) {
        this.oilcardId = oilcardId;
    }

    public String getOilcardNum() {
        return oilcardNum;
    }

    public void setOilcardNum(String oilcardNum) {
        this.oilcardNum = oilcardNum;
    }

    public String getOilcardDept() {
        return oilcardDept;
    }

    public void setOilcardDept(String oilcardDept) {
        this.oilcardDept = oilcardDept;
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
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public BigDecimal getOilcardRemain() {
        return oilcardRemain;
    }

    public void setOilcardRemain(BigDecimal oilcardRemain) {
        this.oilcardRemain = oilcardRemain;
    }

    public String getStation() {
        return station;
    }

    public void setStation(String station) {
        this.station = station;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}