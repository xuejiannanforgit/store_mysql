package cn.ztejjx.memberstore.domain.mysql;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;



@TableName("projectsitem")
public class projectsitem implements Serializable {
    private String projectsitemId;

    private String projectsitemName;

    @JsonIgnore
    private String projectsclassId;

    @JsonIgnore
    private Integer enabledFlag;

    @JsonIgnore
    private Date createdDate;

    @JsonIgnore
    private Integer sortOrder;

    private List<projectsintroduction> projectsintroductionlist;

    public List<projectsintroduction> getProjectsintroductionlist() {
        return projectsintroductionlist;
    }

    public void setProjectsintroductionlist(List<projectsintroduction> projectsintroductionlist) {
        this.projectsintroductionlist = projectsintroductionlist;
    }

    public String getProjectsitemId() {
        return projectsitemId;
    }

    public void setProjectsitemId(String projectsitemId) {
        this.projectsitemId = projectsitemId;
    }

    public String getProjectsitemName() {
        return projectsitemName;
    }

    public void setProjectsitemName(String projectsitemName) {
        this.projectsitemName = projectsitemName;
    }

    public String getProjectsclassId() {
        return projectsclassId;
    }

    public void setProjectsclassId(String projectsclassId) {
        this.projectsclassId = projectsclassId;
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

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }
}
