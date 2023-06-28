package cn.ztejjx.memberstore.service.impl;


import cn.ztejjx.memberstore.service.commonService;
import cn.ztejjx.memberstore.utils.RedisUtils;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

@Service
@Transactional(propagation = Propagation.REQUIRES_NEW)


public class commonServiceImpl implements commonService {

   String tokenUrl = "https://api.weixin.qq.com/cgi-bin/token?";

    @Autowired
    private RedisUtils redisUtil;

    @Override
    public String createAccessToken(String appid) {

        String secret="8cb090f7e9410988e5f771415308dce4";
        String url = tokenUrl+"grant_type=client_credential&appid="+appid+"&secret="+secret;

        String  accessToken = getAccessTokenService(url,appid);

        return accessToken;
    }


    public String getAccessTokenService(String url,String appid) {
        String token = null;
        if(redisUtil.hget("AccessToken",appid)==null)
        {
            BufferedReader in=null;
            String result = null;
            try {
                String urlNameString=url;
                URL realurl=new URL(urlNameString);
                URLConnection connection=realurl.openConnection();
                connection.setRequestProperty("accept", "*/*");
                connection.setRequestProperty("connection", "Keep-Alive");
                connection.setRequestProperty("Encoding", "utf-8");
                connection.setRequestProperty("user-agent",
                        "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
                connection.connect();
                in = new BufferedReader(new InputStreamReader(
                        connection.getInputStream()));
                String line;
                while ((line = in.readLine()) != null) {
                    result += line;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            finally {
                try {
                    if (in != null) {
                        in.close();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            }

            JSONObject json= JSONObject.fromObject(result.replace("null",""));
            int count=Integer.parseInt(json.getString("expires_in"));
            token=json.getString("access_token");
            redisUtil.hset("AccessToken",appid,token,count-1000);
        }
        else
        {
            token = (String)redisUtil.hget("AccessToken",appid);
        }
        return token;
    }
}

