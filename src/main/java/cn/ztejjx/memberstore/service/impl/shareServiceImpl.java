package cn.ztejjx.memberstore.service.impl;


import cn.ztejjx.memberstore.domain.mysql.share;
import cn.ztejjx.memberstore.domain.mysql.shareimage;
import cn.ztejjx.memberstore.service.shareService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class shareServiceImpl  implements shareService{

    @Autowired
    private cn.ztejjx.memberstore.mapper.mysql.shareimageMapper shareimageMapper;

    @Autowired
    private cn.ztejjx.memberstore.mapper.mysql.shareMapper shareMapper;

    @Autowired
    private cn.ztejjx.memberstore.mapper.mysql.selfshareMapper selfshareMapper;

    @Override
    public int saveShare(share share) {
        share.setEnabledFlag(1);
        share.setCreatedDate(new Date());
        int count = this.shareMapper.insert(share);
        return count;
    }

    @Override
    public int saveShareImage(shareimage shareimage) {
        shareimage.setEnabledFlag(1);
        shareimage.setShareimageId(UUID.randomUUID().toString().replace("-", ""));
        int count = this.shareimageMapper.insert(shareimage);


        return count;
    }

    @Override
    public List<share> findShareInfo(String coachId, int currIndex, int pageSize) {


        Map<String, Object> data = new HashMap<>();
        data.put("currIndex",(currIndex-1)*pageSize);
        data.put("pageSize",pageSize);
        data.put("coachId",coachId);
        return selfshareMapper.findShareInfo(data);

    }
}
