package cn.ztejjx.memberstore.service.impl;


import cn.ztejjx.memberstore.domain.mysql.oilPrice;
import cn.ztejjx.memberstore.service.oilPriceService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class oilPriceServiceImpl implements oilPriceService {
    @Autowired
    private  cn.ztejjx.memberstore.mapper.mysql.oilPriceMapper  oilPriceMapper;

    @Override
    public List<oilPrice> findOilPrice(String area,String oilClass,String oilType) {



        QueryWrapper<oilPrice>  wrapper = new QueryWrapper<>();
        wrapper.eq("area",area);
        wrapper.eq("oil_Class",oilClass);
        wrapper.eq("oil_Type",oilType);
        wrapper.eq("enabled_Flag",1);
        wrapper.eq("use_Flag","是");

        return  this.oilPriceMapper.selectList(wrapper);
    }
}
