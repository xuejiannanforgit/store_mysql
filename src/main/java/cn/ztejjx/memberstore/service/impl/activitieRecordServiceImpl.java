package cn.ztejjx.memberstore.service.impl;

import cn.ztejjx.memberstore.domain.mysql.activitieRecord;
import cn.ztejjx.memberstore.mapper.mysql.activitieRecordMapper;
import cn.ztejjx.memberstore.service.activitieRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class activitieRecordServiceImpl implements activitieRecordService {

    @Autowired
    private activitieRecordMapper activitieRecordMapper;

    @Autowired
    private cn.ztejjx.memberstore.mapper.mysql.selfactivitieRecordMapper selfactivitieRecordMapper;


    @Override
    public int saveactivitieRecord(activitieRecord activitieRecord) {
        return this.activitieRecordMapper.insert(activitieRecord);
    }

    @Override
    public int validateCount(String openId, String shareopenId, String activitiesId) {

        Map<String, Object> data = new HashMap<>();
        data.put("openId",  openId);
        data.put("shareopenId",  shareopenId);
        data.put("activitiesId",  activitiesId);
        return selfactivitieRecordMapper.validateCount(data);
    }

    @Override
    public int validateShareCount(String shareopenId, String activitiesId) {
        Map<String, Object> data = new HashMap<>();
        data.put("shareopenId",  shareopenId);
        data.put("activitiesId",  activitiesId);
        return selfactivitieRecordMapper.validateShareCount(data);
    }
}
