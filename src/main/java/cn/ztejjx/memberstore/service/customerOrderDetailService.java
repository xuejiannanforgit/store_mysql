package cn.ztejjx.memberstore.service;

import cn.ztejjx.memberstore.domain.mysql.customerOrderDetail;

import java.util.List;

public interface customerOrderDetailService {
    int saveCustomerOrderDetail(customerOrderDetail customerOrderDetail);
    List<customerOrderDetail> findOrderdetailById(String orderId);
    List<customerOrderDetail> findOrderdetailByverificationCode(String verificationCode);
    int VerificationCustomerOrderDetail(String orderDetailId, String createby, String phone, String loginkey);

}
