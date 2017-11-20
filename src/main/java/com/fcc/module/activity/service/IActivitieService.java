package com.fcc.module.activity.service;

import com.fcc.module.activity.model.ActivitieActivitieEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by acer on 2017/11/13.
 */
public interface IActivitieService {

    public List<Map<String,Object>> getActivities(Integer page, Integer pageSize);

    public Map<String,Object> getActivity(Integer id);

    public Map<String,Object> enroll(Integer activityId, String name, String email, String tel);
}
