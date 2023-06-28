package cn.ztejjx.memberstore.controller;

import cn.ztejjx.memberstore.domain.mysql.AttentionInfo;
import cn.ztejjx.memberstore.service.impl.AttentionInfoServiceImpl;
import cn.ztejjx.memberstore.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pri/AttentionInfo")
@Transactional
public class AttentionInfoController {

    @Autowired
    private AttentionInfoServiceImpl attentionInfoService;

    @RequestMapping("/saveAttentionInfo")
    public ResultUtils saveAttentionInfo(AttentionInfo attentionInfo)
    {
        attentionInfoService.saveAttentionInfo(attentionInfo);
        return ResultUtils.success("提交成功");
    }

    @RequestMapping("/findAttentionInfoByMemberPhone")
    public ResultUtils findAttentionInfoByMemberPhone(String MemberPhone)
    {
        List<AttentionInfo> list =  attentionInfoService.findAttentionInfoByMemberPhone(MemberPhone);
        return ResultUtils.success("查询成功",list);
    }

}
