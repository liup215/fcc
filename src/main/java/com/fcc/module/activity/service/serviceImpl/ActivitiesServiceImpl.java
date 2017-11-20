package com.fcc.module.activity.service.serviceImpl;

import com.fcc.core.support.BeanKit;
import com.fcc.core.support.DateTimeKit;
import com.fcc.module.activity.dao.ActivitieActivitieRepository;
import com.fcc.module.activity.dao.ActivitieAttendeeRepository;
import com.fcc.module.activity.model.ActivitieActivitieEntity;
import com.fcc.module.activity.model.ActivitieAttendeeEntity;
import com.fcc.module.activity.model.ActivitiesActivitiesEntity;
import com.fcc.module.activity.service.IActivitieService;
import com.fcc.module.activity.wrapper.ActivitiesWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by acer on 2017/11/13.
 */
@Service
public class ActivitiesServiceImpl implements IActivitieService {

    @Autowired
    ActivitieActivitieRepository activitieActivitieRepository;

    @Autowired
    ActivitieAttendeeRepository activitieAttendeeRepository;

    @Override
    public Map<String,Object> getActivity(Integer id) {
        ActivitieActivitieEntity activity = activitieActivitieRepository.findOne(id);
        Map<String, Object> map = BeanKit.beanToMap(activity);
        map.put("startTime", DateTimeKit.formatDateTime(activity.getStartTime()));
        return map;
    }

    @Override
    public Map<String, Object> enroll(Integer activityId, String name, String email, String tel) {
        ActivitieAttendeeEntity attendeeEntity = new ActivitieAttendeeEntity();
        attendeeEntity.setActivitieId(activityId);;
        attendeeEntity.setEmail(email);
        attendeeEntity.setName(name);
        attendeeEntity.setTel(tel);
        attendeeEntity.setTicket(0);

        activitieAttendeeRepository.save(attendeeEntity);

        Map<String,Object> map = new HashMap<>();
        map.put("code",200);
        map.put("msg","操作成功");

        return map;
    }

    @Override
    public List<Map<String,Object>> getActivities(Integer page, Integer pageSize) {
        List<Map<String,Object>> activityList = new ArrayList<>();

        Sort sort = new Sort(Sort.Direction.DESC,"id");
        Pageable pageable = new PageRequest(page,pageSize,sort);

        List<ActivitieActivitieEntity> list = activitieActivitieRepository.findAll(pageable).getContent();
        for(ActivitieActivitieEntity activity: list){
            Map<String, Object> activityi = BeanKit.beanToMap(activity);
            activityi.put("image","http://www.51fcc.com/media/" + activityi.get("img"));

            activityList.add(activityi);
        }

        return (List)(new ActivitiesWrapper(activityList)).warp();
    }
}
