package cn.ztejjx.memberstore.domain.mysql;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName advertising
 */
@Data
public class Advertising implements Serializable {
    /**
     * 广告ID
     */
    private String advertisingId;

    /**
     * 广告名称
     */
    private String advertisingName;

    /**
     * 广告封面
     */
    private String advertisingCover;

    /**
     * 广告描述
     */
    private String advertisingDescription;

    /**
     * 介绍图片1
     */
    private String imageone;

    /**
     * 介绍图片2
     */
    private String imagetwo;

    /**
     * 介绍图片3
     */
    private String imagethree;

    /**
     * 广告投放公司
     */
    private String advertisingCompany;

    /**
     * 电话
     */
    private String advertisingPhone;

    /**
     * 租车，买车
     */
    private String advertisingType;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 
     */
    private Integer enableFlag;

    private static final long serialVersionUID = 1L;

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Advertising other = (Advertising) that;
        return (this.getAdvertisingId() == null ? other.getAdvertisingId() == null : this.getAdvertisingId().equals(other.getAdvertisingId()))
            && (this.getAdvertisingName() == null ? other.getAdvertisingName() == null : this.getAdvertisingName().equals(other.getAdvertisingName()))
            && (this.getAdvertisingCover() == null ? other.getAdvertisingCover() == null : this.getAdvertisingCover().equals(other.getAdvertisingCover()))
            && (this.getAdvertisingDescription() == null ? other.getAdvertisingDescription() == null : this.getAdvertisingDescription().equals(other.getAdvertisingDescription()))
            && (this.getImageone() == null ? other.getImageone() == null : this.getImageone().equals(other.getImageone()))
            && (this.getImagetwo() == null ? other.getImagetwo() == null : this.getImagetwo().equals(other.getImagetwo()))
            && (this.getImagethree() == null ? other.getImagethree() == null : this.getImagethree().equals(other.getImagethree()))
            && (this.getAdvertisingCompany() == null ? other.getAdvertisingCompany() == null : this.getAdvertisingCompany().equals(other.getAdvertisingCompany()))
            && (this.getAdvertisingPhone() == null ? other.getAdvertisingPhone() == null : this.getAdvertisingPhone().equals(other.getAdvertisingPhone()))
            && (this.getAdvertisingType() == null ? other.getAdvertisingType() == null : this.getAdvertisingType().equals(other.getAdvertisingType()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getEnableFlag() == null ? other.getEnableFlag() == null : this.getEnableFlag().equals(other.getEnableFlag()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAdvertisingId() == null) ? 0 : getAdvertisingId().hashCode());
        result = prime * result + ((getAdvertisingName() == null) ? 0 : getAdvertisingName().hashCode());
        result = prime * result + ((getAdvertisingCover() == null) ? 0 : getAdvertisingCover().hashCode());
        result = prime * result + ((getAdvertisingDescription() == null) ? 0 : getAdvertisingDescription().hashCode());
        result = prime * result + ((getImageone() == null) ? 0 : getImageone().hashCode());
        result = prime * result + ((getImagetwo() == null) ? 0 : getImagetwo().hashCode());
        result = prime * result + ((getImagethree() == null) ? 0 : getImagethree().hashCode());
        result = prime * result + ((getAdvertisingCompany() == null) ? 0 : getAdvertisingCompany().hashCode());
        result = prime * result + ((getAdvertisingPhone() == null) ? 0 : getAdvertisingPhone().hashCode());
        result = prime * result + ((getAdvertisingType() == null) ? 0 : getAdvertisingType().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getEnableFlag() == null) ? 0 : getEnableFlag().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", advertisingId=").append(advertisingId);
        sb.append(", advertisingName=").append(advertisingName);
        sb.append(", advertisingCover=").append(advertisingCover);
        sb.append(", advertisingDescription=").append(advertisingDescription);
        sb.append(", imageone=").append(imageone);
        sb.append(", imagetwo=").append(imagetwo);
        sb.append(", imagethree=").append(imagethree);
        sb.append(", advertisingCompany=").append(advertisingCompany);
        sb.append(", advertisingPhone=").append(advertisingPhone);
        sb.append(", advertisingType=").append(advertisingType);
        sb.append(", createDate=").append(createDate);
        sb.append(", enableFlag=").append(enableFlag);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}