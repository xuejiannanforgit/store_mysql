package cn.ztejjx.memberstore.mapper.mysql;

import cn.ztejjx.memberstore.domain.mysql.luckydraw;

import java.util.Map;

public interface selfluckydrawMapper {

    int  updateluckydrawFlag(Map<String, Object> data);

    int findluckydrawcountbyprizesId(Map<String, Object> data);

    luckydraw findluckydrawbyprizesId(Map<String, Object> data);
}
