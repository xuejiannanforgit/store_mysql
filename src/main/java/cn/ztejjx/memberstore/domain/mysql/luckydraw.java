package cn.ztejjx.memberstore.domain.mysql;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;



@TableName("luckydraw")
public class luckydraw implements Serializable {

    private String prizesId;

    private String prizesName;

    private String prizesImage;

    private Integer drawFlag;

    private String memberId;

    private String memberName;

    private Integer enabledFlag;

    private Date createdDate;

    private String prizesCode;

    private String departmentName;

    private Date startDate;

    private Date endDate;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getPrizesId() {
        return prizesId;
    }

    public void setPrizesId(String prizesId) {
        this.prizesId = prizesId;
    }

    public String getPrizesName() {
        return prizesName;
    }

    public void setPrizesName(String prizesName) {
        this.prizesName = prizesName;
    }

    public String getPrizesImage() {
        return prizesImage;
    }

    public void setPrizesImage(String prizesImage) {
        this.prizesImage = prizesImage;
    }

    public Integer getDrawFlag() {
        return drawFlag;
    }

    public void setDrawFlag(Integer drawFlag) {
        this.drawFlag = drawFlag;
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

    public String getPrizesCode() {
        return prizesCode;
    }

    public void setPrizesCode(String prizesCode) {
        this.prizesCode = prizesCode;
    }
}
