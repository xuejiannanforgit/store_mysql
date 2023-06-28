package cn.ztejjx.memberstore.service.impl;

import cn.ztejjx.memberstore.domain.mysql.memberInfo;
import cn.ztejjx.memberstore.service.memberInfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
public class memberInfoServiceImpl implements memberInfoService {

    @Autowired
    private cn.ztejjx.memberstore.mapper.mysql.memberInfoMapper memberInfoMapper;

    @Autowired
    private cn.ztejjx.memberstore.mapper.mysql.selfmemberInfoMapper selfmemberInfoMapper;



    @Override
    public int selectCountBymemberIdcard(String memberIdcard) {
        QueryWrapper<memberInfo> wrapper = new QueryWrapper<memberInfo>();
        wrapper.eq("enabled_Flag",1);
        wrapper.eq("member_Idcard",memberIdcard);
        int count = this.memberInfoMapper.selectCount(wrapper);
        return count;
    }

    @Override
    public List<memberInfo> findMemberInfoBymemberPhone(String memberPhone) {
        QueryWrapper<memberInfo> wrapper = new QueryWrapper<memberInfo>();
        wrapper.eq("enabled_Flag",1);
        wrapper.eq("member_Phone",memberPhone);
        List<memberInfo> list = this.memberInfoMapper.selectList(wrapper);
        return list;
    }

    @Override
    public List<memberInfo> findMemberInfobymemberId(String memberId) {
        QueryWrapper<memberInfo> wrapper = new QueryWrapper<memberInfo>();
        wrapper.eq("enabled_Flag",1);
        wrapper.eq("member_Id",memberId);
        List<memberInfo> list = this.memberInfoMapper.selectList(wrapper);
        return list;
    }

    @Override
    public int updateMemberIntegral(String memberId, int Integral) {
        Map<String, Object> data = new HashMap<>();
        data.put("Integral",Integral);
        data.put("memberId",memberId);
        return  selfmemberInfoMapper.updateMemberIntegral(data);
    }

    @Override
    public int updateMemberInfo(memberInfo memberInfo) {
        Map<String, Object> data = new HashMap<>();
        data.put("memberId",memberInfo.getMemberId());
        data.put("memberImageurl",memberInfo.getMemberImageurl());
        data.put("wecharNumber",memberInfo.getWecharNumber());
        data.put("email",memberInfo.getEmail());
        return  selfmemberInfoMapper.updateMemberInfo(data);
    }

    @Override
    public int updateMemberInfoVoteNum(String memberId, Integer voteNum) {

        Map<String, Object> data = new HashMap<>();
        data.put("memberId",memberId);
        data.put("voteNum",voteNum);
        return  selfmemberInfoMapper.updateMemberInfoVoteNum(data);


    }



    @Override
    public List<memberInfo> findmemberInfoByVoteNum() {
        Map<String, Object> data = new HashMap<>();
        data.put("currIndex",0);
        data.put("Num",9);
        return selfmemberInfoMapper.findmemberInfoByVoteNum(data);
    }

    @Override
    public List<String> findAllMemberInfo() {
        return selfmemberInfoMapper.findAllMemberInfo();

    }

    @Override
    public int SaveMemberInfo(memberInfo memberInfo) {
        memberInfo.setEnabledFlag(1);
        memberInfo.setCreatedDate(new Date());
        int count = this.memberInfoMapper.insert(memberInfo);
        return count;
    }





}


