package cn.ztejjx.memberstore.service.impl;

import cn.ztejjx.memberstore.domain.mysql.TeachercommentItem;
import cn.ztejjx.memberstore.mapper.mysql.SelfTeachercommentItemMapper;
import cn.ztejjx.memberstore.mapper.mysql.TeachercommentItemMapper;
import cn.ztejjx.memberstore.service.TeachercommentItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class TeachercommentItemServiceImpl implements TeachercommentItemService {

    @Autowired
    private TeachercommentItemMapper teachercommentItemMapper;

    @Autowired
    private SelfTeachercommentItemMapper selfTeachercommentItemMapper;

    @Override
    public int savebatchTeachercommentItemService(List<TeachercommentItem> teachercommentItem) {

        return selfTeachercommentItemMapper.savebatchTeachercommentItemService(teachercommentItem);
    }
}
