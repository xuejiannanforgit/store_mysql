package cn.ztejjx.memberstore.service.impl;

import cn.ztejjx.memberstore.domain.mysql.Advertising;
import cn.ztejjx.memberstore.domain.mysql.Blacklist;
import cn.ztejjx.memberstore.mapper.mysql.AdvertisingMapper;
import cn.ztejjx.memberstore.service.AdvertisingService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdvertisingServiceImpl implements AdvertisingService {

    @Autowired
    private cn.ztejjx.memberstore.mapper.mysql.AdvertisingMapper advertisingMapper;
    @Override
    public List<Advertising> findAdvertisingService() {
        QueryWrapper<Advertising> wrapper = new QueryWrapper<Advertising>();
        wrapper.eq("enable_flag",1);
        return   advertisingMapper.selectList(wrapper);

    }
}
