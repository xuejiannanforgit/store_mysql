package cn.ztejjx.memberstore.domain.mysql;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@TableName("teacherComment_Item")
public class TeachercommentItem {
    private String teachercommentItemid;

    private String teachercommentId;

    private String content;

    private Long score;

    private Integer enabledFlag;

    private Date createdDate;

    public String getTeachercommentItemid() {
        return teachercommentItemid;
    }

    public void setTeachercommentItemid(String teachercommentItemid) {
        this.teachercommentItemid = teachercommentItemid == null ? null : teachercommentItemid.trim();
    }

    public String getTeachercommentId() {
        return teachercommentId;
    }

    public void setTeachercommentId(String teachercommentId) {
        this.teachercommentId = teachercommentId == null ? null : teachercommentId.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Long getScore() {
        return score;
    }

    public void setScore(Long score) {
        this.score = score;
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
}