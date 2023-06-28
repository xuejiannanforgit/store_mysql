package cn.ztejjx.memberstore.domain.mysql;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName resume_info
 */
@Data
@TableName("resume_info")
public class ResumeInfo implements Serializable {
    /**
     * 
     */
    private String resumeInfoid;

    /**
     * 
     */
    private String username;

    /**
     * 
     */
    private String sex;

    /**
     * 
     */
    private Integer age;

    /**
     * 
     */
    private String academic;

    /**
     * 
     */
    private String license;

    /**
     * 
     */
    private String position;

    /**
     * 
     */
    private String workexperience;

    /**
     * 
     */
    private Integer enableFlag;

    /**
     * 
     */
    private String openid;

    /**
     * 
     */
    private Date createDate;

    /**
     * 
     */
    private String recruitInfoid;

    /**
     * 
     */
    private String phone;

    private String company;


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
        ResumeInfo other = (ResumeInfo) that;
        return (this.getResumeInfoid() == null ? other.getResumeInfoid() == null : this.getResumeInfoid().equals(other.getResumeInfoid()))
            && (this.getUsername() == null ? other.getUsername() == null : this.getUsername().equals(other.getUsername()))
            && (this.getSex() == null ? other.getSex() == null : this.getSex().equals(other.getSex()))
            && (this.getAge() == null ? other.getAge() == null : this.getAge().equals(other.getAge()))
            && (this.getAcademic() == null ? other.getAcademic() == null : this.getAcademic().equals(other.getAcademic()))
            && (this.getLicense() == null ? other.getLicense() == null : this.getLicense().equals(other.getLicense()))
            && (this.getPosition() == null ? other.getPosition() == null : this.getPosition().equals(other.getPosition()))
            && (this.getWorkexperience() == null ? other.getWorkexperience() == null : this.getWorkexperience().equals(other.getWorkexperience()))
            && (this.getEnableFlag() == null ? other.getEnableFlag() == null : this.getEnableFlag().equals(other.getEnableFlag()))
            && (this.getOpenid() == null ? other.getOpenid() == null : this.getOpenid().equals(other.getOpenid()))
            && (this.getCreateDate() == null ? other.getCreateDate() == null : this.getCreateDate().equals(other.getCreateDate()))
            && (this.getRecruitInfoid() == null ? other.getRecruitInfoid() == null : this.getRecruitInfoid().equals(other.getRecruitInfoid()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getResumeInfoid() == null) ? 0 : getResumeInfoid().hashCode());
        result = prime * result + ((getUsername() == null) ? 0 : getUsername().hashCode());
        result = prime * result + ((getSex() == null) ? 0 : getSex().hashCode());
        result = prime * result + ((getAge() == null) ? 0 : getAge().hashCode());
        result = prime * result + ((getAcademic() == null) ? 0 : getAcademic().hashCode());
        result = prime * result + ((getLicense() == null) ? 0 : getLicense().hashCode());
        result = prime * result + ((getPosition() == null) ? 0 : getPosition().hashCode());
        result = prime * result + ((getWorkexperience() == null) ? 0 : getWorkexperience().hashCode());
        result = prime * result + ((getEnableFlag() == null) ? 0 : getEnableFlag().hashCode());
        result = prime * result + ((getOpenid() == null) ? 0 : getOpenid().hashCode());
        result = prime * result + ((getCreateDate() == null) ? 0 : getCreateDate().hashCode());
        result = prime * result + ((getRecruitInfoid() == null) ? 0 : getRecruitInfoid().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", resumeInfoid=").append(resumeInfoid);
        sb.append(", username=").append(username);
        sb.append(", sex=").append(sex);
        sb.append(", age=").append(age);
        sb.append(", academic=").append(academic);
        sb.append(", license=").append(license);
        sb.append(", position=").append(position);
        sb.append(", workexperience=").append(workexperience);
        sb.append(", enableFlag=").append(enableFlag);
        sb.append(", openid=").append(openid);
        sb.append(", createDate=").append(createDate);
        sb.append(", recruitInfoid=").append(recruitInfoid);
        sb.append(", phone=").append(phone);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}