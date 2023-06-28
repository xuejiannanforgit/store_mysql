package cn.ztejjx.memberstore.service;

import cn.ztejjx.memberstore.domain.mysql.memberInfo;

import java.util.List;

public interface memberInfoService {
   int  SaveMemberInfo(memberInfo memberInfo);
   int  selectCountBymemberIdcard(String memberIdcard);
   List<memberInfo> findMemberInfoBymemberPhone(String memberPhone);
   List<memberInfo> findMemberInfobymemberId(String memberId);
   int  updateMemberIntegral(String memberId, int Integral);
   int updateMemberInfo(memberInfo memberInfo);
   int updateMemberInfoVoteNum(String memberId, Integer voteNum);
   List<memberInfo>  findmemberInfoByVoteNum();
   List<String> findAllMemberInfo();

}
