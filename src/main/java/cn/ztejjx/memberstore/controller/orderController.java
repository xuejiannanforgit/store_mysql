package cn.ztejjx.memberstore.controller;

import cn.ztejjx.memberstore.config.Constant;
import cn.ztejjx.memberstore.domain.mysql.customerOrder;
import cn.ztejjx.memberstore.domain.mysql.customerOrderDetail;
import cn.ztejjx.memberstore.domain.mysql.memberInfo;
import cn.ztejjx.memberstore.domain.mysql.memberIntegral;

import cn.ztejjx.memberstore.domain.redis.shoppingCart;
import cn.ztejjx.memberstore.service.customerOrderService;

import cn.ztejjx.memberstore.task.AsyncTask;
import cn.ztejjx.memberstore.utils.EncrypDES;
import cn.ztejjx.memberstore.utils.RedisUtils;
import cn.ztejjx.memberstore.utils.ResultUtils;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/pri/order")
@Transactional
public class orderController {

    @Autowired
    private cn.ztejjx.memberstore.service.customerOrderDetailService customerOrderDetailService;

    @Autowired
    private customerOrderService customerOrderService;



    @Autowired
    private AsyncTask asyncTask;

    @Autowired
    private RedisUtils redisUtil;

    @Autowired
    private EncrypDES encrypDES;







    @RequestMapping("/validateOrder")
    public ResultUtils validateOrder(String ercode, String createby, String phone, String loginkey)
    {
        SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd");
        try {
            List<customerOrderDetail> list =  customerOrderDetailService.findOrderdetailByverificationCode(encrypDES.decrypt(ercode));
            if (list!=null)
            {
                customerOrderDetail customerOrderDetail = list.get(0);
//                if(sdf.format(new Date()).compareTo(sdf.format(customerOrderDetail.getEndStart()))>0)
//                {
//                    return ResultUtils.fail ("核销失败,已过有效期");
//                }
//                else

                    if("已使用".equals(customerOrderDetail.getVerificationStatus()))
                {
                    return ResultUtils.fail ("核销失败,已核销");

                }
                else
                {

                    if( "学车劵".equals(customerOrderDetail.getProductbrands()))
                    {


                        return ResultUtils.success("学车劵提交成功",customerOrderDetail);

//                        miniCouponGetinfo  coup = new miniCouponGetinfo();
//                        coup.setCouponinfoid(UUID.randomUUID().toString().replace("-", ""));
//                        coup.setOpenid(customerOrderDetail.getOpenid());
//                        coup.setCouponstitle("商城学车优惠劵");
//                        coup.setCouponprice(customerOrderDetail.getCouponPrice());//优惠劵优惠价格
//                        coup.setOrderid(UUID.randomUUID().toString().replace("-", ""));//// 订单号(优惠券ID)
//                        coup.setCouponstype("否");
//                        coup.setChecked("未兑换");
//                        coup.setValidStartTime(customerOrderDetail.getStartDate() );
//                        coup.setValidEndTime(customerOrderDetail.getEndStart());
//                        coup.setPrice(customerOrderDetail.getRetailprice()); //兑换积分
//                        coup.setCouponsdept(customerOrderDetail.getUseDept());// 适用分校
//                        coup.setCouponsclass(customerOrderDetail.getUseStdclass()); // 适用班型
//                        coup.setEnabledFlag(new BigDecimal(1));
//                        coup.setCreatedDate(new Date());
//                        coup.setApplymodels(customerOrderDetail.getUseApplymodel());
//                        coup.setCouponsid(customerOrderDetail.getProductId());  //商品ID
//                        coup.setEmployeeId(customerOrderDetail.getCustomerId());
//                        coup.setIdCard(customerOrderDetail.getCustomerPhone());  //存电话
//                        coup.setStudentName(customerOrderDetail.getCustomerName());
//                        coup.setCouponsName(customerOrderDetail.getProductname());
//                        coup.setCouponsCoverimage(customerOrderDetail.getProductcoverimg());
//                        coup.setConfirmEmployeeid(customerOrderDetail.getOrderConfirmEmployeeid());
//                        coup.setConfirmEmployeename(customerOrderDetail.getOrderConfirmEmployeename());
//                        coup.setConfirmEmployeephone(customerOrderDetail.getOrderConfirmEmployeephone());
//                        miniCouponGetinfoService.saveminiCouponGetinfo(coup);

                    }
                    else if("礼品".equals(customerOrderDetail.getProductbrands()))
                    {

                    }
                    //更新核销信息
                    customerOrderDetailService.VerificationCustomerOrderDetail(customerOrderDetail.getOrderDetailId(),createby,phone,loginkey);

                    return ResultUtils.success("查询成功");
                }
            }
            else
            {
                return ResultUtils.fail ("查询为空");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

           return ResultUtils.fail ("执行有误");

    }





    @RequestMapping("/findOrderdetailById")
    public ResultUtils findOrderdetailById(String orderId)
    {
        List<customerOrderDetail> list =  customerOrderDetailService.findOrderdetailById(orderId);
        return ResultUtils.success("查询成功",list);
    }

    @RequestMapping("/saveOrder")
    public ResultUtils saveOrder(String shoppingCartArr, String summoney, String integral, String member, String openid)
    {
        JSONObject jsonObject = JSONObject.parseObject(member);
        memberInfo memberInfo =   JSONObject.toJavaObject(jsonObject,memberInfo.class);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        customerOrder customerOrder=new customerOrder();
        String orderId = UUID.randomUUID().toString().replace("-", "");
        customerOrder.setOrderId(orderId);
        customerOrder.setEnabledFlag(1);
        customerOrder.setCreatedBy(memberInfo.getMemberName());
        customerOrder.setCreatedDate(new Date());
        customerOrder.setOpenid(openid);
        customerOrder.setCustomerId(memberInfo.getMemberId());
        customerOrder.setCustomerName(memberInfo.getMemberName());
        customerOrder.setCustomerPhone(memberInfo.getMemberPhone());
        customerOrder.setCustomerAddress(memberInfo.getDeptAddress());
        customerOrder.setCustomerDept(memberInfo.getMemberDept());
        customerOrder.setOrderNum(getOrderNum(memberInfo.getMemberPhone()));
        customerOrder.setPayTime(new Date());
        customerOrder.setPayType("积分兑换");
        customerOrder.setOrderStatus("已下单");
        customerOrder.setOrderType("积分订单");
        customerOrder.setOrderTitle(sdf.format(new Date())+"-"+memberInfo.getMemberName());

        BigDecimal  summoneyvalue =  new BigDecimal(summoney);
        BigDecimal   integralvalue =  new BigDecimal(integral);
        customerOrder.setIntegralAmount(summoneyvalue); //消耗积分合计
        customerOrder.setCustomerIntegral(integralvalue); //会员账户抵扣前积分
        customerOrder.setCustomerIntegralbalance(integralvalue.subtract(summoneyvalue));
        customerOrderService.saveCustomerOrder(customerOrder);

        JSONArray JsonArray = JSONArray.parseArray(shoppingCartArr);
        List<String> productlist = new ArrayList<>();
        for(int i = 0; i< JsonArray.size(); i++) {
            //保存订单明细
            shoppingCart shoppingCart = (shoppingCart) JSONObject.toJavaObject(JsonArray.getJSONObject(i), shoppingCart.class);
            customerOrderDetail customerOrderDetail= new customerOrderDetail();
            customerOrderDetail.setOrderDetailId(UUID.randomUUID().toString().replace("-", ""));
            customerOrderDetail.setOrderId(orderId);
            customerOrderDetail.setCustomerId(memberInfo.getMemberId());
            customerOrderDetail.setCustomerName(memberInfo.getMemberName());
            customerOrderDetail.setCustomerPhone(memberInfo.getMemberPhone());
            customerOrderDetail.setOpenid(openid);
            customerOrderDetail.setNum(shoppingCart.getNum());
            customerOrderDetail.setRetailprice(shoppingCart.getRetailPrice());
            customerOrderDetail.setSumretailprice(shoppingCart.getRetailPrice().multiply(shoppingCart.getNum()));
            customerOrderDetail.setSupplierid(shoppingCart.getSupplierId());
            customerOrderDetail.setSuppliername(shoppingCart.getSupplierName());
            customerOrderDetail.setProductbrandsid(shoppingCart.getProductBrandsid());
            customerOrderDetail.setProductclassifyid(shoppingCart.getProductClassifyid());
            customerOrderDetail.setProductspecification(shoppingCart.getProductSpecification());
            customerOrderDetail.setProductbrands(shoppingCart.getProductBrands());
            customerOrderDetail.setProductId(shoppingCart.getProductId());
            customerOrderDetail.setProductunit(shoppingCart.getProductUnit());
            customerOrderDetail.setProductname(shoppingCart.getProductName());
            customerOrderDetail.setProductcoverimg(shoppingCart.getProductCoverimg());
            customerOrderDetail.setProductbarcode(shoppingCart.getProductBarcode());
            customerOrderDetail.setEnabledFlag(1);
            customerOrderDetail.setCreatedBy(memberInfo.getMemberName());
            customerOrderDetail.setCreatedDate(new Date());
            customerOrderDetail.setCustomerDept(memberInfo.getMemberDept());
            customerOrderDetail.setBelongDept( shoppingCart.getBelongDept());
            customerOrderDetail.setProductType(shoppingCart.getProductType());
            customerOrderDetail.setCouponPrice(shoppingCart.getCouponPrice().multiply(shoppingCart.getNum()));
            customerOrderDetail.setUseDept(shoppingCart.getUseDept());
            customerOrderDetail.setUseApplymodel(shoppingCart.getUseApplymodel());
            customerOrderDetail.setUseStdclass(shoppingCart.getUseStdclass());
            customerOrderDetail.setStartDate(shoppingCart.getStartDate());
            customerOrderDetail.setEndStart(shoppingCart.getEndStart());

            String verificationCode =  UUID.randomUUID().toString().replace("-", "");
            customerOrderDetail.setVerificationCode(verificationCode);
            customerOrderDetail.setVerificationStatus("未使用");
            // 嵌入二维码的图片路径
            String logoPath =  Constant.logoPath;
            // 生成的二维码的路径及名称

            String date =  new SimpleDateFormat("yyyyMMdd").format(new Date());
            String httpdestPath = Constant.httpdestPath+"/"+date+"/"+verificationCode+".jpg";
            String destPath = Constant.destPath+"/"+date+"/"+verificationCode+".jpg";

            customerOrderDetail.setVerificationCodeUrl(httpdestPath);
            //保存订单明细
            customerOrderDetailService.saveCustomerOrderDetail(customerOrderDetail);
            //移除购物车缓存
            String key  = "shoppingCart-"+"-"+shoppingCart.getOpenid();
            String item = shoppingCart.getProductId();
            redisUtil.hdel(key,item);
            //生成订单校验二维码
            asyncTask.createErcode(verificationCode, logoPath,destPath);
        }

        memberIntegral memberIntegral=new memberIntegral();
        memberIntegral.setIntegralId(UUID.randomUUID().toString().replace("-", ""));
        memberIntegral.setIntegralType("积分抵扣");
        memberIntegral.setIntegralNum(new BigDecimal(-1).multiply(summoneyvalue));  //积分抵扣数量
        memberIntegral.setMemberId(memberInfo.getMemberId());
        memberIntegral.setMemberName(memberInfo.getMemberName());
        memberIntegral.setMemberPhone(memberInfo.getMemberPhone());
        memberIntegral.setAddintegralReason("消费");
        memberIntegral.setApplicationItems("积分订单");
        memberIntegral.setOrderId(orderId);
        memberIntegral.setEnabledFlag(1);
        memberIntegral.setCreatedDate(new Date());
        //保存积分消费记录，更新积分
        asyncTask.saveMemberIntegral(memberIntegral);
        return ResultUtils.success("下单成功");
    }



    @RequestMapping("/findOrderByMemberId")
    public ResultUtils findOrderByMemberId(String memberId)
    {
        List<customerOrder> list = customerOrderService.findOrderByMemberId(memberId);
        return  ResultUtils.success("查询成功",list);
    }

    @RequestMapping("/findPageOrderByMemberId")
    public ResultUtils findPageOrderByMemberId(String memberId, int currPage, int pageSize)
    {
        List<customerOrder> list = customerOrderService.findPageOrderByMemberId(memberId,currPage,pageSize);
        return  ResultUtils.success("查询成功",list);
    }

    private  String getOrderNum(String memberPhone)
    {
         SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
         String date = sdf.format(new Date()); // 格式化日期 date: 20200724
         return  memberPhone+"_"+date;
     }
}

