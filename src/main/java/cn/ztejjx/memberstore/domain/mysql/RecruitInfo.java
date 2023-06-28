package cn.ztejjx.memberstore.domain.mysql;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName recruit_info
 */
@Data
@TableName("recruit_info")
public class RecruitInfo implements Serializable {
    /**
     * 
     */
    private String recruitInfoid;

    /**
     * 
     */
    private String position;

    private String positionneed;

    /**
     * 
     */
    private String income;

    private String company;


    /**
     * 
     */
    private String address;

    /**
     * 
     */
    private String positionDetail;

    /**
     * 
     */
    private Integer enableFlag;

    /**
     * 
     */
    private String createBy;

    /**
     * 
     */
    private Date createDate;

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
        RecruitInfo other = (RecruitInfo) that;
        return (this.getRecruitInfoid() == null ? other.getRecruitInfoid() == null : this.getRecruitInfoid().equals(other.getRecruitInfoid()))
            && (this.getPosition() == null ? other.getPosition() == null : this.getPosition().equals(other.getPosition()))
            && (this.getIncome() == null ? other.getIncome() == null : this.getIncome().equals(other.getIncome()))
            && (this.getAddress() == null ? other.getAddress() == null : this.getAddress().equals(other.getAddress()))
            && (this.getPositionDetail() == null ? other.getPositionDetail() == null : this.getPositionDetail().equals(other.getPositionDetail()))
            && (this.getEnableFlag() == null ? other.getEnableFlag() == null : this.getEnableFlag().equals(other.getEnableFlag()))
            && (this.getCreateBy() == null ? other.getCreateBy() == null : this.getCreateBy().equals(other.getCreateBy()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getRecruitInfoid() == null) ? 0 : getRecruitInfoid().hashCode());
        result = prime * result + ((getPosition() == null) ? 0 : getPosition().hashCode());
        result = prime * result + ((getIncome() == null) ? 0 : getIncome().hashCode());
        result = prime * result + ((getAddress() == null) ? 0 : getAddress().hashCode());
        result = prime * result + ((getPositionDetail() == null) ? 0 : getPositionDetail().hashCode());
        result = prime * result + ((getEnableFlag() == null) ? 0 : getEnableFlag().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", recruitInfoid=").append(recruitInfoid);
        sb.append(", position=").append(position);
        sb.append(", income=").append(income);
        sb.append(", address=").append(address);
        sb.append(", positionDetail=").append(positionDetail);
        sb.append(", enableFlag=").append(enableFlag);
        sb.append(", createBy=").append(createBy);
        sb.append(", createDate=").append(createDate);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}