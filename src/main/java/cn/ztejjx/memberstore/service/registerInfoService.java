package cn.ztejjx.memberstore.service;

import cn.ztejjx.memberstore.domain.mysql.registerinfo;

public interface registerInfoService {

   int saveRegisterInfo(registerinfo registerinfo);

   int findRegisterInfobyphone(String phone, String projectsintroductionId);
}
