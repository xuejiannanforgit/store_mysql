package cn.ztejjx.memberstore.service;

import cn.ztejjx.memberstore.domain.mysql.RecruitInfo;
import java.util.List;

public interface RecruitInfoService {

    List<RecruitInfo> findRecruitInfo();
}
