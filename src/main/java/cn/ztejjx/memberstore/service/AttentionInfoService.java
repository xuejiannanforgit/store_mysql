package cn.ztejjx.memberstore.service;

import cn.ztejjx.memberstore.domain.mysql.AttentionInfo;


import java.util.List;


public interface AttentionInfoService {

      int saveAttentionInfo(AttentionInfo attentionInfo);

      List<AttentionInfo> findAttentionInfoByMemberPhone(String MemberPhone);

}
