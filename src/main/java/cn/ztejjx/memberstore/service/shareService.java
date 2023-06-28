package cn.ztejjx.memberstore.service;

import cn.ztejjx.memberstore.domain.mysql.share;
import cn.ztejjx.memberstore.domain.mysql.shareimage;

import java.util.List;

public interface shareService {

    int saveShare(share share);

    int saveShareImage(shareimage shareimage);

    List<share> findShareInfo(String coachId, int currIndex, int pageSize);


}
