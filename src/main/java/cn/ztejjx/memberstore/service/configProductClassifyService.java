package cn.ztejjx.memberstore.service;

import cn.ztejjx.memberstore.domain.redis.SelfConfigProductClassify;

import java.util.List;

public interface configProductClassifyService {

    List<SelfConfigProductClassify> findProductList();

}
