package cn.ztejjx.memberstore.controller;


import cn.ztejjx.memberstore.domain.mysql.configImage;
import cn.ztejjx.memberstore.utils.RedisUtils;
import cn.ztejjx.memberstore.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pri/configImage")
@Transactional
public class configImageController {


    @Autowired
    private cn.ztejjx.memberstore.service.configImageService configImageService;

    @Autowired
    private RedisUtils redisUtil;

    @RequestMapping("/findConfigImage")
    public ResultUtils findConfigImage()
    {
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
//        List<configImage>  configImagelist = configImageService.findConfigImage();
        return  ResultUtils.success("查询成功",configImagelist) ;
    }
}
