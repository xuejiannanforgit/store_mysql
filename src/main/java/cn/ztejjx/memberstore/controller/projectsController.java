package cn.ztejjx.memberstore.controller;

import cn.ztejjx.memberstore.domain.mysql.projectsclass;
import cn.ztejjx.memberstore.utils.RedisUtils;
import cn.ztejjx.memberstore.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pri/projects")
@Transactional
public class projectsController {

    @Autowired
    private RedisUtils redisUtil;

    @Autowired
    private cn.ztejjx.memberstore.service.projectsService projectsService;

    @RequestMapping("/findProjects")
    public ResultUtils findProjects(){

        List<projectsclass> projectsclasslist = null;
        if(redisUtil.get("projectsclasslist")==null)
        {
            projectsclasslist  = projectsService.findProjects();
            redisUtil.set("projectsclasslist",projectsclasslist);
        }
        else
        {
            projectsclasslist = (List<projectsclass>)redisUtil.get("projectsclasslist");
        }
        return  ResultUtils.success(projectsclasslist);
    }
}
