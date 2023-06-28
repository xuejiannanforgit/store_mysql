package cn.ztejjx.memberstore.controller;

import cn.ztejjx.memberstore.domain.AdvertisingSubmit;
import cn.ztejjx.memberstore.domain.mysql.Advertising;
import cn.ztejjx.memberstore.service.AdvertisingService;
import cn.ztejjx.memberstore.service.AdvertisingSubmitService;
import cn.ztejjx.memberstore.utils.RedisUtils;
import cn.ztejjx.memberstore.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/pri/Advertising")
@Transactional
public class AdvertisingController {

    @Autowired
    private AdvertisingService advertisingService;

    @Autowired
    private AdvertisingSubmitService advertisingSubmitService;

    @Autowired
    private RedisUtils redisUtil;


    @RequestMapping("/findAdvertising")
    public ResultUtils findAdvertising(Advertising advertising)
    {
        List<Advertising> list  = (List<Advertising>)redisUtil.get("findAdvertising");
        if(list==null)
        {
            list =   advertisingService.findAdvertisingService();
            redisUtil.set("findAdvertising",list);
        }
        return ResultUtils.success("查询成功",list);
     }

    @RequestMapping("/saveAdvertisingSubmit")
    public ResultUtils saveAdvertisingSubmit(AdvertisingSubmit advertisingSubmit)
    {
        advertisingSubmit.setAdvertisingSubmitid(UUID.randomUUID().toString().replace("-", ""));
        advertisingSubmit.setEnableFlag(1);
        advertisingSubmit.setCreateDate(new Date());
        advertisingSubmitService.saveAdvertisingSubmitInfo(advertisingSubmit);
        return ResultUtils.success("保存成功");
    }




}
