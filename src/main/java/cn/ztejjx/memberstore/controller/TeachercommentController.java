package cn.ztejjx.memberstore.controller;



import cn.ztejjx.memberstore.domain.Librarylist;
import cn.ztejjx.memberstore.domain.mysql.Teachercomment;
import cn.ztejjx.memberstore.domain.mysql.TeachercommentItem;
import cn.ztejjx.memberstore.domain.mysql.memberInfo;
import cn.ztejjx.memberstore.domain.redis.shoppingCart;
import cn.ztejjx.memberstore.service.TeachercommentItemService;
import cn.ztejjx.memberstore.service.TeachercommentService;
import cn.ztejjx.memberstore.utils.ResultUtils;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("/api/v1/pri/teachercomment")
@Transactional
public class TeachercommentController {


    @Autowired
    private TeachercommentItemService teachercommentItemService;

    @Autowired
    private TeachercommentService TeachercommentService;




    @RequestMapping( "/saveteachercomment")
    public ResultUtils saveteachercomment(  String librarylistArr,String dept,String id,String teacherName,String subject,String calsumscore,String createdBy,String createdById)
    {



        int count =  TeachercommentService.validaterecord(id,createdById,subject);

        if(count>0)
        {
            return ResultUtils.success("请勿重复提交",count);
        }
        else
        {
            Teachercomment teachercomment= new Teachercomment();
            teachercomment.setTeachername(teacherName);
            teachercomment.setTeacherid(Integer.valueOf(id));
            teachercomment.setDept(dept);
            teachercomment.setScore(Long.valueOf(calsumscore));
            teachercomment.setSubject(subject);
            teachercomment.setCreatedDate(new Date());
            teachercomment.setEnabledFlag(1);
            teachercomment.setCreatedBy(createdBy);
            teachercomment.setCreatedById(createdById);
            teachercomment.setTeachercommentId(UUID.randomUUID().toString().replace("-", ""));

            String  teachercommentId = TeachercommentService.saveTeachercomment(teachercomment);
            List<TeachercommentItem> TeachercommentItemlist = new ArrayList<>();
            JSONArray JsonArray = JSONArray.parseArray(librarylistArr);
            for(int i = 0; i< JsonArray.size(); i++) {
                //保存明细
                Librarylist library = (Librarylist) JSONObject.toJavaObject(JsonArray.getJSONObject(i), Librarylist.class);
                TeachercommentItem teachercommentItem=new TeachercommentItem();
                teachercommentItem.setTeachercommentItemid(UUID.randomUUID().toString().replace("-", ""));
                teachercommentItem.setTeachercommentId(teachercommentId);
                teachercommentItem.setContent(library.getContent());
                teachercommentItem.setScore(Long.valueOf(library.getScore()));
                teachercommentItem.setEnabledFlag(1);
                teachercommentItem.setCreatedDate(new Date());
                TeachercommentItemlist.add(teachercommentItem);
            }


            teachercommentItemService.savebatchTeachercommentItemService(TeachercommentItemlist);
            return ResultUtils.success("保存成功",null);

        }




    }


}
