package cn.ztejjx.memberstore.controller;

import cn.ztejjx.memberstore.domain.mysql.activitieImage;
import cn.ztejjx.memberstore.domain.mysql.configActivitie;
import cn.ztejjx.memberstore.domain.mysql.configImage;
import cn.ztejjx.memberstore.domain.mysql.configProduct;
import cn.ztejjx.memberstore.utils.RedisUtils;
import cn.ztejjx.memberstore.utils.ResultUtils;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/pri/configActivitie")
@Transactional
public class configActivitieController {

    @Autowired
    private cn.ztejjx.memberstore.service.configActivitieService configActivitieService;

    @Autowired
    private cn.ztejjx.memberstore.service.activitieRecordService activitieRecordService;

    @Autowired
    private cn.ztejjx.memberstore.service.memberInfoService memberInfoService;


    @Autowired
    private RedisUtils redisUtil;

    @Autowired
    private cn.ztejjx.memberstore.task.AsyncTask asyncTask;

    @Autowired
    private cn.ztejjx.memberstore.service.activitieImageService activitieImageService;




    @Autowired
    private cn.ztejjx.memberstore.service.configImageService configImageService;

    @Autowired
    private cn.ztejjx.memberstore.service.configProductService configProductService;





    @RequestMapping("/addzan")
    public ResultUtils addzan(String activities, String shareopenId, String openId, String nickName, String avatarurl, String memberPhone)
    {
        JSONObject jsonObject = JSONObject.parseObject(activities);
        configActivitie configActivitie =   JSONObject.toJavaObject(jsonObject,configActivitie.class);
        configActivitieService.addzan(configActivitie.getActivitiesId());
        redisUtil.del("configActivitie");
        if(!"undefined".equals(shareopenId))
        {
            asyncTask.addzanIntegral(configActivitie, shareopenId, openId, nickName, avatarurl,memberPhone);
        }
        return  ResultUtils.success("点赞成功",null);
    }

    @RequestMapping("/findConfigActivitieList")
    public ResultUtils findConfigActivitieList()
    {
        List<configActivitie> list = null;
        if(redisUtil.get("configActivitie")==null)
        {
            list = configActivitieService.findConfigActivitieList();
            redisUtil.set("configActivitie",list);
        }
        else
        {
            list = (List<configActivitie>)redisUtil.get("configActivitie");
        }
       return   ResultUtils.success("查询成功",list);
    }

    @RequestMapping("/findConfigActivitieListbyId")
    public ResultUtils findConfigActivitieListbyId(String activitiesId)
    {
        Map<String,Object> map = new HashMap<>();


        List<activitieImage> activitieImagelist = null;
        if(redisUtil.hget("findactivitieImageByactivitiesId",activitiesId)==null)
        {
            activitieImagelist = activitieImageService.findactivitieImageByactivitiesId(activitiesId);
            redisUtil.hset("findactivitieImageByactivitiesId",activitiesId,activitieImagelist,604800);
        }
        else
        {
            activitieImagelist = (List<activitieImage>)redisUtil.hget("findactivitieImageByactivitiesId",activitiesId);
        }


        configActivitie  configActivitie = configActivitieService.findConfigActivitieListbyId(activitiesId);

        List<configImage> configImagelist = null;
        if(redisUtil.get("findConfigImage")==null)
        {
            configImagelist = configImageService.findConfigImage();
            redisUtil.set("findConfigImage",configImagelist);
        }
        else
        {
            configImagelist = ( List<configImage>)redisUtil.get("findConfigImage");
        }


        List<configProduct> recommendProductlist = null;
        if(redisUtil.get("recommendProductlist")==null)
        {
            recommendProductlist = configProductService.findRecommendProduct();
            redisUtil.set("recommendProductlist",recommendProductlist);
        }
        else
        {
            recommendProductlist = ( List<configProduct>)redisUtil.get("recommendProductlist");
        }



        map.put("activitieImagelist",activitieImagelist);
        map.put("configImagelist",configImagelist);
        map.put("configActivitie",configActivitie);
        map.put("recommendProductlist",recommendProductlist);

        return   ResultUtils.success("查询成功",map);
    }



}



