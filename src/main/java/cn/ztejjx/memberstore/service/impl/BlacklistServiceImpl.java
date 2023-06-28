package cn.ztejjx.memberstore.service.impl;


import cn.ztejjx.memberstore.domain.mysql.AttentionInfo;
import cn.ztejjx.memberstore.domain.mysql.Blacklist;
import cn.ztejjx.memberstore.mapper.mysql.BlacklistMapper;
import cn.ztejjx.memberstore.service.BlacklistService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BlacklistServiceImpl implements BlacklistService {

    @Autowired
    private BlacklistMapper blacklistMapper;
    @Override
    public int validateBlacklist(String openid) {
        QueryWrapper<Blacklist> wrapper = new QueryWrapper<Blacklist>();
        wrapper.eq("openid",openid);
        wrapper.eq("enabled_flag",1);
        return this.blacklistMapper.selectCount (wrapper);
    }
}