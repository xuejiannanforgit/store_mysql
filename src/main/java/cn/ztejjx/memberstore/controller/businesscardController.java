package cn.ztejjx.memberstore.controller;
import cn.ztejjx.memberstore.domain.mysql.configProduct;
import cn.ztejjx.memberstore.domain.mysql.photoclass;
import cn.ztejjx.memberstore.domain.mysql.projectsclass;
import cn.ztejjx.memberstore.service.photoService;
import cn.ztejjx.memberstore.utils.RedisUtils;
import cn.ztejjx.memberstore.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cn.ztejjx.memberstore.service.configProductService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/pri/businesscardInfo")
@Transactional
public class businesscardController {

    @Value("${redis_Expire}")
    private int redisExpire;

    @Autowired
    private RedisUtils redisUtil;

    @Autowired
    private photoService photoService;

    @Autowired
    private cn.ztejjx.memberstore.service.projectsService projectsService;

    @Autowired
    private configProductService configProductService;



    @RequestMapping("/findProjectsByprojectsclassId")
    public ResultUtils findProjectsByprojectsclassId(String projectsclassId) {
        projectsclass projectsclass =  projectsService.findProjectsByprojectsclassId(projectsclassId);
        return  ResultUtils.success(projectsclass);
    }

    @RequestMapping("/findBusinesscardInfo")
    public ResultUtils findBusinesscardInfo()
    {
        Map<String,Object> map = new HashMap<>();

        List<photoclass> photoAlbumlist = null;
        List<configProduct> recommendProductlist = null;
        List<projectsclass>   projectsclasslist  = null;

        if(redisUtil.get("photoAlbumlist")==null)
        {
            photoAlbumlist  = photoService.findPhoto();
            redisUtil.set("photoAlbumlist",photoAlbumlist);
        }
        else
        {
            photoAlbumlist = (List<photoclass>)redisUtil.get("photoAlbumlist");
        }
        map.put("photoAlbumlist",photoAlbumlist);

        if(redisUtil.get("projectsclasslist")==null)
        {
            projectsclasslist  = projectsService.findProjects();
            redisUtil.set("projectsclasslist",projectsclasslist);
        }
        else
        {
            projectsclasslist = (List<projectsclass>)redisUtil.get("projectsclasslist");
        }

        if(redisUtil.get("recommendProductlist")==null)
        {
            recommendProductlist = configProductService.findRecommendProduct();
            redisUtil.set("recommendProductlist",recommendProductlist);
        }
        else
        {
            recommendProductlist = (List<configProduct>)redisUtil.get("recommendProductlist");
        }

        map.put("photoAlbumlist",photoAlbumlist);
        map.put("projectsclasslist",projectsclasslist);
        map.put("recommendProductlist",recommendProductlist);
       return  ResultUtils.success(map);
    }







}
