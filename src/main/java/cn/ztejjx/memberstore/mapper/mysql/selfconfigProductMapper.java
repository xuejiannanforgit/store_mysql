package cn.ztejjx.memberstore.mapper.mysql;

import cn.ztejjx.memberstore.domain.mysql.configProduct;

import java.util.List;
import java.util.Map;

public interface selfconfigProductMapper {

    List<configProduct> findConfigProduct(Map<String, Object> data);

    configProduct findProductAllInfoByproductId(Map<String, Object> data) ;

    List<configProduct> findProductListBybrandsId(Map<String, Object> data);

    List<configProduct> findRecommendProductbyrecommendedDept(String recommendedDept);

    List<configProduct> findRecommendProduct();

}
