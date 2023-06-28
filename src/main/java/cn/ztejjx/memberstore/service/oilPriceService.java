package cn.ztejjx.memberstore.service;

import cn.ztejjx.memberstore.domain.mysql.oilPrice;

import java.util.List;

public interface oilPriceService {

    List<oilPrice> findOilPrice(String area,String oilClass,String oilType);


}
