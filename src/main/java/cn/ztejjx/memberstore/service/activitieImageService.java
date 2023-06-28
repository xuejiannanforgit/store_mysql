package cn.ztejjx.memberstore.service;

import cn.ztejjx.memberstore.domain.mysql.activitieImage;

import java.util.List;

public interface activitieImageService {

    List<activitieImage>  findactivitieImageByactivitiesId(String activitiesId);
}
