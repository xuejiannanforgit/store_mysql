package cn.ztejjx.memberstore.service;

import cn.ztejjx.memberstore.domain.mysql.customerOrder;

import java.util.List;

public interface customerOrderService {

    int saveCustomerOrder(customerOrder customerOrder);
    List<customerOrder> findOrderByMemberId(String memberId);
    List<customerOrder> findPageOrderByMemberId(String memberId, int currPage, int pageSize);



}
