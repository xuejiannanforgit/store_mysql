package cn.ztejjx.memberstore.service.impl;

import cn.ztejjx.memberstore.domain.mysql.ResumeInfo;
import cn.ztejjx.memberstore.mapper.mysql.RecruitInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResumeInfoService implements cn.ztejjx.memberstore.service.ResumeInfoService {



    @Autowired
    private cn.ztejjx.memberstore.mapper.mysql.ResumeInfoMapper resumeInfoMapper;

    @Override
    public int saveResumeInfoS(ResumeInfo resumeInfo) {


        return  resumeInfoMapper.insert(resumeInfo);

    }
}
