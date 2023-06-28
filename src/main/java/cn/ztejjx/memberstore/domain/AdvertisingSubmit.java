package cn.ztejjx.memberstore.domain;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * 
 * @TableName advertising_submit
 */
@Data
public class AdvertisingSubmit implements Serializable {
    /**
     * 
     */
    private String advertisingSubmitid;

    /**
     * 
     */
    private String advertisingName;

    /**
     * 
     */
    private String advertisingCover;

    /**
     * 
     */
    private String submitPhone;

    /**
     * 
     */
    private String advertisingId;

    /**
     * 
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
        AdvertisingSubmit other = (AdvertisingSubmit) that;
        return (this.getAdvertisingSubmitid() == null ? other.getAdvertisingSubmitid() == null : this.getAdvertisingSubmitid().equals(other.getAdvertisingSubmitid()))
            && (this.getAdvertisingName() == null ? other.getAdvertisingName() == null : this.getAdvertisingName().equals(other.getAdvertisingName()))
            && (this.getAdvertisingCover() == null ? other.getAdvertisingCover() == null : this.getAdvertisingCover().equals(other.getAdvertisingCover()))
            && (this.getSubmitPhone() == null ? other.getSubmitPhone() == null : this.getSubmitPhone().equals(other.getSubmitPhone()))
            && (this.getAdvertisingId() == null ? other.getAdvertisingId() == null : this.getAdvertisingId().equals(other.getAdvertisingId()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getEnableFlag() == null ? other.getEnableFlag() == null : this.getEnableFlag().equals(other.getEnableFlag()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getAdvertisingSubmitid() == null) ? 0 : getAdvertisingSubmitid().hashCode());
        result = prime * result + ((getAdvertisingName() == null) ? 0 : getAdvertisingName().hashCode());
        result = prime * result + ((getAdvertisingCover() == null) ? 0 : getAdvertisingCover().hashCode());
        result = prime * result + ((getSubmitPhone() == null) ? 0 : getSubmitPhone().hashCode());
        result = prime * result + ((getAdvertisingId() == null) ? 0 : getAdvertisingId().hashCode());
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
        sb.append(", advertisingSubmitid=").append(advertisingSubmitid);
        sb.append(", advertisingName=").append(advertisingName);
        sb.append(", advertisingCover=").append(advertisingCover);
        sb.append(", submitPhone=").append(submitPhone);
        sb.append(", advertisingId=").append(advertisingId);
        sb.append(", createDate=").append(createDate);
        sb.append(", enableFlag=").append(enableFlag);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}