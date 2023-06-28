package cn.ztejjx.memberstore.service;

import cn.ztejjx.memberstore.domain.mysql.projectsclass;

import java.util.List;

public interface projectsService {

    List<projectsclass> findProjects();
    projectsclass findProjectsByprojectsclassId(String projectsclassId);
}
