package cn.ztejjx.memberstore.mapper.mysql;

import cn.ztejjx.memberstore.domain.mysql.memberInfo;

import java.util.List;
import java.util.Map;

public interface selfmemberInfoMapper {

  int  updateVisitCount(String memberId);

  int  updateShareCount(String memberId);

  int updateMemberIntegral(Map<String, Object> data);

  int updateMemberInfo(Map<String, Object> data);

  int updateMemberInfoVoteNum(Map<String, Object> data);

  List<memberInfo> findmemberInfoByVoteNum(Map<String, Object> data);

  List<String> findAllMemberInfo();
}
