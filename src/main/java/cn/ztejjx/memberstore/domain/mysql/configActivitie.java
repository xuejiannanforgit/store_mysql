package cn.ztejjx.memberstore.domain.mysql;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


@TableName("config_activitie")
public class configActivitie implements Serializable {
    private String activitiesId;

    private String coverImage;

    private String activitiesTitle;

    private Integer enabledFlag;

    private String createdBy;

    @JsonFormat(pattern = "yyyy-MM-dd",locale="zh",timezone="GMT+8")
    private Date createdDate;

    private Integer shareZannum;

    private Long zan;

    private String useflag;

    public String getUseflag() {
        return useflag;
    }

    public void setUseflag(String useflag) {
        this.useflag = useflag;
    }

    public String getActivitiesId() {
        return activitiesId;
    }

    public void setActivitiesId(String activitiesId) {
        this.activitiesId = activitiesId == null ? null : activitiesId.trim();
    }

    public String getCoverImage() {
        return coverImage;
    }

    public void setCoverImage(String coverImage) {
        this.coverImage = coverImage == null ? null : coverImage.trim();
    }

    public String getActivitiesTitle() {
        return activitiesTitle;
    }

    public void setActivitiesTitle(String activitiesTitle) {
        this.activitiesTitle = activitiesTitle == null ? null : activitiesTitle.trim();
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

    public Integer getShareZannum() {
        return shareZannum;
    }

    public void setShareZannum(Integer shareZannum) {
        this.shareZannum = shareZannum;
    }

    public Long getZan() {
        return zan;
    }

    public void setZan(Long zan) {
        this.zan = zan;
    }
}