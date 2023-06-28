package cn.ztejjx.memberstore.mapper.mysql;

import cn.ztejjx.memberstore.domain.mysql.accessrecord;

import java.util.List;
import java.util.Map;

public interface selfaccessRecordMapper {

    List<accessrecord> findAccessrecord(Map<String, Object> data);
}
