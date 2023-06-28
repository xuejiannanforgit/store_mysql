package cn.ztejjx.memberstore.service;

import cn.ztejjx.memberstore.domain.mysql.oilCard;

import java.math.BigDecimal;
import java.util.List;

public interface oilCardService {

   List<oilCard> findOilCardList();

   List<oilCard> findOilCardbyDept(String dept);

   int updateRemain(BigDecimal actualOilamount, String cardNum);


}

//   actualOilnum:that.data.actualOilNum,//实际加油量
//           actualOilamount:that.data.actualOilamount, //实际加油金额
//           oilcardNum:that.data.currentOilList.oilcardNum
//
//<update id="updateRemain">
//        update oil_card
//        set oilcard_remain = oilcard_remain + #{charge}
//        where enabled_flag = 1
//        and oilcard_Num = #{cardNum}
//</update>