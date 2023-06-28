package cn.ztejjx.memberstore.service.impl;

import cn.ztejjx.memberstore.domain.mysql.photoclass;
import cn.ztejjx.memberstore.service.photoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class photoServiceImpl  implements photoService {

    @Autowired
    private cn.ztejjx.memberstore.mapper.mysql.selfphotoMapper selfphotoMapper;

    @Override
    public List<photoclass> findPhoto() {
        return  selfphotoMapper.findAllphoto();
    }


}
