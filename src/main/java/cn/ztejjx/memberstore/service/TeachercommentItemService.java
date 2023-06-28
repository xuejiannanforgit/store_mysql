package cn.ztejjx.memberstore.service;


import cn.ztejjx.memberstore.domain.mysql.TeachercommentItem;

import java.util.List;

public interface TeachercommentItemService {

    int savebatchTeachercommentItemService(List<TeachercommentItem> teachercommentItem);

}
