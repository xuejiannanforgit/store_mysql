package cn.ztejjx.memberstore.service.impl;
import cn.ztejjx.memberstore.domain.PageResult;
import cn.ztejjx.memberstore.domain.mysql.PersonForCar;

import cn.ztejjx.memberstore.service.personforCarService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.github.pagehelper.PageHelper;


@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class personforCarServiceImpl implements personforCarService{


    @Autowired
    private  cn.ztejjx.memberstore.mapper.mysql.PersonForCarMapper  personForCarMapper;


    public String savePersonForCar(PersonForCar personForCar) {
        personForCar.setPersonForCarId(UUID.randomUUID().toString().replace("-", ""));
        personForCar.setCreatedDate(new Date());
        personForCar.setEnabledFlag(1);
        personForCar.setNum(0);
        personForCar.setCartype(personForCar.getCartype());
        personForCarMapper.insert(personForCar);
        return personForCar.getPersonForCarId();
    }

    @Override
    public PageResult findPersonForCar(Integer page, Integer pageSize) {

        PageHelper.startPage(page,pageSize);
        QueryWrapper<PersonForCar> wrapper = new QueryWrapper<PersonForCar>();
        wrapper.eq("enabled_flag",1);
        wrapper.orderByDesc("created_date");

        List<PersonForCar> infos =    personForCarMapper.selectList(wrapper);

        if(CollectionUtils.isEmpty(infos))
        {
            return null;
        }
        //3.1 封装PageInfo对象
         PageInfo<PersonForCar> listPageInfo = new PageInfo<PersonForCar>(infos);
        //3.2 将PageInfo转PageResult
        PageResult<PersonForCar> pageResult = new PageResult<>(listPageInfo);
        return pageResult;

    }
}



//        System.out.println(listPageInfo.getPageNum());
//        System.out.println(listPageInfo.getList());
//        System.out.println(listPageInfo.getPages());
//        System.out.println(listPageInfo.getPageNum());
