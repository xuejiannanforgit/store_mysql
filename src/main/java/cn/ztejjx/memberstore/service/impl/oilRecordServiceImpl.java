package cn.ztejjx.memberstore.service.impl;

import cn.ztejjx.memberstore.domain.mysql.oilRecord;
import cn.ztejjx.memberstore.service.oilRecordService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class oilRecordServiceImpl implements oilRecordService {

    @Autowired
    private  cn.ztejjx.memberstore.mapper.mysql.oilRecordMapper  oilRecordMapper;

    @Autowired
    private cn.ztejjx.memberstore.mapper.mysql.selfOilRecordMapper  selfoilRecordMapper;





    @Override
    public int saveoilRecord(oilRecord oilRecord) {
        oilRecord.setOilrecordId(UUID.randomUUID().toString().replace("-", ""));
        oilRecord.setCreatedDate(new Date());
        oilRecord.setEnabledFlag(1);
        oilRecord.setPhoto("../../image/upload.png");
        oilRecord.setImageCar("../../image/upload.png");
        return  this.oilRecordMapper.insert(oilRecord);
    }

    @Override
    public List<oilRecord> findOilrecordByemployeeId(String employeeId) {
        QueryWrapper<oilRecord> wrapper = new QueryWrapper<oilRecord>();
        wrapper.eq("employee_Id",employeeId);
        wrapper.orderByDesc("created_date");
        return this.oilRecordMapper.selectList(wrapper);
    }

    @Override
    public List<oilRecord> findOilrecordBymakeoutDept(String makeoutDept) {

        QueryWrapper<oilRecord> wrapper = new QueryWrapper<oilRecord>();
        wrapper.eq("makeout_Dept",makeoutDept);
        wrapper.eq("status",0);
        wrapper.orderByAsc("created_date");


        return this.oilRecordMapper.selectList(wrapper);

    }

    @Override
    public List<oilRecord> findOilrecordByDeptAndDate(String makeoutDept, String applymodelDate) {


        Map<String, Object> data = new HashMap<>();
        data.put("makeoutDept", makeoutDept);
        data.put("applymodelDate", applymodelDate);


        System.out.println("applymodelDate="+applymodelDate);

        return  selfoilRecordMapper.findOilrecordByDeptAndDate(data);

    }

    @Override
    public Double countOilrecordByIdcard(String idcard,String datatype,String vehiclesType) {


        Calendar cal = Calendar.getInstance();

        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH)+1;
        int day = cal.get(Calendar.DATE);

        String startDate =null;
        String endDate = null;



        Double count = 0.0;
        if("month".equals(datatype))
        {
            startDate = year+"-"+month+"-"+1;
            endDate = year+"-"+month+"-"+day;
            Map<String, Object> data = new HashMap<>();
            data.put("idcard", idcard);
            data.put("startDate", startDate);
            data.put("endDate", endDate);
            data.put("vehiclesType", vehiclesType);

            count = selfoilRecordMapper.countOilrecordByIdcard(data);
        }
         else if("year".equals(datatype))
        {

            Map<String, Object> data = new HashMap<>();
            data.put("idcard", idcard);
            data.put("startDate", year);
            data.put("vehiclesType", vehiclesType);
            count = selfoilRecordMapper.countOilrecordByIdcard2(data);
        }




        System.out.println(count);
        return count;
    }


    @Override
    public int updateOilRecordCompleteByoilrecordId(String  oilrecordId) {

        Map<String, Object> data = new HashMap<>();
        data.put("oilrecordId", oilrecordId);
        data.put("completeDate", new Date());

        return  selfoilRecordMapper.updateOilRecordCompleteByoilrecordId(data);
    }

    @Override
    public int updatecarMilesByoilrecordId(String oilrecordId, BigDecimal CarMiles) {
        Map<String, Object> data = new HashMap<>();
        data.put("oilrecordId", oilrecordId);
        data.put("CarMiles", CarMiles);

        return  selfoilRecordMapper.updatecarMilesByoilrecordId(data);
     }

    @Override
    public int updateoilRecordByoilrecordId(oilRecord oilRecord) {

        Map<String, Object> data = new HashMap<>();
        data.put("oilrecordId", oilRecord.getOilrecordId());
        data.put("actualOilNum",  oilRecord.getActualOilnum()); //实用油料数量（L）
        data.put("restOilnum",  oilRecord.getApplicationOilnum().subtract(oilRecord.getActualOilnum()));//剩余油料数量
        return  selfoilRecordMapper.updateoilRecordByoilrecordId(data);
    }

    @Override
    public int updateActualOilamountByoilrecordId(oilRecord oilRecord) {

        Map<String, Object> data = new HashMap<>();
        data.put("oilrecordId", oilRecord.getOilrecordId());
        data.put("actualOilamount", oilRecord.getActualOilamount()  );//实际加油金额
        data.put("oilprice",  oilRecord.getActualOilamount().divide(oilRecord.getActualOilnum(),2,BigDecimal.ROUND_HALF_UP ) );//油价
        return  selfoilRecordMapper.updateActualOilamountByoilrecordId(data);

    }

    @Override
    public int updateoilRecordPhotoByOilrecordId(String oilrecordId, String photo) {
        Map<String, Object> data = new HashMap<>();
        data.put("oilrecordId",oilrecordId);
        data.put("photo",photo);
        return  selfoilRecordMapper.updateoilRecordPhotoByOilrecordId(data);

    }

    @Override
    public int checkOilrecord(int status, String oilrecordId, String drawer) {
        Map<String, Object> data = new HashMap<>();
        data.put("status",status);
        data.put("oilrecordId",oilrecordId);
        data.put("drawer",drawer);
        data.put("drawerDate",new Date());
        return  selfoilRecordMapper.checkOilrecord(data);
    }

    @Override
    public int updatecarImageRecordPhotoByOilrecordId(String oilrecordId, String photo) {
        Map<String, Object> data = new HashMap<>();
        data.put("oilrecordId",oilrecordId);
        data.put("photo",photo);
        return  selfoilRecordMapper.updatecarImageRecordPhotoByOilrecordId(data);
    }

}
