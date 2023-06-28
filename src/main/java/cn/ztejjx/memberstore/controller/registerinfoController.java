package cn.ztejjx.memberstore.controller;
import cn.ztejjx.memberstore.domain.mysql.registerinfo;
import cn.ztejjx.memberstore.service.registerInfoService;
import cn.ztejjx.memberstore.utils.RedisUtils;
import cn.ztejjx.memberstore.utils.ResultUtils;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pri/registerinfo")
@Transactional
public class registerinfoController {

    @Autowired
    private registerInfoService registerInfoService;

    @Autowired
    private RedisUtils redisUtil;

    @RequestMapping("/saveRegisterInfotoRedis")
    public ResultUtils saveRegisterInfotoRedis(String  registerinfoJson)
    {
        JSONObject JS = JSONObject.parseObject(registerinfoJson);
        registerinfo registerinfo =	(cn.ztejjx.memberstore.domain.mysql.registerinfo) JSONObject.toJavaObject(JS, cn.ztejjx.memberstore.domain.mysql.registerinfo.class);
        String key  = "registerinfo-"+ registerinfo.getProjectsclassname();
        String item = registerinfo.getPhone();
        int time = 60*60*24*2; //过期时间2天
        String result = JSONObject.toJSON(registerinfo).toString();
        redisUtil.hset(key,item,result,time);


        return ResultUtils.success("提交成功");
    }

    @RequestMapping("/saveRegisterInfo")
    public ResultUtils saveRegisterInfotoRedis(registerinfo registerinfo)
    {
        int size = registerInfoService.findRegisterInfobyphone(registerinfo.getPhone(),registerinfo.getProjectsintroductionId());
        if(size>0)
        {
            return  ResultUtils.fail("信息已提交");
        }
        else
        {
            int count =  registerInfoService.saveRegisterInfo(registerinfo);
            if(count>0)
            {
                return ResultUtils.success("提交成功");
            }
            else
            {
                return  ResultUtils.fail("提交失败");
            }
        }
    }
}


