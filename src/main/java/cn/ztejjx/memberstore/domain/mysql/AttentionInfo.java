package cn.ztejjx.memberstore.domain.mysql;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("attention_info")
public class AttentionInfo {
    private String attentionId;

    private String sharememberphone;

    private String studentphone;

    private String activitiestitle;

    private String activitiesid;

    private String coverimage;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",locale="zh",timezone="GMT+8")
    private Date createdDate;

    private Integer enabledFlag;

    public String getAttentionId() {
        return attentionId;
    }

    public void setAttentionId(String attentionId) {
        this.attentionId = attentionId == null ? null : attentionId.trim();
    }

    public String getSharememberphone() {
        return sharememberphone;
    }

    public void setSharememberphone(String sharememberphone) {
        this.sharememberphone = sharememberphone == null ? null : sharememberphone.trim();
    }

    public String getStudentphone() {
        return studentphone;
    }

    public void setStudentphone(String studentphone) {
        this.studentphone = studentphone == null ? null : studentphone.trim();
    }

    public String getActivitiestitle() {
        return activitiestitle;
    }

    public void setActivitiestitle(String activitiestitle) {
        this.activitiestitle = activitiestitle == null ? null : activitiestitle.trim();
    }

    public String getActivitiesid() {
        return activitiesid;
    }

    public void setActivitiesid(String activitiesid) {
        this.activitiesid = activitiesid == null ? null : activitiesid.trim();
    }

    public String getCoverimage() {
        return coverimage;
    }

    public void setCoverimage(String coverimage) {
        this.coverimage = coverimage == null ? null : coverimage.trim();
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getEnabledFlag() {
        return enabledFlag;
    }

    public void setEnabledFlag(Integer enabledFlag) {
        this.enabledFlag = enabledFlag;
    }
}