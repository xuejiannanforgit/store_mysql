package cn.ztejjx.memberstore.controller;


import cn.ztejjx.memberstore.service.configProductClassifyService;
import cn.ztejjx.memberstore.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pri/configProductClassify")
@Transactional
public class configProductClassifyController {

    @Autowired
    private configProductClassifyService configProductClassifyService;

    @Autowired
    private RedisUtils redisUtil;
}
