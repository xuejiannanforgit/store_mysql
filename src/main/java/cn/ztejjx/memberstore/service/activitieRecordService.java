package cn.ztejjx.memberstore.service;

import cn.ztejjx.memberstore.domain.mysql.activitieRecord;

public interface activitieRecordService {

    int saveactivitieRecord(activitieRecord activitieRecord);
    int validateCount(String openId, String shareopenId, String activitiesId);
    int validateShareCount(String shareopenId, String activitiesId);

}
