package cn.ztejjx.memberstore.controller;
import cn.ztejjx.memberstore.domain.mysql.memberInfo;
import cn.ztejjx.memberstore.domain.mysql.sharerecord;
import cn.ztejjx.memberstore.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/pri/shareRecord")
@Transactional
public class sharerecordController {

    @Autowired
    private cn.ztejjx.memberstore.service.memberInfoService memberInfoService;


    @Autowired
    private cn.ztejjx.memberstore.service.sharerecordService sharerecordService;

    @RequestMapping("/SaveshareRecord")
    public ResultUtils SaveshareRecord(sharerecord sharerecord) {
        int count = sharerecordService.savesharerecord(sharerecord);
        if (count > 0) {
            return ResultUtils.fail("保存成功", null);
        } else {
            return ResultUtils.fail("保存失败", null);
        }
    }

    @RequestMapping("/findSharerecord")
    public ResultUtils findSharerecord(String memberId, int currPage, int pageSize) {

        Map<String,Object> map = new HashMap<>();
        List<memberInfo> list =null;
        if(currPage==1)
        {
            list = memberInfoService.findMemberInfobymemberId(memberId);
            map.put("MemberInfo",list.get(0));
            List<sharerecord> sharerecordlist  = sharerecordService.findSharerecord(memberId,currPage,pageSize);
            map.put("sharerecordlist",sharerecordlist);
        }
        else
        {
            List<sharerecord> sharerecordlist  = sharerecordService.findSharerecord(memberId,currPage,pageSize);
            map.put("sharerecordlist",sharerecordlist);
        }

        return ResultUtils.success("查询成功", map);
    }


}
