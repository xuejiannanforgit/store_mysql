package cn.ztejjx.memberstore.service;

import cn.ztejjx.memberstore.domain.mysql.configActivitie;
import cn.ztejjx.memberstore.utils.ResultUtils;

import java.util.List;

public interface configActivitieService {
    List<configActivitie> findConfigActivitieList();
    int  addzan(String ActivitiesId);

    configActivitie findConfigActivitieListbyId(String activitiesId);



}
