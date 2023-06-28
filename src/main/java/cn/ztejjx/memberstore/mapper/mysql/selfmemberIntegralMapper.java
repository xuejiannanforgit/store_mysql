package cn.ztejjx.memberstore.mapper.mysql;

import cn.ztejjx.memberstore.domain.mysql.memberIntegral;

import java.util.List;
import java.util.Map;

public interface selfmemberIntegralMapper {
    Integer countMemberIntegral(Map<String, Object> data);
    List<memberIntegral> findMemberIntegral(Map<String, Object> data);
    List<String> findAllMemberId();

}
