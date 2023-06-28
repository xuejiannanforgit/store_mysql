package cn.ztejjx.memberstore.controller;


import cn.ztejjx.memberstore.domain.mysql.memberInfo;
import cn.ztejjx.memberstore.domain.mysql.voteDetail;
import cn.ztejjx.memberstore.utils.RedisUtils;
import cn.ztejjx.memberstore.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/pri/voteDetailServer")
@Transactional
public class voteDetailController {

    @Autowired
    private cn.ztejjx.memberstore.service.voteDetailService voteDetailService;

    @Autowired
    private cn.ztejjx.memberstore.service.memberInfoService memberInfoService;


    @Autowired
    private cn.ztejjx.memberstore.task.AsyncTask asyncTask;

    @Autowired
    private RedisUtils redisUtil;


    @RequestMapping("/saveVoteDetail")
    public ResultUtils saveVoteDetail(voteDetail voteDetail, HttpServletRequest request)
    {
//        redisUtil.hset("voteaddress",voteDetail.getEmployeeId(),request.getRemoteAddr());
        int count = voteDetailService.validateVoteDetail(voteDetail.getEmployeeId(),voteDetail.getOpenId());
        if(count>0)
        {
            return ResultUtils.success("今日已投票",count);
        }
        else
        {
            int savecount = voteDetailService.saveVoteDetail(voteDetail);
            if(savecount>0)
            {
               asyncTask.updateMemberInfoVoteNum(voteDetail.getEmployeeId());
         //       nohup java -jar  -Xmx2g -Xms2g  store_mysql-0.0.1-SNAPSHOT.jar > store_mysql.out  2>&1 &
//                int countnum = voteDetailService.findVoteDetailCountByEmployeeId(voteDetail.getEmployeeId());
//                if(countnum>0)
//                {
//                    memberInfoService.updateMemberInfoVoteNum(voteDetail.getEmployeeId(),countnum);
//                    redisUtil.hset("findVoteDetailCountByEmployeeId",voteDetail.getEmployeeId(),countnum);
//                    List<memberInfo> memberInfoList = memberInfoService.findmemberInfoByVoteNum();
//                    redisUtil.set("findmemberInfoByVoteNum",memberInfoList);
//                }

                return ResultUtils.success("感谢投票",count);
            }
            else
            {
                return ResultUtils.success("保存失败",null);
            }
        }
    }

//    @RequestMapping("/findVoteDetailCountByEmployeeId")
//    public ResultUtils findVoteDetailCountByEmployeeId(String employeeId){
//        int count = voteDetailService.findVoteDetailCountByEmployeeId(employeeId);
//        return ResultUtils.success("查询成功",count);
//     }


    @RequestMapping("/initVoteDetaillistByEmployeeId")
    public ResultUtils initVoteDetaillistByEmployeeId(String employeeId){

        Map<String,Object> map = new HashMap<>();
        int count = 0;
        List<memberInfo> memberInfoList = null;
        count = voteDetailService.findVoteDetailCountByEmployeeId(employeeId);





    if(redisUtil.get("findmemberInfoByVoteNum3")==null)
    {
        memberInfoList = (List<memberInfo>)memberInfoService.findmemberInfoByVoteNum();
        redisUtil.set("findmemberInfoByVoteNum3",memberInfoList,30);
//        System.out.println("findmemberInfoByVoteNum3`1111");
    }
    else
    {
        memberInfoList = (List<memberInfo>)redisUtil.get("findmemberInfoByVoteNum3");
//        System.out.println("findmemberInfoByVoteNum3`1222");
    }

        map.put("memberInfoList",memberInfoList);
        map.put("count",count);
        return ResultUtils.success("查询成功",map);
    }



}
