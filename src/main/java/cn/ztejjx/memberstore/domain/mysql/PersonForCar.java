package cn.ztejjx.memberstore.domain.mysql;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName person_for_car
 */
@Data
public class PersonForCar implements Serializable {
    /**
     * 人找车记录Id
     */
    private String personForCarId;

    /**
     * 联系人
     */
    private String username;

    /**
     * 位置
     */
    private String location;

    /**
     * 经度
     */
    private String latitude;

    /**
     * 纬度
     */
    private String longitude;

    /**
     * 行政区
     */
    private String region;

    /**
     * 其他备注
     */
    private String remark;

    /**
     * 
     */
    private String openid;

    /**
     * 
     */
    private Integer enabledFlag;

    /**
     * 
     */
    @JsonFormat(pattern = "yyyy-MM-dd",locale="zh",timezone="GMT+8")
    private Date createdDate;

    /**
     * 电话
     */
    private String phone;

    /**
     * 点击量
     */
    private Integer num;

    /**
     * 
     */
    private String nickname;

    /**
     * 
     */
    private String avaterurl;

    /**
     * 
     */
    private String cartype;

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
        PersonForCar other = (PersonForCar) that;
        return (this.getPersonForCarId() == null ? other.getPersonForCarId() == null : this.getPersonForCarId().equals(other.getPersonForCarId()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getLocation() == null ? other.getLocation() == null : this.getLocation().equals(other.getLocation()))
            && (this.getLatitude() == null ? other.getLatitude() == null : this.getLatitude().equals(other.getLatitude()))
            && (this.getLongitude() == null ? other.getLongitude() == null : this.getLongitude().equals(other.getLongitude()))
            && (this.getRegion() == null ? other.getRegion() == null : this.getRegion().equals(other.getRegion()))
            && (this.getRemark() == null ? other.getRemark() == null : this.getRemark().equals(other.getRemark()))
            && (this.getOpenid() == null ? other.getOpenid() == null : this.getOpenid().equals(other.getOpenid()))
            && (this.getEnabledFlag() == null ? other.getEnabledFlag() == null : this.getEnabledFlag().equals(other.getEnabledFlag()))
            && (this.getCreatedDate() == null ? other.getCreatedDate() == null : this.getCreatedDate().equals(other.getCreatedDate()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getNum() == null ? other.getNum() == null : this.getNum().equals(other.getNum()))
            && (this.getNickname() == null ? other.getNickname() == null : this.getNickname().equals(other.getNickname()))
            && (this.getAvaterurl() == null ? other.getAvaterurl() == null : this.getAvaterurl().equals(other.getAvaterurl()))
            && (this.getCartype() == null ? other.getCartype() == null : this.getCartype().equals(other.getCartype()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getPersonForCarId() == null) ? 0 : getPersonForCarId().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getLocation() == null) ? 0 : getLocation().hashCode());
        result = prime * result + ((getLatitude() == null) ? 0 : getLatitude().hashCode());
        result = prime * result + ((getLongitude() == null) ? 0 : getLongitude().hashCode());
        result = prime * result + ((getRegion() == null) ? 0 : getRegion().hashCode());
        result = prime * result + ((getRemark() == null) ? 0 : getRemark().hashCode());
        result = prime * result + ((getOpenid() == null) ? 0 : getOpenid().hashCode());
        result = prime * result + ((getEnabledFlag() == null) ? 0 : getEnabledFlag().hashCode());
        result = prime * result + ((getCreatedDate() == null) ? 0 : getCreatedDate().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getNum() == null) ? 0 : getNum().hashCode());
        result = prime * result + ((getNickname() == null) ? 0 : getNickname().hashCode());
        result = prime * result + ((getAvaterurl() == null) ? 0 : getAvaterurl().hashCode());
        result = prime * result + ((getCartype() == null) ? 0 : getCartype().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", personForCarId=").append(personForCarId);
        sb.append(", username=").append(username);
        sb.append(", location=").append(location);
        sb.append(", latitude=").append(latitude);
        sb.append(", longitude=").append(longitude);
        sb.append(", region=").append(region);
        sb.append(", remark=").append(remark);
        sb.append(", openid=").append(openid);
        sb.append(", enabledFlag=").append(enabledFlag);
        sb.append(", createdDate=").append(createdDate);
        sb.append(", phone=").append(phone);
        sb.append(", num=").append(num);
        sb.append(", nickname=").append(nickname);
        sb.append(", avaterurl=").append(avaterurl);
        sb.append(", cartype=").append(cartype);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}