package cn.ztejjx.memberstore.mapper.mysql;

import cn.ztejjx.memberstore.domain.mysql.projectsclass;

import java.util.List;
import java.util.Map;

public interface selfprojectsMapper {

    List<projectsclass> findProjects();

    projectsclass findProjectsByprojectsclassId(Map<String, Object> data);
}
