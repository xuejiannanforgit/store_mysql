package cn.ztejjx.memberstore.mapper.mysql;

import cn.ztejjx.memberstore.domain.mysql.TeachercommentItem;

import java.util.List;

public interface SelfTeachercommentItemMapper {

  int  savebatchTeachercommentItemService(List<TeachercommentItem> teachercommentItem);
}
