package cn.ztejjx.memberstore.controller;


import cn.ztejjx.memberstore.service.configProductBrandsService;
import cn.ztejjx.memberstore.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/pri/configProductBrands")
@Transactional
public class configProductBrandsController {

    @Autowired
    private configProductBrandsService configProductBrandsService;

    @Autowired
    private RedisUtils redisUtil;
}
