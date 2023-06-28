package cn.ztejjx.memberstore.mapper.mysql;

import cn.ztejjx.memberstore.domain.mysql.oilRecord;

import java.util.List;
import java.util.Map;

public interface selfOilRecordMapper {

    int updateoilRecordByoilrecordId(Map<String, Object> data);

    int   updateActualOilamountByoilrecordId(Map<String, Object> data);

    int updateOilRecordCompleteByoilrecordId(Map<String, Object> data);

    int updateoilRecordPhotoByOilrecordId(Map<String, Object> data);

    int updatecarImageRecordPhotoByOilrecordId(Map<String, Object> data);

    int checkOilrecord(Map<String, Object> data);

    int updatecarMilesByoilrecordId(Map<String, Object> data);

    List<oilRecord> findOilrecordByDeptAndDate(Map<String, Object> data);

    Double countOilrecordByIdcard(Map<String, Object> data);

    Double countOilrecordByIdcard2(Map<String, Object> data);

}
