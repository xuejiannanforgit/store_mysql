package cn.ztejjx.memberstore.service.impl;

import cn.ztejjx.memberstore.domain.mysql.sharerecord;
import cn.ztejjx.memberstore.service.sharerecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class sharerecordServiceImpl implements sharerecordService {

    @Autowired
    private cn.ztejjx.memberstore.mapper.mysql.sharerecordMapper sharerecordMapper;

    @Autowired
    private  cn.ztejjx.memberstore.mapper.mysql.selfsharerecordMapper selfsharerecordMapper;

    @Autowired
    private  cn.ztejjx.memberstore.mapper.mysql.selfmemberInfoMapper selfmemberInfoMapper;

    @Override
    public int savesharerecord(sharerecord sharerecord) {
        sharerecord.setSharerecordId(UUID.randomUUID().toString().replace("-", ""));
        sharerecord.setCreatedDate(new Date());
        sharerecord.setEnabledFlag(1);
        int count =  sharerecordMapper.insert(sharerecord);
        selfmemberInfoMapper.updateShareCount(sharerecord.getMemberId());
        return count;
    }

    @Override
    public List<sharerecord> findSharerecord(String memberId, int currIndex, int pageSize) {

        Map<String, Object> data = new HashMap<>();
        data.put("currIndex", (currIndex-1)*pageSize);
        data.put("pageSize",  pageSize);
        data.put("memberId", memberId);
        return  selfsharerecordMapper.findSharerecord(data);
     }
}
