package cn.ztejjx.memberstore.controller;
import cn.ztejjx.memberstore.domain.mysql.memberInfo;
import cn.ztejjx.memberstore.domain.mysql.memberIntegral;
import cn.ztejjx.memberstore.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.*;


@RestController
@RequestMapping("/api/v1/pri/memberIntegral")
@Transactional
public class memberIntegralController {

    @Autowired
    private cn.ztejjx.memberstore.task.AsyncTask asyncTask;

    @Autowired
    private cn.ztejjx.memberstore.service.memberIntegralService memberIntegralService;


    @Autowired
    private cn.ztejjx.memberstore.service.memberInfoService memberInfoService;


    @RequestMapping("/findInitMemberIntegral")
    public ResultUtils findInitMemberIntegral(String memberId, int currPage, int pageSize) {
        List<memberIntegral> memberIntegrallist = memberIntegralService.findMemberIntegral(memberId,currPage,pageSize);
        Integer count = memberIntegralService.countMemberIntegral(memberId);
        Map<String,Object> map =new HashMap<>();
        map.put("memberIntegrallist",memberIntegrallist);
        if(count == null)
        {
            map.put("count",0);
        }
        else
        {
            map.put("count",count);
        }


        return ResultUtils.success("查询成功",map);
    }

    @RequestMapping("/findMemberIntegral")
    public ResultUtils findMemberIntegral(String memberId, int currPage, int pageSize) {
        List<memberIntegral> memberIntegrallist = memberIntegralService.findMemberIntegral(memberId,currPage,pageSize);
        return ResultUtils.success("查询成功",memberIntegrallist);
    }


    @RequestMapping("/countMemberIntegral")
    public ResultUtils countMemberIntegral(String memberId)
    {

        int count = memberIntegralService.countMemberIntegral(memberId);

        return ResultUtils.success("用户积分",count);
    }


    @RequestMapping("/saveMemberIntegral")
    public ResultUtils saveMemberIntegral(@RequestBody memberIntegral memberIntegral)
    {
       int count = memberIntegralService.saveMemberIntegral(memberIntegral);
        if(count==0)
        {
            return ResultUtils.fail("积分添加失败",null);
        }
        else
        {
            return ResultUtils.success("积分添加成功",null);
        }
    }

    @RequestMapping("/addMemberIntegralBymemberPhone")
    public ResultUtils addMemberIntegralBymemberPhone(String memberPhone, String integralNum, String reason, String applicationItems, String createBy)
    {
        List<memberInfo> list = memberInfoService.findMemberInfoBymemberPhone(memberPhone);
        if(list.size()==0)
        {
            return ResultUtils.fail("信息查询为空",null);
        }
        else
        {
            memberInfo memberInfo = list.get(0);
            memberIntegral memberIntegral=new memberIntegral();
            memberIntegral.setIntegralId(UUID.randomUUID().toString().replace("-", ""));
            memberIntegral.setIntegralType("积分增加");
            memberIntegral.setIntegralNum(new BigDecimal(integralNum) );  //积分抵扣数量
            memberIntegral.setMemberId(memberInfo.getMemberId());
            memberIntegral.setMemberName(memberInfo.getMemberName());
            memberIntegral.setMemberPhone(memberInfo.getMemberPhone());
            memberIntegral.setAddintegralReason(reason);
            memberIntegral.setApplicationItems(applicationItems);
            memberIntegral.setOrderId(null);
            memberIntegral.setEnabledFlag(1);
            memberIntegral.setCreatedDate(new Date());
            memberIntegral.setLastUpdatedBy(createBy);
            //保存积分消费记录，更新积分
            asyncTask.saveMemberIntegral(memberIntegral);
            return ResultUtils.success("积分添加成功",null);
        }
    }


    @RequestMapping("/subtractMemberIntegralBymemberPhone")
    public ResultUtils subtractMemberIntegralBymemberPhone(String memberPhone, String integralNum, String reason, String applicationItems, String createBy)
    {
        List<memberInfo> list = memberInfoService.findMemberInfoBymemberPhone(memberPhone);
        if(list.size()==0)
        {
            return ResultUtils.fail("信息查询为空",null);
        }
        else
        {
            memberInfo memberInfo = list.get(0);
            memberIntegral memberIntegral=new memberIntegral();
            memberIntegral.setIntegralId(UUID.randomUUID().toString().replace("-", ""));
            memberIntegral.setIntegralType("积分抵扣");
            memberIntegral.setIntegralNum(new BigDecimal(integralNum).multiply(new BigDecimal(-1)) );  //积分抵扣数量
            memberIntegral.setMemberId(memberInfo.getMemberId());
            memberIntegral.setMemberName(memberInfo.getMemberName());
            memberIntegral.setMemberPhone(memberInfo.getMemberPhone());
            memberIntegral.setAddintegralReason(reason);
            memberIntegral.setApplicationItems(applicationItems);
            memberIntegral.setOrderId(null);
            memberIntegral.setEnabledFlag(1);
            memberIntegral.setCreatedDate(new Date());
            memberIntegral.setLastUpdatedBy(createBy);
            //保存积分消费记录，更新积分
            asyncTask.saveMemberIntegral(memberIntegral);
            return ResultUtils.success("积分添加成功",null);
        }
    }
}
