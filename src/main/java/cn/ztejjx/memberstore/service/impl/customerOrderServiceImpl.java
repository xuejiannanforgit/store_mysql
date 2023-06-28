package cn.ztejjx.memberstore.service.impl;

import cn.ztejjx.memberstore.domain.mysql.customerOrder;
import cn.ztejjx.memberstore.service.customerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class customerOrderServiceImpl implements customerOrderService {

    @Autowired
    private cn.ztejjx.memberstore.mapper.mysql.customerOrderMapper customerOrderMapper;

    @Autowired
    private cn.ztejjx.memberstore.mapper.mysql.selfcustomerOrderMapper selfcustomerOrderMapper;


    @Override
    public int saveCustomerOrder(customerOrder customerOrder) {

      int count =  customerOrderMapper.insert(customerOrder);
      return count;
    }

    @Override
    public List<customerOrder> findOrderByMemberId(String memberId) {
        Map<String, Object> data = new HashMap<>();
        data.put("memberId",  memberId);
        return   selfcustomerOrderMapper.findOrderByMemberId(data);
    }

    @Override
    public List<customerOrder> findPageOrderByMemberId(String memberId,int currPage, int pageSize) {
        Map<String, Object> data = new HashMap<>();
        data.put("memberId",  memberId);
        data.put("currPage", (currPage-1)*pageSize);
        data.put("pageSize",  pageSize);
        return   selfcustomerOrderMapper.findPageOrderByMemberId(data);
    }



}
