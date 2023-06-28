package cn.ztejjx.memberstore.controller;

import cn.ztejjx.memberstore.domain.mysql.memberInfo;
import cn.ztejjx.memberstore.utils.RedisUtils;
import cn.ztejjx.memberstore.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pri/memberInfo")
@Transactional
public class memberInfoController {

    @Autowired
    private RedisUtils redisUtil;

    @Autowired
    private cn.ztejjx.memberstore.service.memberInfoService memberInfoService;

    @RequestMapping("/updateMemberInfo")
    public ResultUtils updateMemberInfo(@RequestBody memberInfo memberInfo)
    {
        int count  =  memberInfoService.updateMemberInfo(memberInfo);
        if(count>0)
        {
            List<memberInfo> list = memberInfoService.findMemberInfoBymemberPhone(memberInfo.getMemberPhone());
            return ResultUtils.success ("修改成功",list.get(0));
        }
        else
        {
            return ResultUtils.fail("修改失败",null);
        }
    }

    @RequestMapping("/updateMemberInfoVoteNum")
    public ResultUtils updateMemberInfoVoteNum(String memberId, Integer voteNum)
    {
        int count  =  memberInfoService.updateMemberInfoVoteNum(memberId,voteNum);
        if(count>0)
        {

            return ResultUtils.success ("修改成功",null);
        }
        else
        {
            return ResultUtils.fail("修改失败",null);
        }
    }


    @RequestMapping("/SaveMemberInfo")
    public ResultUtils SaveMemberInfo(@RequestBody memberInfo memberInfo)
    {
        int count  =  memberInfoService.selectCountBymemberIdcard(memberInfo.getMemberIdcard());
        if(count>0)
        {
            return ResultUtils.fail("会员已注册",null);
        }
        else
        {
            int num = memberInfoService.SaveMemberInfo(memberInfo);
            if(num==0)
            {
                return ResultUtils.fail("注册失败",null);
            }
            else
            {
                return ResultUtils.success("注册成功",null);
            }
         }
    }

    @RequestMapping("/findMemberInfoBymemberPhone")
    public ResultUtils findMemberInfoBymemberPhone(String memberPhone)
    {
          List<memberInfo> list = memberInfoService.findMemberInfoBymemberPhone(memberPhone);
          if(list.size()==0)
          {
              return ResultUtils.fail("信息查询为空",null);
          }
          else
          {
              return ResultUtils.success("绑定成功",list.get(0));
          }
    }

    @RequestMapping("/findMemberInfobymemberId")
    public ResultUtils findMemberInfobymemberId(String memberId)
    {

        memberInfo memberInfo = (memberInfo)redisUtil.hget("findMemberInfobymemberId",memberId);

        if(memberInfo==null)
        {
            System.out.println("no  redisUtil");
            List<memberInfo> list = memberInfoService.findMemberInfobymemberId(memberId);

            if(list.size()==0)
            {
                return ResultUtils.fail("信息查询为空",null);
            }
            else
            {
                redisUtil.hset("findMemberInfobymemberId",memberId,list.get(0));
                return ResultUtils.success("查询成功",list.get(0));
            }
        }
        else
        {

            return ResultUtils.success("查询成功",memberInfo);
        }





    }
}
