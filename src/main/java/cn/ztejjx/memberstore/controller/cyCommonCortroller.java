package cn.ztejjx.memberstore.controller;


import cn.ztejjx.memberstore.domain.mysql.ResumeInfo;
import cn.ztejjx.memberstore.service.BlacklistService;
import cn.ztejjx.memberstore.service.RecruitInfoService;
import cn.ztejjx.memberstore.service.ResumeInfoService;
import cn.ztejjx.memberstore.utils.HttpUtils;
import cn.ztejjx.memberstore.utils.ResultUtils;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/pri/cycommonServer")
@Transactional
public class cyCommonCortroller {

    @Autowired
    private cn.ztejjx.memberstore.service.BlacklistService BlacklistService;

    @Autowired
    private RecruitInfoService recruitInfoService;

    @Autowired
    private ResumeInfoService resumeInfoService;


    @RequestMapping("/validateBlacklist")
    public Object validateBlacklist( String openid)
    {
      int count =   BlacklistService.validateBlacklist(openid);
      return  ResultUtils.success("查询成功",count);
    }

    @RequestMapping("/saveResumeInfo")
    public ResultUtils saveResumeInfo(ResumeInfo resumeInfo)
    {
        System.out.println(resumeInfo.toString());
        resumeInfo.setResumeInfoid(UUID.randomUUID().toString().replace("-", ""));
        resumeInfo.setEnableFlag(1);
        resumeInfo.setCreateDate(new Date());
      int count = resumeInfoService.saveResumeInfoS(resumeInfo);
      return  ResultUtils.success("申请成功");
    }

}
