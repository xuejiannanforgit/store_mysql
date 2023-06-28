package cn.ztejjx.memberstore.controller;

import cn.ztejjx.memberstore.domain.mysql.memberInfo;
import cn.ztejjx.memberstore.utils.HttpUtils;
import cn.ztejjx.memberstore.utils.ResultUtils;
import net.sf.json.JSONObject;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.encoders.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.security.Security;
import java.util.List;

@RestController
@RequestMapping("/api/v1/pri/commonServer")
@Transactional
public class commonController {

    private static final String KEY_ALGORITHM = "AES";
    private static final String ALGORITHM_STR = "AES/CBC/PKCS7Padding";
    private static Key key;
    private static Cipher cipher;
    private static  final  String appid = "wx38e88b7f48911036";
    private static  final  String secret = "8cb090f7e9410988e5f771415308dce4";

    @Autowired
    private cn.ztejjx.memberstore.service.memberInfoService memberInfoService;


    @RequestMapping("/getOpenId")
    public String getOpenId(String code)
    {
         String url="https://api.weixin.qq.com/sns/jscode2session?appid="+appid+"&secret="+secret+"&js_code="+code+"&grant_type=xuejianan";
         JSONObject json = JSONObject.fromObject(HttpUtils.sendGet(url));
         return  json.toString();
    }


    @RequestMapping("/getCustomerPhone")
    public ResultUtils getCustomerPhone2(String encryptedData, String iv, String code)
    {

        String url="https://api.weixin.qq.com/sns/jscode2session?appid="+appid+"&secret="+secret+"&js_code="+code+"&grant_type=xuejianan";
        JSONObject json = JSONObject.fromObject(HttpUtils.sendGet(url));
        decryptData(encryptedData,(String)json.get("session_key"),iv) ;
        String result = decryptData(encryptedData,(String)json.get("session_key"),iv) ;
        JSONObject resultjson = JSONObject.fromObject(result);

        return  ResultUtils.success  ("查询成功",resultjson.getString("phoneNumber"));
    }



    @RequestMapping("/getPhoneNumber")
    public ResultUtils getCustomerPhone(String encryptedData, String iv, String code)
    {

        String url="https://api.weixin.qq.com/sns/jscode2session?appid="+appid+"&secret="+secret+"&js_code="+code+"&grant_type=xuejianan";
        JSONObject json = JSONObject.fromObject(HttpUtils.sendGet(url));

        decryptData(encryptedData,(String)json.get("session_key"),iv) ;
        String result = decryptData(encryptedData,(String)json.get("session_key"),iv) ;
        JSONObject resultjson = JSONObject.fromObject(result);
        //通过手机号查询会员信息
        List<memberInfo> list = memberInfoService.findMemberInfoBymemberPhone(resultjson.getString("phoneNumber"));
       //  List<memberInfo> list = memberInfoService.findMemberInfoBymemberPhone("17585494964");


        if(list.size()==0)
        {
           return ResultUtils.fail("信息查询为空",null);
        }
        else
        {
           return  ResultUtils.success  ("绑定成功",list.get(0));
        }
    }

    public static String decryptData(String encryptDataB64, String sessionKeyB64, String ivB64) {
        return new String(
                decryptOfDiyIV(Base64.decode(encryptDataB64), Base64.decode(sessionKeyB64),Base64.decode(ivB64)
                )
        );
    }


    /**
     * 解密方法
     *
     * @param encryptedData 要解密的字符串
     * @param keyBytes      解密密钥
     * @param ivs           自定义对称解密算法初始向量 iv
     * @return 解密后的字节数组
     */
    private static byte[] decryptOfDiyIV(byte[] encryptedData, byte[] keyBytes, byte[] ivs) {
        byte[] encryptedText = null;
        init(keyBytes);
        try {
            cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(ivs));
            encryptedText = cipher.doFinal(encryptedData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encryptedText;
    }

    private static void init(byte[] keyBytes) {
        // 如果密钥不足16位，那么就补足.  这个if 中的内容很重要
        int base = 16;
        if (keyBytes.length % base != 0) {
            int groups = keyBytes.length / base + (keyBytes.length % base != 0 ? 1 : 0);
            byte[] temp = new byte[groups * base];
            org.bouncycastle.util.Arrays.fill(temp, (byte) 0);
            System.arraycopy(keyBytes, 0, temp, 0, keyBytes.length);
            keyBytes = temp;
        }
        // 初始化
        Security.addProvider(new BouncyCastleProvider());
        // 转化成JAVA的密钥格式
        key = new SecretKeySpec(keyBytes, KEY_ALGORITHM);
        try {
            // 初始化cipher
            cipher = Cipher.getInstance(ALGORITHM_STR, "BC");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }





}
