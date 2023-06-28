package cn.ztejjx.memberstore.service.impl;

import cn.ztejjx.memberstore.domain.mysql.accessrecord;
import cn.ztejjx.memberstore.service.accessRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class accessRecordServiceImpl implements accessRecordService {

    @Autowired
    private cn.ztejjx.memberstore.mapper.mysql.accessRecordMapper accessRecordMapper;


    @Autowired
    private  cn.ztejjx.memberstore.mapper.mysql.selfaccessRecordMapper selfaccessRecordMapper;

    @Autowired
    private  cn.ztejjx.memberstore.mapper.mysql.selfmemberInfoMapper selfmemberInfoMapper;



    @Override
    public int SaveAccessRecord(accessrecord accessrecord) {
        accessrecord.setRecordId(UUID.randomUUID().toString().replace("-", ""));
        accessrecord.setCreatedDate(new Date());
        accessrecord.setEnabledFlag(1);
        int count =  accessRecordMapper.insert(accessrecord);
        selfmemberInfoMapper.updateVisitCount(accessrecord.getMemberId());
        return count;

    }


    @Override
    public List<accessrecord> findAccessrecord(String memberId,int currIndex,int pageSize) {

        Map<String, Object> data = new  HashMap<>();
        data.put("currIndex", (currIndex-1)*pageSize);
        data.put("pageSize",  pageSize);
        data.put("memberId", memberId);
        return  selfaccessRecordMapper.findAccessrecord(data);
    }
}
