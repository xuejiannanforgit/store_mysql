package cn.ztejjx.memberstore.mapper.mysql;

import cn.ztejjx.memberstore.domain.mysql.sharerecord;

import java.util.List;
import java.util.Map;

public interface selfsharerecordMapper   {

    List<sharerecord> findSharerecord(Map<String, Object> data);

}
