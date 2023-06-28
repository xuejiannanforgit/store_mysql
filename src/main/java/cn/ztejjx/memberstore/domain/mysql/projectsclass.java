package cn.ztejjx.memberstore.domain.mysql;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;



@TableName("projectsclass")
public class projectsclass implements Serializable {
    private String projectsclassId;

    private String projectsclassName;

    private String projectssubclassName;

    @JsonIgnore
    private Integer enabledFlag;

    @JsonIgnore
    private Date createdDate;

    @JsonIgnore
    private Integer sortOrder;

    private boolean showflag;

    private List<projectsitem> projectsitemlist;


    public boolean isShowflag() {
        return showflag;
    }

    public void setShowflag(boolean showflag) {
        this.showflag = showflag;
    }

    public List<projectsitem> getProjectsitemlist() {
        return projectsitemlist;
    }

    public void setProjectsitemlist(List<projectsitem> projectsitemlist) {
        this.projectsitemlist = projectsitemlist;
    }

    public String getProjectsclassId() {
        return projectsclassId;
    }

    public void setProjectsclassId(String projectsclassId) {
        this.projectsclassId = projectsclassId;
    }

    public String getProjectsclassName() {
        return projectsclassName;
    }

    public void setProjectsclassName(String projectsclassName) {
        this.projectsclassName = projectsclassName;
    }

    public String getProjectssubclassName() {
        return projectssubclassName;
    }

    public void setProjectssubclassName(String projectssubclassName) {
        this.projectssubclassName = projectssubclassName;
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
