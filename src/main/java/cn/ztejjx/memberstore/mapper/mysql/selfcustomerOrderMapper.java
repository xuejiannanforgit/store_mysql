package cn.ztejjx.memberstore.mapper.mysql;

import cn.ztejjx.memberstore.domain.mysql.customerOrder;

import java.util.List;
import java.util.Map;

public interface selfcustomerOrderMapper {

    List<customerOrder> findOrderByMemberId(Map<String, Object> data);

    List<customerOrder> findPageOrderByMemberId(Map<String, Object> data);
}
