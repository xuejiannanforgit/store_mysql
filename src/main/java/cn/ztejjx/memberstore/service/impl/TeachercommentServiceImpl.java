package cn.ztejjx.memberstore.service.impl;

import cn.ztejjx.memberstore.domain.mysql.Teachercomment;
import cn.ztejjx.memberstore.domain.mysql.registerinfo;
import cn.ztejjx.memberstore.mapper.mysql.TeachercommentMapper;
import cn.ztejjx.memberstore.service.TeachercommentService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class TeachercommentServiceImpl implements TeachercommentService {

    @Autowired
    private TeachercommentMapper teachercommentMapper;

    @Override
    public String saveTeachercomment(Teachercomment teachercomment) {

        teachercommentMapper.insert(teachercomment);
        return teachercomment.getTeachercommentId();
    }

    @Override
    public int validaterecord(String teacherid, String createdById, String subject) {

        QueryWrapper<Teachercomment> wrapper = new   QueryWrapper<>();
        wrapper.eq("teacherId",teacherid);
        wrapper.eq("created_by_Id",createdById);
        wrapper.eq("subject",subject);
        int count    = this.teachercommentMapper.selectCount(wrapper) ;
        return count;
    }
}
