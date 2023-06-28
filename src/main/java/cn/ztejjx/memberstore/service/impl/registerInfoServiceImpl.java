package cn.ztejjx.memberstore.service.impl;

import cn.ztejjx.memberstore.domain.mysql.registerinfo;
import cn.ztejjx.memberstore.service.registerInfoService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;


@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class registerInfoServiceImpl implements registerInfoService {


    @Autowired
    private cn.ztejjx.memberstore.mapper.mysql.registerinfoMapper registerinfoMapper;

    @Override
    public int saveRegisterInfo(registerinfo registerinfo) {
        registerinfo.setRegisterinfoId(UUID.randomUUID().toString().replace("-", ""));
        registerinfo.setEnabledFlag(1);
        registerinfo.setCreatedDate(new Date());
        int count = this.registerinfoMapper.insert(registerinfo);
        return count;
    }

    @Override
    public int findRegisterInfobyphone(String phone, String projectsintroductionId) {
        QueryWrapper<registerinfo>  wrapper = new   QueryWrapper<>();
        wrapper.eq("projectsintroduction_Id",projectsintroductionId);
        wrapper.eq("phone",phone);
        wrapper.eq("enabled_Flag",1);
        List<registerinfo> list   = this.registerinfoMapper.selectList(wrapper);
        return list.size();
    }
}


