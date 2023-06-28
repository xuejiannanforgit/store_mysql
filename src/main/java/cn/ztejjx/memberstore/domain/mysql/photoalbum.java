package cn.ztejjx.memberstore.domain.mysql;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


//@Data
//@NoArgsConstructor
//@AllArgsConstructor
@TableName("photoalbum")
public class photoalbum implements Serializable {
    @JsonIgnore
    private String photoalbumId;

    private String photoUrl;

    private String photoExplanation;

    private String photoName;


    private Integer sortOrder;

    @JsonIgnore
    private Integer enabledFlag;

    @JsonIgnore
    private Date createdDate;

    @JsonIgnore
    private String photoclassId;

    public String getPhotoalbumId() {
        return photoalbumId;
    }

    public void setPhotoalbumId(String photoalbumId) {
        this.photoalbumId = photoalbumId;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getPhotoExplanation() {
        return photoExplanation;
    }

    public void setPhotoExplanation(String photoExplanation) {
        this.photoExplanation = photoExplanation;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
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

    public String getPhotoclassId() {
        return photoclassId;
    }

    public void setPhotoclassId(String photoclassId) {
        this.photoclassId = photoclassId;
    }
}
