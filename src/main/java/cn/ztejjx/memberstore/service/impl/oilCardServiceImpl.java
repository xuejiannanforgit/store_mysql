package cn.ztejjx.memberstore.service.impl;

import cn.ztejjx.memberstore.domain.mysql.configImage;
import cn.ztejjx.memberstore.domain.mysql.oilCard;
import cn.ztejjx.memberstore.mapper.mysql.selfoilCardMapper;
import cn.ztejjx.memberstore.service.oilCardService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class oilCardServiceImpl implements oilCardService {



    @Autowired
    private  cn.ztejjx.memberstore.mapper.mysql.oilCardMapper  oilCardMapper;

    @Autowired
    private  cn.ztejjx.memberstore.mapper.mysql.selfoilCardMapper  selfoilCardMapper;




    @Override
    public List<oilCard> findOilCardList() {
        return null;
    }

    @Override
    public List<oilCard> findOilCardbyDept(String dept) {
        QueryWrapper<oilCard> wrapper = new QueryWrapper<oilCard>();
        wrapper.eq("enabled_flag",1);
        wrapper.eq("oilcard_Dept",dept);
        return this.oilCardMapper.selectList(wrapper);
    }

    @Override
    public int updateRemain(BigDecimal actualOilamount, String cardNum) {

        Map<String, Object> data = new HashMap<>();
        data.put("actualOilamount", actualOilamount.multiply(new BigDecimal(-1)));
        data.put("cardNum", cardNum);

        return  selfoilCardMapper.updateRemain(data);

    }
}
