package cn.ztejjx.memberstore.domain.mysql;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
@TableName("activitie_image")
public class activitieImage implements Serializable{
    private String activitieImageid;

    private String activitiesId;

    private String activitiesImageurl;

    private Integer enabledFlag;

    private String createdBy;

    private Date createdDate;


    private String explainText;
    ;

    public String getActivitieImageid() {
        return activitieImageid;
    }

    public void setActivitieImageid(String activitieImageid) {
        this.activitieImageid = activitieImageid == null ? null : activitieImageid.trim();
    }

    public String getActivitiesId() {
        return activitiesId;
    }

    public void setActivitiesId(String activitiesId) {
        this.activitiesId = activitiesId == null ? null : activitiesId.trim();
    }

    public String getActivitiesImageurl() {
        return activitiesImageurl;
    }

    public void setActivitiesImageurl(String activitiesImageurl) {
        this.activitiesImageurl = activitiesImageurl == null ? null : activitiesImageurl.trim();
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

    public String getExplainText() {
        return explainText;
    }

    public void setExplainText(String explainText) {
        this.explainText = explainText;
    }
}