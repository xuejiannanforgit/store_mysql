package cn.ztejjx.memberstore.controller;
import cn.ztejjx.memberstore.domain.PageResult;
import cn.ztejjx.memberstore.domain.mysql.Advertising;
import cn.ztejjx.memberstore.domain.mysql.PersonForCar;
import cn.ztejjx.memberstore.domain.mysql.RecruitInfo;
import cn.ztejjx.memberstore.service.AdvertisingService;
import cn.ztejjx.memberstore.service.RecruitInfoService;
import cn.ztejjx.memberstore.task.AsyncTask;
import cn.ztejjx.memberstore.utils.RedisUtils;
import cn.ztejjx.memberstore.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

import cn.ztejjx.memberstore.domain.mysql.memberInfo;
import cn.ztejjx.memberstore.domain.mysql.memberIntegral;
@RestController
@RequestMapping("/api/v1/pri/personforCar")
@Transactional
public class personforCarController {

    @Autowired
    private AsyncTask asyncTask;
    @Autowired
    private RedisUtils redisUtil;
    @Autowired
    private cn.ztejjx.memberstore.service.personforCarService personforCarService;

    @Autowired
    private RecruitInfoService recruitInfoService;

    @Autowired
    private AdvertisingService advertisingService;

    @RequestMapping("/findPersonForCarByPaqe")
    public ResultUtils findPersonForCarByPaqe(Integer page, Integer pageSize )
    {
        List<Object>  list = null;
        List<RecruitInfo>  recruitInfolist = null;
        List<Advertising>  advertisinglist  =  null;




        Map<String,Object> map = new HashMap<>();
        if(page==1)
        {
            list = (List<Object>)redisUtil.get("findPersonForCarByPaqe");
            if(list==null)
            {
                list  =   personforCarService.findPersonForCar(page,pageSize).getRows();
                redisUtil.set("findPersonForCarByPaqe",list);
            }

            recruitInfolist = (List<RecruitInfo>)redisUtil.get("recruitInfolist");
            if(recruitInfolist==null)
            {
                recruitInfolist = recruitInfoService.findRecruitInfo();
                redisUtil.set("recruitInfolist",recruitInfolist);
            }



            advertisinglist = (List<Advertising>)redisUtil.get("findAdvertising");
            if(advertisinglist==null)
            {
                advertisinglist =   advertisingService.findAdvertisingService();
                redisUtil.set("findAdvertising",advertisinglist);
            }

            map.put("advertisinglist",advertisinglist);
            map.put("recruitInfolist",recruitInfolist);
            map.put("personforCarlist",list);
        }
        else
        {
            list  =   personforCarService.findPersonForCar(page,pageSize).getRows();
            map.put("personforCarlist",list);

        }
    //    PageResult  PageResult = personforCarService.findPersonForCar(page,pageSize);
        return  ResultUtils.success("success",  map);
    }

    @RequestMapping("/savePersonForCar")
    public ResultUtils savePersonForCar(PersonForCar personForCar)
    { //@RequestParam("imgarr") String imgarr

        redisUtil.del("findPersonForCarByPaqe");
        String PersonForCarId =  personforCarService.savePersonForCar(personForCar);
        memberIntegral memberIntegral=new memberIntegral();
        memberIntegral.setIntegralId(UUID.randomUUID().toString().replace("-", ""));
        memberIntegral.setIntegralType("积分抵扣");
        memberIntegral.setIntegralNum(new BigDecimal(-1).multiply(new BigDecimal(100)));  //积分抵扣数量
        memberIntegral.setMemberId(personForCar.getOpenid());
        memberIntegral.setMemberName(personForCar.getUsername());
        memberIntegral.setMemberPhone( personForCar.getPhone());
        memberIntegral.setAddintegralReason("信息发布");
        memberIntegral.setApplicationItems("发布找对班");
        memberIntegral.setOrderId(PersonForCarId);
        memberIntegral.setEnabledFlag(1);
        memberIntegral.setCreatedDate(new Date());
        //保存积分消费记录，更新积分
        asyncTask.saveMemberIntegral(memberIntegral);
        return ResultUtils.success("保存成功");
    }

    @RequestMapping("/subjectIntegral")
    public ResultUtils subjectIntegral(PersonForCar personForCar)
    {
        memberIntegral memberIntegral=new memberIntegral();
        memberIntegral.setIntegralId(UUID.randomUUID().toString().replace("-", ""));
        memberIntegral.setIntegralType("积分抵扣");
        memberIntegral.setIntegralNum(new BigDecimal(-1).multiply(new BigDecimal(20)));  //积分抵扣数量
        memberIntegral.setMemberId(personForCar.getOpenid());
        memberIntegral.setMemberName(personForCar.getUsername());
        memberIntegral.setMemberPhone( personForCar.getPhone());
        memberIntegral.setAddintegralReason("信息查询");
        memberIntegral.setApplicationItems("查看联系方式");
        memberIntegral.setEnabledFlag(1);
        memberIntegral.setCreatedDate(new Date());
        //保存积分消费记录，更新积分
        asyncTask.saveMemberIntegral(memberIntegral);
        return ResultUtils.success("保存成功");
    }


}
