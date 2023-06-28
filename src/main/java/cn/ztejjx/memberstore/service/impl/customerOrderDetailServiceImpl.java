package cn.ztejjx.memberstore.service.impl;

import cn.ztejjx.memberstore.domain.mysql.customerOrderDetail;
import cn.ztejjx.memberstore.service.customerOrderDetailService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class customerOrderDetailServiceImpl implements customerOrderDetailService {

    @Autowired
    private cn.ztejjx.memberstore.mapper.mysql.customerOrderDetailMapper customerOrderDetailMapper;


    @Autowired
    private cn.ztejjx.memberstore.mapper.mysql.selfcustomerOrderDetailMapper selfcustomerOrderDetailMapper;


    @Override
    public int saveCustomerOrderDetail(customerOrderDetail customerOrderDetail) {
      int count =  customerOrderDetailMapper.insert(customerOrderDetail);
      return count;
    }

    @Override
    public List<customerOrderDetail> findOrderdetailById(String orderId) {
        QueryWrapper<customerOrderDetail>  wrapper = new QueryWrapper<>();
        wrapper.eq("order_id",orderId);
        wrapper.eq("enabled_flag",1);
        return this.customerOrderDetailMapper.selectList(wrapper);
    }

    @Override
    public List<customerOrderDetail> findOrderdetailByverificationCode(String verificationCode) {
        QueryWrapper<customerOrderDetail>  wrapper = new QueryWrapper<>();
        wrapper.eq("verification_code",verificationCode);
        wrapper.eq("enabled_flag",1);
        return this.customerOrderDetailMapper.selectList(wrapper);
    }

    @Override
    public int VerificationCustomerOrderDetail(String orderDetailId, String createby, String phone,String loginkey) {

        Map<String, Object> data = new HashMap<>();
        data.put("orderDetailId",  orderDetailId);
        data.put("createby",  createby);
        data.put("phone",  phone);
        data.put("loginkey",  loginkey);

        return selfcustomerOrderDetailMapper.VerificationCustomerOrderDetail(data);

    }
}