package cn.ztejjx.memberstore.service;

import cn.ztejjx.memberstore.domain.mysql.accessrecord;

import java.util.List;

public interface accessRecordService {
   int  SaveAccessRecord(accessrecord accessrecord);

   List<accessrecord> findAccessrecord(String memberId, int currIndex, int pageSize);

}
