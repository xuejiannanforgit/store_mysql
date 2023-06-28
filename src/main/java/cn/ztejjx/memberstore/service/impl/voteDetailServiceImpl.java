package cn.ztejjx.memberstore.service.impl;

import cn.ztejjx.memberstore.domain.mysql.voteDetail;
import cn.ztejjx.memberstore.service.voteDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.*;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class voteDetailServiceImpl implements voteDetailService {

    @Autowired
    private cn.ztejjx.memberstore.mapper.mysql.selfvoteDetailMapper selfvoteDetailMapper;

    @Autowired
    private cn.ztejjx.memberstore.mapper.mysql.voteDetailMapper voteDetailMapper;


    @Override
    public int saveVoteDetail(voteDetail voteDetail) {
        voteDetail.setVoteId(UUID.randomUUID().toString().replace("-", ""));
        voteDetail.setEnableFlag(1);
        voteDetail.setCreateDate(new Date());
        int count = voteDetailMapper.insert(voteDetail);
        return count;
    }

    @Override
    public int findVoteDetailCountByEmployeeId(String employeeId,String voteName ) {
        Map<String, Object> data = new HashMap<>();
        data.put("employeeId",  employeeId);
        data.put("voteName",  voteName);
        return  selfvoteDetailMapper.findVoteDetailCountByEmployeeId2(data);
    }

    @Override
    public int findVoteDetailCountByEmployeeId(String employeeId ) {
        Map<String, Object> data = new HashMap<>();
        data.put("employeeId",  employeeId);
        return  selfvoteDetailMapper.findVoteDetailCountByEmployeeId(data);
    }

    @Override
    public int validateVoteDetail(String employeeId,String openId) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Map<String, Object> data = new HashMap<>();
        data.put("employeeId",  employeeId);
        data.put("openId",openId);
        data.put("voteDate",sdf.format(new Date()));
        return selfvoteDetailMapper.validateVoteDetail(data);
    }

    @Override
    public List<String> findopenIdVoteDetailByemployeeName(String employeeName) {
        Map<String, Object> data = new HashMap<>();
        data.put("employeeName",  employeeName);
        return selfvoteDetailMapper.findopenIdVoteDetailByemployeeName(data);
    }


}
