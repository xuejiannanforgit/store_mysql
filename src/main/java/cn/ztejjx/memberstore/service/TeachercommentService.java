package cn.ztejjx.memberstore.service;


import cn.ztejjx.memberstore.domain.mysql.Teachercomment;

public interface TeachercommentService {

    String saveTeachercomment(Teachercomment teachercomment);
    int validaterecord(String teacherid,String  createdById,String subject);
}
