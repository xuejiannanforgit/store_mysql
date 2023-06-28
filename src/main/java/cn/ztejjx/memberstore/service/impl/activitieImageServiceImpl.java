package cn.ztejjx.memberstore.service.impl;

import cn.ztejjx.memberstore.domain.mysql.activitieImage;
import cn.ztejjx.memberstore.mapper.mysql.activitieImageMapper;
import cn.ztejjx.memberstore.service.activitieImageService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service

@Transactional(propagation = Propagation.REQUIRES_NEW)
public class activitieImageServiceImpl implements activitieImageService {
    @Autowired
    private activitieImageMapper activitieImageMapper;


    @Override
    public List<activitieImage> findactivitieImageByactivitiesId(String activitiesId) {
         QueryWrapper<activitieImage> wrapper = new QueryWrapper<activitieImage>();
        wrapper.eq("activities_Id",activitiesId);
        return this.activitieImageMapper.selectList(wrapper);

//        QueryWrapper<activitieImage> wrapper = new QueryWrapper<activitieImage>();
////        wrapper.eq("activities_Id",activitiesId);
////        wrapper.eq("enabled_flag",1);
////        wrapper.orderByAsc("created_date");
//
//        return this.activitieImageMapper.selectList(wrapper);

    }
}
