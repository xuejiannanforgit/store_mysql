package cn.ztejjx.memberstore.domain.mysql;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


@TableName("businessIntroduction")
public class businessIntroduction  extends Model<businessIntroduction> implements Serializable {

    //@TableField(value="introduction_Id")
    private String IntroductionId;

   // @TableField(value="businessName")
    private String businessName;

  //  @TableField(value="businessDescription")
    private String businessDescription;

  //  @TableField(value="signUpConditions")
    private String signupConditions;

   // @TableField(value="classification")
    private String classification;

    public String getIntroductionId() {
        return IntroductionId;
    }

    public void setIntroductionId(String introductionId) {
        IntroductionId = introductionId;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getBusinessDescription() {
        return businessDescription;
    }

    public void setBusinessDescription(String businessDescription) {
        this.businessDescription = businessDescription;
    }

    public String getSignupConditions() {
        return signupConditions;
    }

    public void setSignupConditions(String signupConditions) {
        this.signupConditions = signupConditions;
    }

    public String getClassification() {
        return classification;
    }

    public void setClassification(String classification) {
        this.classification = classification;
    }
}
