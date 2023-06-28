package cn.ztejjx.memberstore.controller;


import cn.ztejjx.memberstore.domain.mysql.oilCard;
import cn.ztejjx.memberstore.domain.mysql.oilRecord;
import cn.ztejjx.memberstore.domain.mysql.oilPrice;

import cn.ztejjx.memberstore.utils.RedisUtils;
import cn.ztejjx.memberstore.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;


@RestController
@RequestMapping("/api/v1/pri/oil")
@Transactional
public class oilController {

    @Autowired
    private cn.ztejjx.memberstore.service.oilCardService  oilCardService;

    @Autowired
    private cn.ztejjx.memberstore.service.oilPriceService oilPriceService;

    @Autowired
    private cn.ztejjx.memberstore.service.oilRecordService oilRecordService;

    @Autowired
    private RedisUtils redisUtil;


    @RequestMapping("/findOilrecordByDeptAndDate")
    public ResultUtils findOilrecordByDeptAndDate(String  makeoutDept,String applymodelDate) {
        List<oilRecord> list =  oilRecordService.findOilrecordByDeptAndDate(makeoutDept,applymodelDate);
        return ResultUtils.success("查询成功", list);
    }

    @RequestMapping("/countOilrecordByIdcard")
    public ResultUtils countOilrecordByIdcard(String  idcard,String datatype,String vehiclesType ) {
        Double count =  oilRecordService.countOilrecordByIdcard(idcard,datatype,vehiclesType);
        return ResultUtils.success("查询成功", count);
    }



    @RequestMapping("/updateActualOilamountByoilrecordId")
    public ResultUtils updateActualOilamountByoilrecordId(oilRecord oilRecord) {


         System.out.println(oilRecord.getActualOilamount());
         int count =  oilRecordService.updateActualOilamountByoilrecordId(oilRecord);
         oilCardService.updateRemain(oilRecord.getActualOilamount(),oilRecord.getOilcardNum());
         oilRecordService.updateOilRecordCompleteByoilrecordId(oilRecord.getOilrecordId());
         return ResultUtils.success("提交成功", null);
    }



    @RequestMapping("/checkOilrecord")
    public ResultUtils checkOilrecord(int status,String oilrecordId,String drawer) {
        int count = oilRecordService.checkOilrecord(status,oilrecordId,drawer);
        return ResultUtils.success("更新成功", count);
    }


    @RequestMapping("/findOilCardbyDept")
    public ResultUtils findOilCardbyDept(String dept) {
        List<oilCard> oilCardlist =  oilCardService.findOilCardbyDept(dept);
        return ResultUtils.success("查询成功", oilCardlist);
    }



    @RequestMapping("/updatecarMilesByoilrecordId")
    public ResultUtils updatecarMilesByoilrecordId(String oilrecordId, BigDecimal CarMiles) {


        int count =  oilRecordService.updatecarMilesByoilrecordId(oilrecordId, CarMiles);

        return ResultUtils.success("提交成功", count);
    }

    @RequestMapping("/updateoilRecordByoilrecordId")
    public ResultUtils updateoilRecordByoilrecordId(oilRecord oilRecord) {
        int count =  oilRecordService.updateoilRecordByoilrecordId(oilRecord);
        return ResultUtils.success("提交成功", count);
    }


    @RequestMapping("/saveoilRecord")
    public ResultUtils saveoilRecord(oilRecord oilRecord) {


        oilRecord.setStatus(0);
        oilRecordService.saveoilRecord(oilRecord);
        return ResultUtils.success("保存成功", null);
    }

    @RequestMapping("/findOilrecordByemployeeId")
    public ResultUtils findoilRecordByEmployeeId(String employeeId) {
        List<oilRecord> list =  oilRecordService.findOilrecordByemployeeId(employeeId);
        return ResultUtils.success("查询成功", list);
    }

    @RequestMapping("/findOilrecordBymakeoutDept")
    public ResultUtils findOilrecordBymakeoutDept(String  makeoutDept) {
        List<oilRecord> list =  oilRecordService.findOilrecordBymakeoutDept(makeoutDept);
        return ResultUtils.success("查询成功", list);
    }

    @RequestMapping("/findOilPrice")
    public ResultUtils findOilPrice(String area,String oilClass,String oilType) {
        BigDecimal price = new BigDecimal(0);
       if(redisUtil.hget(area,oilClass+"-"+oilType)==null)
       {
           List<oilPrice> list = oilPriceService.findOilPrice(area,oilClass,oilType);

           if(list.size()!=0)
           {
               price = list.get(0).getOilprice();
               redisUtil.hset(area,oilClass+"-"+oilType,price);
           }
       }
       else
       {
           price =(BigDecimal)redisUtil.hget(area,oilClass+"-"+oilType);
       }
       return ResultUtils.success("查询成功", price);
    }
}
