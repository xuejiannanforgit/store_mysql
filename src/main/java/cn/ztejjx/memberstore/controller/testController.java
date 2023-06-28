package cn.ztejjx.memberstore.controller;
import cn.ztejjx.memberstore.domain.mysql.accessrecord;
import cn.ztejjx.memberstore.domain.mysql.memberInfo;
import cn.ztejjx.memberstore.service.accessRecordService;
import cn.ztejjx.memberstore.service.memberInfoService;
import cn.ztejjx.memberstore.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/pub")
@Transactional
public class testController {

    @Autowired
    private cn.ztejjx.memberstore.service.memberInfoService memberInfoService;

    @RequestMapping("/testfunction")
    public ResultUtils testfunction(String memberId ) {

        List<memberInfo> list = memberInfoService.findMemberInfobymemberId(memberId);
        return ResultUtils.fail("查询成功",list);
    }



}






