package cn.ztejjx.memberstore.controller;

import cn.ztejjx.memberstore.domain.mysql.share;
import cn.ztejjx.memberstore.domain.mysql.shareimage;
import cn.ztejjx.memberstore.service.shareService;
import cn.ztejjx.memberstore.utils.RedisUtils;
import cn.ztejjx.memberstore.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pri/share")
@Transactional
public class shareController {

    @Autowired
    private shareService shareService;

    @Autowired
    private RedisUtils redisUtil;

    @RequestMapping("/saveShare")
    public ResultUtils saveShare(share share)
    {
        redisUtil.hdel("findShareInfo",share.getCoachId());
        int count =   shareService.saveShare(share);
        if(count>0)
        {
            return ResultUtils.success("提交成功");
        }
        else
        {
            return  ResultUtils.fail("提交失败");
        }
    }

    @RequestMapping("/saveShareImage")
    public ResultUtils saveShareImage(shareimage shareimage)
    {
        int count =   shareService.saveShareImage(shareimage);
        if(count>0)
        {
            return ResultUtils.success("提交成功");
        }
        else
        {
            return  ResultUtils.fail("提交失败");
        }
    }


    @RequestMapping("/findShareInfo")
    public ResultUtils findShareInfo(@RequestParam("coachId") String coachId , @RequestParam("currIndex") int currIndex, @RequestParam("pageSize") int pageSize)
    {
                List<share> sharelist = null;
                if(currIndex==1)
                {
                    if(redisUtil.hget("findShareInfo",coachId) ==null)
                    {
                        sharelist =   shareService.findShareInfo(coachId,currIndex, pageSize);
                        redisUtil.hset("findShareInfo",coachId,sharelist);
                    }
                    else
                    {
                        sharelist = (List<share>)redisUtil.hget("findShareInfo",coachId);
                    }
                }
                else
                {
                    sharelist =   shareService.findShareInfo(coachId,currIndex, pageSize);
                }
               return ResultUtils.success("查询成功",sharelist);
    }
}
