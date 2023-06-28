package cn.ztejjx.memberstore.domain;

public class TeacherInfo {

    private int id;
    private String subject;

    private String dept;

    private String teacherName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    @Override
    public String toString() {
        return "TeacherInfo{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", dept='" + dept + '\'' +
                ", teacherName='" + teacherName + '\'' +
                '}';
    }
}
