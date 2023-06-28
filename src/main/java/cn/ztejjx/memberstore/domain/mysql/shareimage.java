package cn.ztejjx.memberstore.domain.mysql;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@TableName("shareimage")
public class shareimage implements Serializable {

    private String shareimageId;

    private String shareId;

    private String imageUrl;

    private Integer enabledFlag;

    public String getShareimageId() {
        return shareimageId;
    }

    public void setShareimageId(String shareimageId) {
        this.shareimageId = shareimageId;
    }

    public String getShareId() {
        return shareId;
    }

    public void setShareId(String shareId) {
        this.shareId = shareId;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public Integer getEnabledFlag() {
        return enabledFlag;
    }

    public void setEnabledFlag(Integer enabledFlag) {
        this.enabledFlag = enabledFlag;
    }
}
