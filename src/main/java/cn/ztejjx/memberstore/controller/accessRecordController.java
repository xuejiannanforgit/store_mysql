package cn.ztejjx.memberstore.controller;
import cn.ztejjx.memberstore.domain.mysql.accessrecord;
import cn.ztejjx.memberstore.domain.mysql.memberInfo;
import cn.ztejjx.memberstore.service.accessRecordService;
import cn.ztejjx.memberstore.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/pri/accessRecord")
@Transactional
public class accessRecordController {

    @Autowired
    private accessRecordService accessRecordService;

    @Autowired
    private cn.ztejjx.memberstore.service.memberInfoService memberInfoService;

    @RequestMapping("/SaveAccessRecord")
    public ResultUtils SaveAccessRecord(accessrecord accessrecord) {


        int count = accessRecordService.SaveAccessRecord(accessrecord);
        if (count > 0) {
            return ResultUtils.success("保存成功", null);
        } else {
            return ResultUtils.fail("保存失败", null);
        }
    }


    @RequestMapping("/findAccessrecord")
    public ResultUtils queryAccessrecord(String memberId, int currPage, int pageSize) {

        Map<String,Object> map = new HashMap<>();
        List<memberInfo> list =null;
        if(currPage==1)
        {
            list = memberInfoService.findMemberInfobymemberId(memberId);
            map.put("MemberInfo",list.get(0));
            List<accessrecord> accessrecordlist  = accessRecordService.findAccessrecord(memberId,currPage,pageSize);
            map.put("accessrecordlist",accessrecordlist);
        }
        else
        {
            List<accessrecord> accessrecordlist  = accessRecordService.findAccessrecord(memberId,currPage,pageSize);
            map.put("accessrecordlist",accessrecordlist);
        }

        return ResultUtils.success("查询成功", map);
    }
}






