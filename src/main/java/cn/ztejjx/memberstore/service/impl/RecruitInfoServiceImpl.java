package cn.ztejjx.memberstore.service.impl;

import cn.ztejjx.memberstore.domain.mysql.RecruitInfo;
import cn.ztejjx.memberstore.domain.mysql.oilRecord;
import cn.ztejjx.memberstore.mapper.mysql.ResumeInfoMapper;
import cn.ztejjx.memberstore.service.RecruitInfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecruitInfoServiceImpl implements RecruitInfoService {

    @Autowired
    private cn.ztejjx.memberstore.mapper.mysql.RecruitInfoMapper recruitInfoMapper;
    @Override
    public List<RecruitInfo> findRecruitInfo() {

        QueryWrapper<RecruitInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("enable_flag",1);
        wrapper.orderByDesc("create_date");
        return recruitInfoMapper.selectList(wrapper);
    }
}


