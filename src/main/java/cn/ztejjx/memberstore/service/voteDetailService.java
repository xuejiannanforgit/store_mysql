package cn.ztejjx.memberstore.service;

import cn.ztejjx.memberstore.domain.mysql.voteDetail;

import java.util.List;

public interface voteDetailService {

    int saveVoteDetail(voteDetail voteDetail);

    int findVoteDetailCountByEmployeeId(String employeeId,String voteName );

    int findVoteDetailCountByEmployeeId(String employeeId );

    int validateVoteDetail(String employeeId, String openId);

    List<String> findopenIdVoteDetailByemployeeName(String employeeName);



}
