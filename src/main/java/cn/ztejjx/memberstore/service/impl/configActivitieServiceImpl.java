package cn.ztejjx.memberstore.service.impl;

import cn.ztejjx.memberstore.domain.mysql.configActivitie;
import cn.ztejjx.memberstore.service.configActivitieService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class configActivitieServiceImpl implements configActivitieService {

    @Autowired
    private cn.ztejjx.memberstore.mapper.mysql.configActivitieMapper configActivitieMapper;

    @Autowired
    private cn.ztejjx.memberstore.mapper.mysql.selfconfigActivitieMapper  selfconfigActivitieMapper;

    @Override
    public List<configActivitie> findConfigActivitieList() {
        QueryWrapper<configActivitie> wrapper = new QueryWrapper<configActivitie>();
        wrapper.eq("enabled_flag",1);
        wrapper.eq("useflag","是");
        wrapper.orderByAsc("created_date");
        return this.configActivitieMapper.selectList(wrapper);
    }

    @Override
    public int addzan(String ActivitiesId) {
        Map<String, Object> data = new HashMap<>();
        data.put("ActivitiesId",  ActivitiesId);
        return  selfconfigActivitieMapper.addzan(data);

    }

    @Override
    public configActivitie findConfigActivitieListbyId(String activitiesId) {

        QueryWrapper<configActivitie> wrapper = new QueryWrapper<configActivitie>();
        wrapper.eq("enabled_flag",1);
        wrapper.eq("activities_Id",activitiesId);
        List<configActivitie> list =  this.configActivitieMapper.selectList(wrapper);
        return  list.get(0);
    }
}
