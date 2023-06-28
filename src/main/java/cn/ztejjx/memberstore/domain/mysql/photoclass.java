package cn.ztejjx.memberstore.domain.mysql;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
@TableName("photoclass")
public class photoclass  implements Serializable {
    @JsonIgnore
    private String photoclassId;

    private String photoclassName;

    private String photoclassUrl;

    @JsonIgnore
    private Integer enabledFlag;

    @JsonIgnore
    private Date createdDate;

    @JsonIgnore
    private Integer sortOrder;

    private List<photoalbum> photoalbumList;

    public List<photoalbum> getPhotoalbumList() {
        return photoalbumList;
    }

    public void setPhotoalbumList(List<photoalbum> photoalbumList) {
        this.photoalbumList = photoalbumList;
    }

    public String getPhotoclassId() {
        return photoclassId;
    }

    public void setPhotoclassId(String photoclassId) {
        this.photoclassId = photoclassId;
    }

    public String getPhotoclassName() {
        return photoclassName;
    }

    public void setPhotoclassName(String photoclassName) {
        this.photoclassName = photoclassName;
    }

    public String getPhotoclassUrl() {
        return photoclassUrl;
    }

    public void setPhotoclassUrl(String photoclassUrl) {
        this.photoclassUrl = photoclassUrl;
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

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    @Override
    public String toString() {
        return "photoclass{" +
                "photoclassId='" + photoclassId + '\'' +
                ", photoclassName='" + photoclassName + '\'' +
                ", photoclassUrl='" + photoclassUrl + '\'' +
                ", enabledFlag=" + enabledFlag +
                ", createdDate=" + createdDate +
                ", sortOrder=" + sortOrder +
                ", photoalbumList=" + photoalbumList +
                '}';
    }
}
