package cn.ztejjx.memberstore.service;

import cn.ztejjx.memberstore.domain.PageResult;
import cn.ztejjx.memberstore.domain.mysql.PersonForCar;

public interface personforCarService {

     PageResult findPersonForCar(Integer page, Integer pageSize);

     String  savePersonForCar(PersonForCar personForCar);
}
