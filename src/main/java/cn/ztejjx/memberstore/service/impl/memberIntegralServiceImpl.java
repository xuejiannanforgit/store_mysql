package cn.ztejjx.memberstore.service.impl;


import cn.ztejjx.memberstore.domain.mysql.memberIntegral;
import cn.ztejjx.memberstore.service.memberIntegralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class memberIntegralServiceImpl implements memberIntegralService {
    @Autowired
    private cn.ztejjx.memberstore.mapper.mysql.memberIntegralMapper memberIntegralMapper;

    @Autowired
    private cn.ztejjx.memberstore.mapper.mysql.selfmemberIntegralMapper selfmemberIntegralMapper;

    @Override
    public List<String> findAllMemberId(){
        return   selfmemberIntegralMapper.findAllMemberId();
    }

    @Override
    public int saveMemberIntegral(memberIntegral memberIntegral) {

        memberIntegral.setEnabledFlag(1);
        memberIntegral.setCreatedDate(new Date());
        Integer count = this.memberIntegralMapper.insert(memberIntegral);
        return count;
    }

    @Override
    public Integer countMemberIntegral(String memberId) {
        Map<String, Object> data = new HashMap<>();
        data.put("memberId",memberId);
        return  selfmemberIntegralMapper.countMemberIntegral(data);
    }

    @Override
    public List<memberIntegral> findMemberIntegral(String memberId, int currPage, int pageSize) {

        Map<String, Object> data = new HashMap<>();
        data.put("memberId",memberId);
        data.put("currPage", (currPage-1)*pageSize);
        data.put("pageSize",  pageSize);
        return  selfmemberIntegralMapper.findMemberIntegral(data);
    }
}
