package cn.ztejjx.memberstore.service;

import cn.ztejjx.memberstore.domain.mysql.memberIntegral;

import java.util.List;

public interface memberIntegralService {
    int saveMemberIntegral(memberIntegral memberIntegral);
    Integer countMemberIntegral(String memberId);
    List<memberIntegral> findMemberIntegral(String memberId, int currPage, int pageSize);
    List<String> findAllMemberId();
}
