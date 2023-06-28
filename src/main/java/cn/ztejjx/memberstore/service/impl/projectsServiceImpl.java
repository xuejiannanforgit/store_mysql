package cn.ztejjx.memberstore.service.impl;

import cn.ztejjx.memberstore.domain.mysql.projectsclass;
import cn.ztejjx.memberstore.service.projectsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class projectsServiceImpl implements projectsService {

    @Autowired
    private cn.ztejjx.memberstore.mapper.mysql.selfprojectsMapper selfprojectsMapper;

    @Override
    public List<projectsclass> findProjects() {
        return selfprojectsMapper.findProjects();
    }

    @Override
    public projectsclass findProjectsByprojectsclassId(String projectsclassId) {

        Map<String, Object> data = new HashMap<>();
        data.put("projectsclassId",projectsclassId);

        return selfprojectsMapper.findProjectsByprojectsclassId(data);
    }

}
