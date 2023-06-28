package cn.ztejjx.memberstore.mapper.mysql;

import java.util.List;
import java.util.Map;

public interface selfvoteDetailMapper {

    int findVoteDetailCountByEmployeeId(Map<String, Object> data);

    int findVoteDetailCountByEmployeeId2(Map<String, Object> data);
    int validateVoteDetail(Map<String, Object> data) ;

    List<String> findopenIdVoteDetailByemployeeName(Map<String, Object> data);;


}
