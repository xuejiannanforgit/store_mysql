package cn.ztejjx.memberstore.service.impl;


import cn.ztejjx.memberstore.domain.mysql.AttentionInfo;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import cn.ztejjx.memberstore.mapper.mysql.attentionInfoMapper;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class AttentionInfoServiceImpl implements cn.ztejjx.memberstore.service.AttentionInfoService {


    @Autowired
    private attentionInfoMapper attentionInfoMapper;

    @Override
    public int saveAttentionInfo(AttentionInfo attentionInfo) {



        attentionInfo.setAttentionId(UUID.randomUUID().toString().replace("-", ""));
        attentionInfo.setEnabledFlag(1);
        attentionInfo.setCreatedDate(new Date());
        return attentionInfoMapper.insert(attentionInfo);
    }


    @Override
    public List<AttentionInfo> findAttentionInfoByMemberPhone(String MemberPhone) {

        QueryWrapper<AttentionInfo> wrapper = new QueryWrapper<AttentionInfo>();
        wrapper.eq("sharememberPhone",MemberPhone);
        return this.attentionInfoMapper.selectList(wrapper);
    }
}
