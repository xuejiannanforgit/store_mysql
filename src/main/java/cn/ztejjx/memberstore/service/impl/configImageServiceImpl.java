package cn.ztejjx.memberstore.service.impl;

import cn.ztejjx.memberstore.domain.mysql.configImage;
import cn.ztejjx.memberstore.service.configImageService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class configImageServiceImpl implements configImageService {

    @Autowired
    private cn.ztejjx.memberstore.mapper.mysql.configImageMapper configImageMapper;
    @Override
    public List<configImage> findConfigImage() {
        QueryWrapper<configImage> wrapper = new QueryWrapper<configImage>();
        wrapper.eq("enabled_flag",1);
        wrapper.orderByAsc("sort_Order");
        List<configImage> list = this.configImageMapper.selectList(wrapper);
        return list;
    }

    @Override
    public List<configImage> findadvConfigImage() {
        QueryWrapper<configImage> wrapper = new QueryWrapper<configImage>();
        wrapper.eq("enabled_flag",1);
        wrapper.eq("image_Type",1);
        List<configImage> list = this.configImageMapper.selectList(wrapper);
        return list;
    }
}



