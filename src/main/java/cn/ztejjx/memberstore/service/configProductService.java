package cn.ztejjx.memberstore.service;

import cn.ztejjx.memberstore.domain.mysql.configProduct;

import java.util.List;

public interface configProductService {

    List<configProduct>  findConfigProduct(int currPage, int pageSize);

    configProduct   findProductByproductId(String productId);

    configProduct   findProductAllInfoByproductId(String productId);

    List<configProduct> findProductListBybrandsId(String productBrandsid);

    List<configProduct>  findRecommendProduct();



}
