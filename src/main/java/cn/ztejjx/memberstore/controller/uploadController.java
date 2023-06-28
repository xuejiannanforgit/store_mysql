package cn.ztejjx.memberstore.controller;


import cn.ztejjx.memberstore.domain.mysql.shareimage;

import cn.ztejjx.memberstore.service.commonService;

import cn.ztejjx.memberstore.utils.RedisUtils;
import cn.ztejjx.memberstore.utils.ResultUtils;
import net.sf.json.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/pri/uploadServer")
@Transactional
public class uploadController {

    private static  String  AccessToken = null;

    @Autowired
    private RedisUtils redisUtil;

    @Autowired
    private commonService commonService;



    @Autowired
    private cn.ztejjx.memberstore.service.shareService shareService;

    @PostMapping("/uploadImage")
    public Object uploadImage(@RequestParam("file")MultipartFile file, @RequestParam("dataId") String  dataId, @RequestParam("filename") String filename, @RequestParam("filetype") String filetype, @RequestParam("filePath") String filePath, @RequestParam("httpfilePath") String httpfilePath) throws Exception
    {

        if(redisUtil.hget("AccessToken","wx38e88b7f48911036")==null)
        {
            AccessToken =  commonService.createAccessToken("wx38e88b7f48911036");
        }
        else
        {
            AccessToken = (String)redisUtil.hget("AccessToken","wx38e88b7f48911036");
        }

        if (file.isEmpty()) {
            return ResultUtils.fail("上传失败，请选择文件");
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String date = sdf.format(new Date());

        String temphttpfilePath = httpfilePath+"/"+date+"/";

        String separator = File.separator;
        String tempfilePath = filePath +separator+ date;

        File dest = new File(tempfilePath,filename);
        if(!dest.exists())
        {
            dest.mkdirs();
            file.transferTo(dest);
        }
        else
        {
            file.transferTo(dest);
        }



        InputStream In = new FileInputStream(dest);
        Boolean checkPic =  checkPic(In);
        In.close();

        if(checkPic==true)
        {
            if( "sendComment".equals(filetype))
            {
                Map<String,Object> map = new HashMap<>();
                map.put("ImageUrl",temphttpfilePath+filename);
                map.put("CoachCommentsId",dataId);
                return ResultUtils.success("sendComment上传成功",map);
//                miniCoachCommentsimage  coachCommentsimage = new miniCoachCommentsimage();
//                coachCommentsimage.setImageUrl(temphttpfilePath+filename);
//                coachCommentsimage.setCoachCommentsId(dataId);
//                coachCommentsimageService.saveMiniCoachCommentsimage(coachCommentsimage);
//                return ResultUtils.success("上传成功",temphttpfilePath+filename);
            }
            else if("sendShare".equals(filetype))
            {
                shareimage shareimage = new shareimage();
                shareimage.setShareId(dataId);
                shareimage.setImageUrl(temphttpfilePath+filename);
                shareService.saveShareImage(shareimage);
                return ResultUtils.success("上传成功",temphttpfilePath+filename);
            }
            else if("head".equals(filetype))
            {

                return ResultUtils.success("上传成功",temphttpfilePath+filename);
            }

            //dest.delete();
        }
        else if(checkPic==false)
        {
            return ResultUtils.fail("内容含有违法违规内容",null);
        }
        return  ResultUtils.fail("上传失败");

    }

    /**
     *  恶意图片过滤
     * @return
     */
    public static Boolean checkPic(InputStream inputStream) {


        try {

            CloseableHttpClient httpclient = HttpClients.createDefault();
            CloseableHttpResponse response = null;
            HttpPost request = new HttpPost("https://api.weixin.qq.com/wxa/img_sec_check?access_token=" + AccessToken);
            request.addHeader("Content-Type", "application/octet-stream");
            byte[] byt = new byte[inputStream.available()];
            inputStream.read(byt);
            request.setEntity(new ByteArrayEntity(byt, ContentType.create("image/jpg")));
            response = httpclient.execute(request);
            HttpEntity httpEntity = response.getEntity();
            String result = EntityUtils.toString(httpEntity, "UTF-8");// 转成string
            JSONObject json = JSONObject.fromObject(result);
            Integer  errcode =  (Integer) json.get("errcode");
            if (errcode == 0) {
                return true;
            } else if (errcode == 87014) {
                System.out.println("图片内容违规-----------");
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("----------------调用腾讯内容过滤系统出错------------------");
            return true;
        }
    }

}
