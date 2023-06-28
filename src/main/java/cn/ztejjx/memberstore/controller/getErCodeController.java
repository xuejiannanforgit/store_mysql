package cn.ztejjx.memberstore.controller;


import cn.ztejjx.memberstore.utils.HttpUtils;
import cn.ztejjx.memberstore.utils.RedisUtils;
import cn.ztejjx.memberstore.utils.ResultUtils;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping("/api/v1/pri/ErCode")
@Transactional
public class getErCodeController {

    private static String accessTokenvalue =null;
    private static  byte[] data =null;
    private static final long serialVersionUID = 1L;

    private static  final  String appid = "wx38e88b7f48911036";
    private static  final  String secret = "8cb090f7e9410988e5f771415308dce4";


//    private static  final  String appid = "wx1e13590ce72d00a9";
//    private static  final  String secret = "db47ab40aade81eda9763b7fcaf93cfc";


    @Autowired
    private RedisUtils redisUtil;
    @RequestMapping("/getErCode")
    public ResultUtils getErCode(String memberPhone,String activitiesId)
    {

        String HttpPath = "";
        int count = 0;

        String tokenUrl = "https://api.weixin.qq.com/cgi-bin/token?";
        String erCodeUrl = "https://api.weixin.qq.com/wxa/getwxacodeunlimit?";
        String url = tokenUrl+"grant_type=client_credential&appid="+appid+"&secret="+secret;
        String   accessTokenvalue =   (String)redisUtil.get(appid+"_AccessTokenvalue");

        if(accessTokenvalue==null)
        {
              JSONObject json = JSONObject.fromObject(getAccessTokenvalue());
              count = Integer.parseInt(json.getString("expires_in"));
              accessTokenvalue = json.getString("access_token");
              redisUtil.set(appid+"_AccessTokenvalue",accessTokenvalue,count-200);
              HttpPath = getQRcode(accessTokenvalue,memberPhone,activitiesId);
        }
        else
        {
              HttpPath = getQRcode(accessTokenvalue,memberPhone,activitiesId);
        }

        return   ResultUtils.success("生成成功",HttpPath);
    }

    public static String getQRcode(String accessTokenvalue,String memberPhone,String activitiesId){
        String url="https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token="+accessTokenvalue;
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("scene",memberPhone+"_"+activitiesId);
        jsonObject.put("page", "pages/share/ercodeindex");
        jsonObject.put("width",640);
        jsonObject.put("check_path",false);


//        jsonObject.put("scene","1");
//        jsonObject.put("page", "pages/coache/questionnairelist");
//        jsonObject.put("width",640);
//        jsonObject.put("check_path",false);



        String HttpPath  = sendPost(url,jsonObject.toString(),memberPhone,activitiesId);
        return  HttpPath;
    }

    public static String sendPost(String url, String param,String memberPhone,String activitiesId)
    {
        PrintWriter out = null;
        String httpPath = null;
        String result = "";
        try {
            URL realUrl = new URL(url);
            URLConnection conn = realUrl.openConnection();
            conn.setRequestProperty("accept", "*/*");
            conn.setRequestProperty("connection", "Keep-Alive");
            conn.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            conn.setDoOutput(true);
            conn.setDoInput(true);

            out = new PrintWriter(conn.getOutputStream());
            out.print(param);
            out.flush();
            InputStream inStream = conn.getInputStream();
            data = readInputStream(inStream);
            SimpleDateFormat sdf  = new SimpleDateFormat("yyyyMM");
            String  dir = sdf.format(new Date());
            String imageHttpPath= null;
            String Path= null;
            imageHttpPath="https://fruit.ztejjx.com/img/share/ercode";
            Path="/usr/local/soft/img/share/ercode/"+dir+"/";
            //Path="F:/";
            httpPath=imageHttpPath+"/"+dir+"/"+memberPhone+"_"+activitiesId+".jpg";

            File f = new File(Path);
            if(!f.exists())
            {
                f.mkdirs();
            }
            File imageFile = new File(Path+""+memberPhone+"_"+activitiesId+".jpg");
            FileOutputStream outStream = new FileOutputStream(imageFile);
            outStream.write(data);
            outStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            if(out!=null){
                out.close();
            }
        }
        return httpPath;
    }

    public static byte[] readInputStream(InputStream inStream) throws Exception{
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while( (len=inStream.read(buffer)) != -1 ){
            outStream.write(buffer, 0, len);
        }
        inStream.close();
        //System.out.println("param............."+outStream.toString());
        return outStream.toByteArray();
    }


    public String getAccessTokenvalue()
    {
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid="+appid+"&secret="+secret+"";
        return sendGet(url);
    }


    public static String sendGet(String url){
        BufferedReader in=null;
        String result = null;
        try {
            String urlNameString=url;
            URL realurl=new URL(urlNameString);
            URLConnection connection=realurl.openConnection();
            // 设置通用的请求属性
            connection.setRequestProperty("accept", "*/*");
            connection.setRequestProperty("connection", "Keep-Alive");
            connection.setRequestProperty("Encoding", "utf-8");
            connection.setRequestProperty("user-agent",
                    "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1;SV1)");
            // 建立实际的连接
            connection.connect();
            // 定义 BufferedReader输入流来读取URL的响应
            in = new BufferedReader(new InputStreamReader(
                    connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 使用finally块来关闭输入流
        finally {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return result.replace("null","");
    }
}


