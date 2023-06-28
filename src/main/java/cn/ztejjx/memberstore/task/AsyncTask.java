package cn.ztejjx.memberstore.task;
import cn.ztejjx.memberstore.domain.mysql.activitieRecord;
import cn.ztejjx.memberstore.domain.mysql.configActivitie;
import cn.ztejjx.memberstore.domain.mysql.memberInfo;
import cn.ztejjx.memberstore.domain.mysql.memberIntegral;
import cn.ztejjx.memberstore.utils.EncrypDES;
import cn.ztejjx.memberstore.utils.QRCodeUtil;
import cn.ztejjx.memberstore.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Component
@Async
public class AsyncTask {


    @Autowired
    private QRCodeUtil qrCodeUtil;

    @Autowired
    private EncrypDES encrypDES;

    @Autowired
    private cn.ztejjx.memberstore.service.memberIntegralService memberIntegralService;

    @Autowired
    private RedisUtils redisUtil;

    @Autowired
    private cn.ztejjx.memberstore.service.configActivitieService configActivitieService;

    @Autowired
    private cn.ztejjx.memberstore.service.activitieRecordService activitieRecordService;

    @Autowired
    private cn.ztejjx.memberstore.service.voteDetailService voteDetailService;

    @Autowired
    private cn.ztejjx.memberstore.service.memberInfoService memberInfoService;


    public void  updateMemberInfoVoteNum(String employeeId)
    {

        int count = voteDetailService.findVoteDetailCountByEmployeeId(employeeId);
        memberInfoService.updateMemberInfoVoteNum(employeeId,count);
//        if(count>0)
//        {
//            memberInfoService.updateMemberInfoVoteNum(employeeId,count);
////            redisUtil.hset("findVoteDetailCountByEmployeeId",employeeId,count);
////            List<memberInfo> memberInfoList = memberInfoService.findmemberInfoByVoteNum();
////            redisUtil.set("findmemberInfoByVoteNum",memberInfoList,10000);
//        }
    }




    public void addzanIntegral (configActivitie configActivitie,String shareopenId,String openId,String nickName,String avatarurl,String memberPhone)
    {

        System.out.println("保存积分记录addzanIntegral=");
        int sharecount = activitieRecordService.validateShareCount(shareopenId, configActivitie.getActivitiesId());

        System.out.println("sharecount="+sharecount);
        System.out.println("configActivitie.getShareZannum()="+configActivitie.getShareZannum());
        if(sharecount<=configActivitie.getShareZannum())
        {
            int count = activitieRecordService.validateCount(openId,shareopenId,configActivitie.getActivitiesId());

            System.out.println("count="+count);
            if(count==0)
            {
                activitieRecord activitieRecord =new activitieRecord();
                activitieRecord.setActivitieRecordid(UUID.randomUUID().toString().replace("-", ""));
                activitieRecord.setShareOpenid(shareopenId);
                activitieRecord.setActivitiesId(configActivitie.getActivitiesId());
                activitieRecord.setOpenid(openId);
                activitieRecord.setNickName(nickName);
                activitieRecord.setAvatarurl(avatarurl);
                activitieRecord.setEnabledFlag(1);
                activitieRecord.setCreatedDate(new Date());
                activitieRecordService.saveactivitieRecord(activitieRecord);
                //加积分
                List<memberInfo> list = memberInfoService.findMemberInfoBymemberPhone(memberPhone);
                if(list.size()!=0)
                {
                    memberInfo memberInfo = list.get(0);
                    memberIntegral memberIntegral=new memberIntegral();
                    memberIntegral.setIntegralId(UUID.randomUUID().toString().replace("-", ""));
                    memberIntegral.setIntegralType("积分增加");
                    memberIntegral.setIntegralNum(new BigDecimal(1) );  //积分抵扣数量
                    memberIntegral.setMemberId(memberInfo.getMemberId());
                    memberIntegral.setMemberName(memberInfo.getMemberName());
                    memberIntegral.setMemberPhone(memberInfo.getMemberPhone());
                    memberIntegral.setAddintegralReason("活动分享");
                    memberIntegral.setApplicationItems(configActivitie.getActivitiesTitle());
                    memberIntegral.setOrderId(null);
                    memberIntegral.setEnabledFlag(1);
                    memberIntegral.setCreatedDate(new Date());
                    memberIntegral.setLastUpdatedBy(openId);
                    saveMemberIntegral(memberIntegral);
                }
            }
        }
    }



    public void saveMemberIntegral(memberIntegral memberIntegral) {
        //保存积分记录
        int count = memberIntegralService.saveMemberIntegral(memberIntegral);
        if(count>0)
        {
            //计算会员积分
            int integral =  memberIntegralService.countMemberIntegral(memberIntegral.getMemberId());

            //更新会员积分
            memberInfoService.updateMemberIntegral(memberIntegral.getMemberId(),integral);
        }
        else
        {
            redisUtil.hset("memberIntegral",memberIntegral.getMemberId(),memberIntegral.toString());
        }

    }


    public void createErcode(String verificationCode,String logoPath,String destPath)
    {

        String ercodevalue = null;
        try {
            ercodevalue   = encrypDES.encrypt(verificationCode);
            // 存放在二维码中的内容
            String text = ercodevalue;
            //生成二维码
            QRCodeUtil.encode(text,logoPath,destPath,true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
