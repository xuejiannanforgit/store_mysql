package cn.ztejjx.memberstore.domain.mysql;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class sharerecord implements Serializable {

    private String sharerecordId;

    private String memberId;

    private String memberName;

    private String sharememberId;

    private String sharememberName;

    private String shareAvatarurl;

    private String shareNickname;

    @JsonFormat(pattern = "yyyy-MM-dd",locale="zh",timezone="GMT+8")
    private Date createdDate;

    private Integer enabledFlag;

    private String sharetype;

    public String getSharetype() {
        return sharetype;
    }

    public void setSharetype(String sharetype) {
        this.sharetype = sharetype;
    }

    public String getSharerecordId() {
        return sharerecordId;
    }

    public void setSharerecordId(String sharerecordId) {
        this.sharerecordId = sharerecordId;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getSharememberId() {
        return sharememberId;
    }

    public void setSharememberId(String sharememberId) {
        this.sharememberId = sharememberId;
    }

    public String getSharememberName() {
        return sharememberName;
    }

    public void setSharememberName(String sharememberName) {
        this.sharememberName = sharememberName;
    }

    public String getShareAvatarurl() {
        return shareAvatarurl;
    }

    public void setShareAvatarurl(String shareAvatarurl) {
        this.shareAvatarurl = shareAvatarurl;
    }

    public String getShareNickname() {
        return shareNickname;
    }

    public void setShareNickname(String shareNickname) {
        this.shareNickname = shareNickname;
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
