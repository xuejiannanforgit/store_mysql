package cn.ztejjx.memberstore.domain.mysql;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@TableName("activitie_record")
public class activitieRecord implements Serializable {
    private String activitieRecordid;
    private String shareOpenid;
    private String openid;
    private String nickName;
    private String avatarurl;
    private Integer enabledFlag;
    private Date createdDate;
    private String activitiesId;

    public String getActivitiesId() {
        return activitiesId;
    }

    public void setActivitiesId(String activitiesId) {
        this.activitiesId = activitiesId;
    }

    public String getActivitieRecordid() {
        return activitieRecordid;
    }

    public void setActivitieRecordid(String activitieRecordid) {
        this.activitieRecordid = activitieRecordid == null ? null : activitieRecordid.trim();
    }

    public String getShareOpenid() {
        return shareOpenid;
    }

    public void setShareOpenid(String shareOpenid) {
        this.shareOpenid = shareOpenid == null ? null : shareOpenid.trim();
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    public String getAvatarurl() {
        return avatarurl;
    }

    public void setAvatarurl(String avatarurl) {
        this.avatarurl = avatarurl == null ? null : avatarurl.trim();
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
}