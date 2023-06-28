package cn.ztejjx.memberstore.service;

import cn.ztejjx.memberstore.domain.mysql.sharerecord;

import java.util.List;

public interface sharerecordService {
    int  savesharerecord(sharerecord sharerecord);

    List<sharerecord> findSharerecord(String memberId, int currIndex, int pageSize);
}
