package cn.ztejjx.memberstore.service.impl;

import cn.ztejjx.memberstore.domain.AdvertisingSubmit;
import cn.ztejjx.memberstore.mapper.mysql.AdvertisingMapper;
import cn.ztejjx.memberstore.service.AdvertisingSubmitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdvertisingSubmitServiceImpl implements AdvertisingSubmitService {

    @Autowired
    private cn.ztejjx.memberstore.mapper.mysql.AdvertisingSubmitMapper advertisingSubmitMapper;

    @Override
    public int saveAdvertisingSubmitInfo(AdvertisingSubmit aAdvertisingSubmit) {
        return  advertisingSubmitMapper.insert(aAdvertisingSubmit);
    }
}
