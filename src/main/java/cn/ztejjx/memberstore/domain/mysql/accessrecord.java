package cn.ztejjx.memberstore.domain.mysql;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

public class accessrecord  implements Serializable{

    private String recordId;

    private String memberId;

    private String visitorsId;

    private String memberName;

    private String visitorsName;

    @JsonFormat(pattern = "yyyy-MM-dd",locale="zh",timezone="GMT+8")
    private Date createdDate;

    private Integer enabledFlag;

    public String getRecordId() {
        return recordId;
    }

    public void setRecordId(String recordId) {
        this.recordId = recordId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getVisitorsId() {
        return visitorsId;
    }

    public void setVisitorsId(String visitorsId) {
        this.visitorsId = visitorsId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getVisitorsName() {
        return visitorsName;
    }

    public void setVisitorsName(String visitorsName) {
        this.visitorsName = visitorsName;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Integer getEnabledFlag() {
        return enabledFlag;
    }

    public void setEnabledFlag(Integer enabledFlag) {
        this.enabledFlag = enabledFlag;
    }
}
