package cn.ztejjx.memberstore.controller;

import cn.ztejjx.memberstore.domain.mysql.configImage;
import cn.ztejjx.memberstore.domain.mysql.configProduct;
import cn.ztejjx.memberstore.domain.mysql.configProductBrands;
import cn.ztejjx.memberstore.domain.redis.SelfConfigProductClassify;
import cn.ztejjx.memberstore.utils.RedisUtils;
import cn.ztejjx.memberstore.utils.ResultUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/pri/configProduct")
@Transactional
public class configProductController {

    @Autowired
    private cn.ztejjx.memberstore.service.configProductService configProductService;

    @Autowired
    private cn.ztejjx.memberstore.service.configImageService configImageService;

    @Autowired
    private cn.ztejjx.memberstore.service.configProductClassifyService configProductClassifyService;

    @Autowired
    private RedisUtils redisUtil;


    @RequestMapping("/findRecommendProduct")
    public ResultUtils findRecommendProduct( )
    {
        List<configProduct> recommendProductlist = null;
        if(redisUtil.get("recommendProductlist")==null)
        {
            recommendProductlist = configProductService.findRecommendProduct();
            redisUtil.set("recommendProductlist",recommendProductlist);
        }
        else
        {
            recommendProductlist = (List<configProduct>)redisUtil.get("recommendProductlist");
        }
        return ResultUtils.success("查询成功",recommendProductlist);
    }



    @RequestMapping("/findManagerProductListByAppid")
    public ResultUtils findManagerProductListByAppid()
    {
        Map<String,Object> map =new HashMap<>();
        String key  = "findManagerProductList";
        if(redisUtil.get(key)==null )
        {

            List<SelfConfigProductClassify> classifyList = configProductClassifyService.findProductList();
            List<net.sf.json.JSONObject> listJson = new ArrayList<>();

            for(int i=0;i<classifyList.size();i++)
            {
                for(int j=0;j<classifyList.get(i).getProductBrandsList().size();j++)
                {
                    configProductBrands configProductBrands =classifyList.get(i).getProductBrandsList().get(j);
                    String productBrandsid = configProductBrands.getProductBrandsid();
                    List<configProduct>  configProductlist =  configProductService.findProductListBybrandsId(productBrandsid);
                    classifyList.get(i).getProductBrandsList().get(j).setConfigProductList(configProductlist );
                }
            }
            if(classifyList.size()!=0)
            {
                redisUtil.set(key,classifyList);
            }
            map.put("classifyList",classifyList);
        }
        else
        {


            map.put("classifyList",redisUtil.get(key));
        }
        return ResultUtils.success("查询成功",map);
     }



    @RequestMapping("/findProductAllInfoByproductId")
    public ResultUtils findProductAllInfoByproductId(String productId)
    {

        configProduct product = configProductService.findProductAllInfoByproductId(productId);
//        configProduct  product = null;
//        if(redisUtil.hget("findProductAllInfoByproductId",productId) ==null)
//        {
//            product = configProductService.findProductAllInfoByproductId(productId);
//            redisUtil.hset("findProductAllInfoByproductId",productId,product);
//        }
//        else
//        {
//            product = (configProduct)redisUtil.hget("findProductAllInfoByproductId",productId);
//        }

        List<configImage> configImagelist = null;
        if(redisUtil.get("findadvConfigImage")==null)
        {
            configImagelist = configImageService.findadvConfigImage();
            redisUtil.set("findadvConfigImage",configImagelist);
        }
        else
        {
            configImagelist = ( List<configImage>)redisUtil.get("findadvConfigImage");
        }

        Map<String,Object> map = new HashMap<>();
        map.put("product",product);
        map.put("configImagelist",configImagelist);
        return ResultUtils.success("查询成功", map);
    }

    @RequestMapping("/findConfigProduct")
    public ResultUtils findConfigProduct(int currPage, int pageSize)
    {
         List<configProduct> list = null;
        if(currPage==1)
        {
            if(redisUtil.get("findConfigProduct")==null)
            {
                list =    configProductService.findConfigProduct(currPage,pageSize);
                redisUtil.set("findConfigProduct",list);
            }
            else
            {
                list =  (List<configProduct>)redisUtil.get("findConfigProduct");
            }
        }
        else
        {
            list =    configProductService.findConfigProduct(currPage,pageSize);
        }
        return ResultUtils.success("查询成功", list);
    }



}

