package cn.ztejjx.memberstore.service.impl;


import cn.ztejjx.memberstore.domain.mysql.businessIntroduction;
import cn.ztejjx.memberstore.service.businessIntroductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class businessIntroductionServiceImpl implements businessIntroductionService {
    @Autowired
    private cn.ztejjx.memberstore.mapper.mysql.businessIntroductionMapper businessIntroductionMapper;

    @Override
    public void selectList() {

       List<businessIntroduction> businessIntroductionlist = businessIntroductionMapper.selectList(null);
       for( businessIntroduction bi:   businessIntroductionlist)
       {
              System.out.println(bi);
       }
    }
}
