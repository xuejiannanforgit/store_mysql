package cn.ztejjx.memberstore.controller;

import cn.ztejjx.memberstore.mapper.mysql.oilRecordMapper;
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
import org.springframework.beans.factory.annotation.Value;
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


//上传图片
@RestController
@RequestMapping("/api/v1/pri/oiluploadServer")
public class oilUploadController {


    @Autowired
    private cn.ztejjx.memberstore.service.oilRecordService oilRecordService;

    @PostMapping("/uploadImage")
    public Object uploadImage(  @RequestParam("file")MultipartFile file, @RequestParam("filename") String filename,   @RequestParam("filePath") String filePath, @RequestParam("httpfilePath") String httpfilePath ,@RequestParam("oilrecordId") String oilrecordId,@RequestParam("pictype")  String pictype) throws Exception
    {

        if (file.isEmpty()) {
            return ResultUtils.fail("上传失败，请选择文件");
        }

        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String date = sdf.format(new Date());

       // String fileName = file.getOriginalFilename();
       //  String tempfilePath =filePath+date+"\\";
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
        In.close();

        if("oil".equals(pictype))
        {
            oilRecordService.updateoilRecordPhotoByOilrecordId (oilrecordId,temphttpfilePath+filename);
        }
        else if("car".equals(pictype))
        {
            oilRecordService.updatecarImageRecordPhotoByOilrecordId (oilrecordId,temphttpfilePath+filename);
        }

        oilRecordService.updateOilRecordCompleteByoilrecordId(oilrecordId);

        return ResultUtils.success("上传成功",temphttpfilePath+filename);


    }
}
