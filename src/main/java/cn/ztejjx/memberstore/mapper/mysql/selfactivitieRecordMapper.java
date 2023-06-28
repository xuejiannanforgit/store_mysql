package cn.ztejjx.memberstore.mapper.mysql;

import java.util.Map;

public interface selfactivitieRecordMapper {
    int validateCount(Map<String, Object> data);
    int validateShareCount(Map<String, Object> data);

}
