package cn.ztejjx.memberstore.service.impl;

import cn.ztejjx.memberstore.domain.redis.SelfConfigProductClassify;
import cn.ztejjx.memberstore.mapper.mysql.SelfConfigProductClassifyMapper;
import cn.ztejjx.memberstore.service.configProductClassifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class configProductClassifyServiceImpl  implements configProductClassifyService {

    @Autowired
    private SelfConfigProductClassifyMapper selfConfigProductClassifyMapper;

    @Override
    public List<SelfConfigProductClassify> findProductList() {

        List<SelfConfigProductClassify> list   =  selfConfigProductClassifyMapper.findProductList();

        return list;
    }
}
