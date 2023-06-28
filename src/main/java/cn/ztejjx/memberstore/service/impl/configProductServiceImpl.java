package cn.ztejjx.memberstore.service.impl;

import cn.ztejjx.memberstore.domain.mysql.configProduct;
import cn.ztejjx.memberstore.mapper.mysql.selfconfigProductMapper;
import cn.ztejjx.memberstore.service.configProductService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)
public class configProductServiceImpl implements configProductService {

    @Autowired
    private  selfconfigProductMapper selfconfigProductMapper;

    @Autowired
    private cn.ztejjx.memberstore.mapper.mysql.configProductMapper configProductMapper;

    @Override
    public List<configProduct> findConfigProduct( int currPage, int pageSize) {
        Map<String, Object> data = new HashMap<>();
        data.put("currPage", (currPage-1)*pageSize);
        data.put("pageSize",  pageSize);
        return  selfconfigProductMapper.findConfigProduct(data);
    }

    @Override
    public configProduct findProductByproductId(String productId) {
        QueryWrapper<configProduct>  wrapper = new QueryWrapper<>();
        wrapper.eq("product_Id",productId);
        wrapper.eq("enabled_flag",1);
        configProduct  configProduct   = this.configProductMapper.selectOne(wrapper);
        return configProduct;
    }

    @Override
    public configProduct findProductAllInfoByproductId(String productId) {
        Map<String, Object> data = new HashMap<>();
        data.put("productId",  productId);
        return  selfconfigProductMapper.findProductAllInfoByproductId(data);
    }

    @Override
    public List<configProduct> findProductListBybrandsId(String productBrandsid) {
        Map<String, Object> data = new HashMap<>();
        data.put("productBrandsid",productBrandsid);
        return  selfconfigProductMapper.findProductListBybrandsId(data);
    }

    @Override
    public List<configProduct> findRecommendProduct() {
//        Map<String, Object> data = new HashMap<>();
//        data.put("recommended_dept",recommendedDept);
//
//        if(!"".equals(recommendedDept)&&recommendedDept!=null)
//        {
//            configProductlist =  selfconfigProductMapper.findRecommendProductbyrecommendedDept(recommendedDept);
//        }
//        else
//        {
//            configProductlist = selfconfigProductMapper.findRecommendProduct();
//        }
        return selfconfigProductMapper.findRecommendProduct();
    }
}



