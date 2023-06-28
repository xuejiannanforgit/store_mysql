package cn.ztejjx.memberstore.mapper.mysql;


import cn.ztejjx.memberstore.domain.redis.SelfConfigProductClassify;

import java.util.List;

public interface SelfConfigProductClassifyMapper {
    List<SelfConfigProductClassify> findProductList();
}
