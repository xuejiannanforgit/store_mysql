package cn.ztejjx.memberstore.service;

import cn.ztejjx.memberstore.domain.mysql.oilRecord;
import cn.ztejjx.memberstore.utils.ResultUtils;


import java.math.BigDecimal;
import java.util.List;

public interface oilRecordService {

   int saveoilRecord(oilRecord oilRecord);

   List<oilRecord> findOilrecordByemployeeId(String EmployeeId);

   List<oilRecord>  findOilrecordBymakeoutDept(String makeoutDept);

   List<oilRecord>  findOilrecordByDeptAndDate(String makeoutDept,String applymodelDate);


   Double  countOilrecordByIdcard(String idcard,String datatype,String vehiclesType);


   int updateoilRecordByoilrecordId(oilRecord oilRecord);

   int updateActualOilamountByoilrecordId(oilRecord oilRecord);

   int updateoilRecordPhotoByOilrecordId (String oilrecordId,String photo);

   int checkOilrecord(int status, String oilrecordId, String drawer);

   int updatecarImageRecordPhotoByOilrecordId (String oilrecordId,String photo);

   int updateOilRecordCompleteByoilrecordId(String oilrecordId);

   int updatecarMilesByoilrecordId(String oilrecordId,BigDecimal CarMiles);



}
