package cn.ztejjx.memberstore.mapper.mysql;

import cn.ztejjx.memberstore.domain.mysql.share;

import java.util.List;
import java.util.Map;

public interface selfshareMapper {

    List<share> findShareInfo(Map<String, Object> data);
}
