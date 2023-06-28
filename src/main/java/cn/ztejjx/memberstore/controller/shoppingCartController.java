package cn.ztejjx.memberstore.controller;

import cn.ztejjx.memberstore.domain.redis.shoppingCart;
import cn.ztejjx.memberstore.utils.RedisUtils;
import cn.ztejjx.memberstore.utils.ResultUtils;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/pri/shoppingCart")
@Transactional
public class shoppingCartController {

    @Autowired
    private RedisUtils redisUtil;


    @RequestMapping("/getShoppingCartByOpenId")
    public ResultUtils getShoppingCartByOpenId(@RequestParam("openId") String openId)
    {
        String key  = "shoppingCart-"+"-"+openId;
        Map<Object,Object> map = redisUtil.hmget(key);
        Collection<Object> col = map.values();
        return ResultUtils.success("查询成功",col);
    }

    @RequestMapping("/subtractedShoppingCartByOpenId")
    public ResultUtils subtractedShoppingCartByOpenId(@RequestParam("jsonData")String jsonData)
    {
        JSONObject JS = JSONObject.parseObject(jsonData);
        shoppingCart shoppingCart =	(shoppingCart) JSONObject.toJavaObject(JS, shoppingCart.class);
        String key  = "shoppingCart-"+"-"+shoppingCart.getOpenid();
        String item = shoppingCart.getProductId();
        int time = 60*60*24*7; //过期时间1周
        //减去商品
        if(redisUtil.hget(key,item)==null)
        {
            return ResultUtils.fail("购物车没有该商品",null);
        }
        else //减去商品数量
        {
            //获取Redis 中记录 转换为 JSONObject
            JSONObject addJS = JSONObject.parseObject(redisUtil.hget(key,item).toString());
            //获取JSONObject转换为实体
            shoppingCart addshoppingCart =	(shoppingCart) JSONObject.toJavaObject(addJS, shoppingCart.class);
            //数量大于0
            if(addshoppingCart.getNum().compareTo(new BigDecimal(1))==1  )
            {
                //修改数量减一
                addshoppingCart.setNum(addshoppingCart.getNum().subtract(new BigDecimal(1)));
//                addshoppingCart.setProductNum(addshoppingCart.getNum().add(new BigDecimal(1)));
                // 转换为json字符串
                String result = JSONObject.toJSON(addshoppingCart).toString();
                redisUtil.hset(key,item,result,time);
            }
            else
            {   //移除
                redisUtil.hdel(key,item);
            }

//            Map<Object,Object>  map =   redisUtil.hmget(key);
//            BigDecimal sumPrice = new BigDecimal(0);
//            for (Object in : map.keySet()) {
//                BigDecimal tempPrice ;
//                String str = map.get(in).toString();//得到每个key多对用value的值
//                JSONObject tempaddJS = JSONObject.parseObject(str);
//                shoppingCart tempaddshoppingCart =	(shoppingCart) JSONObject.toJavaObject(tempaddJS, shoppingCart.class);
//                sumPrice= sumPrice.add(tempaddshoppingCart.getNum().multiply(tempaddshoppingCart.getRetailPrice()));
//            }
            return ResultUtils.success("移除成功",null);
        }
    }


    @RequestMapping("/addShoppingCartByOpenId")
    public ResultUtils addShoppingCartByOpenId(@RequestParam("jsonData")String jsonData )
    {
        JSONObject JS = JSONObject.parseObject(jsonData);
        shoppingCart shoppingCart =	(shoppingCart) JSONObject.toJavaObject(JS, shoppingCart.class);
        String key  = "shoppingCart-"+"-"+shoppingCart.getOpenid();
        String item = shoppingCart.getProductId();
        int time = 60*60*24*7; //过期时间1周

        //新增商品
        if(redisUtil.hget(key,item)==null)
        {
            shoppingCart.setNum(new BigDecimal(1));
            String result = JSONObject.toJSON(shoppingCart).toString();
            redisUtil.hset(key,item,result,time);
        }
        else //增加商品数量
        {
            //获取Redis 中记录 转换为 JSONObject
            JSONObject addJS = JSONObject.parseObject(redisUtil.hget(key,item).toString());
            //获取JSONObject转换为实体
            shoppingCart addshoppingCart =	(shoppingCart) JSONObject.toJavaObject(addJS, shoppingCart.class);
            //商品库存大于购物车库存 正常添加
            //修改数量加一
            addshoppingCart.setNum(addshoppingCart.getNum().add(new BigDecimal(1)));
//            addshoppingCart.setProductNum(addshoppingCart.getNum().subtract(new BigDecimal(1)));
            // 转换为json字符串
            String result = JSONObject.toJSON(addshoppingCart).toString();
            redisUtil.hset(key,item,result,time);
        }

//        Map<Object,Object>  map =   redisUtil.hmget(key);
//        if(map.size()!=0)
//        {
//            BigDecimal sumPrice = new BigDecimal(0);
//            for (Object in : map.keySet()) {
//                String str = map.get(in).toString();//得到每个key多对用value的值
//                JSONObject tempaddJS = JSONObject.parseObject(str);
//                shoppingCart tempaddshoppingCart =	(shoppingCart) JSONObject.toJavaObject(tempaddJS, shoppingCart.class);
//                sumPrice= sumPrice.add(tempaddshoppingCart.getNum().multiply(tempaddshoppingCart.getRetailPrice()));
//            }
//            System.out.println(sumPrice);
//        }

        return ResultUtils.success("添加成功",null);
    }




    @RequestMapping("/saveshoppingCart")
    public ResultUtils saveshoppingCart(@RequestParam("jsonData")String jsonData){
        JSONObject JS = JSONObject.parseObject(jsonData);
        shoppingCart shoppingCart =	(shoppingCart) JSONObject.toJavaObject(JS, shoppingCart.class);
        String key  = "shoppingCart-"+"-"+shoppingCart.getOpenid();
        String item = shoppingCart.getProductId();
        int time = 60*60*24*7; //过期时间1周

        if(redisUtil.hget(key,item)==null)
        {
            shoppingCart.setNum(new BigDecimal(1));
            String result = JSONObject.toJSON(shoppingCart).toString();
            redisUtil.hset(key,item,result,time);
        }
        else
        {
            //获取Redis 中记录 转换为 JSONObject
            JSONObject addJS = JSONObject.parseObject(redisUtil.hget(key,item).toString());
            //获取JSONObject转换为实体
            shoppingCart addshoppingCart =	(shoppingCart) JSONObject.toJavaObject(addJS, shoppingCart.class);
            //商品库存大于购物车库存 正常添加
            //修改数量加一
            addshoppingCart.setNum(addshoppingCart.getNum().add(new BigDecimal(1)));
            String result = JSONObject.toJSON(addshoppingCart).toString();
            redisUtil.hset(key,item,result,time);
        }


//        Map<Object,Object> map =   redisUtil.hmget(key);
//        if(map.size()!=0)
//        {
//            BigDecimal sumPrice = new BigDecimal(0);
//            for (Object in : map.keySet()) {
//                String str = map.get(in).toString();//得到每个key多对用value的值
//                JSONObject tempaddJS = JSONObject.parseObject(str);
//                shoppingCart tempaddshoppingCart =	(shoppingCart) JSONObject.toJavaObject(tempaddJS, shoppingCart.class);
//                sumPrice= sumPrice.add(tempaddshoppingCart.getNum().multiply(tempaddshoppingCart.getRetailPrice()));
//             }
//
//             System.out.println(sumPrice);
//        }
        return ResultUtils.success("添加成功",null);
    }
}
