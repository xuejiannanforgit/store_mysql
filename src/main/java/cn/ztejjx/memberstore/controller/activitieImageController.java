package cn.ztejjx.memberstore.controller;

import cn.ztejjx.memberstore.domain.mysql.activitieImage;
import cn.ztejjx.memberstore.domain.mysql.configImage;
import cn.ztejjx.memberstore.domain.mysql.configProduct;
import cn.ztejjx.memberstore.service.activitieImageService;
import cn.ztejjx.memberstore.utils.RedisUtils;
import cn.ztejjx.memberstore.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/pri/activitieImage")
@Transactional
public class activitieImageController {

    @Autowired
    private activitieImageService activitieImageService;

    @Autowired
    private RedisUtils redisUtil;


    @Autowired
    private cn.ztejjx.memberstore.service.configImageService configImageService;

    @Autowired
    private cn.ztejjx.memberstore.service.configProductService configProductService;

    @Autowired
    private cn.ztejjx.memberstore.service.activitieRecordService activitieRecordService;


    @RequestMapping("/findactivitieImageByactivitiesId")
    public ResultUtils findactivitieImageByactivitiesId(String activitiesId)
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

        map.put("configImagelist",configImagelist);
        map.put("activitieImagelist",activitieImagelist);
        map.put("recommendProductlist",recommendProductlist);

        return   ResultUtils.success("查询成功",map);
    }
}
