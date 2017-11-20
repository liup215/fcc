package com.fcc.module.activity.controller;

import com.fcc.common.constant.tip.SuccessTip;
import com.fcc.common.constant.tip.Tip;
import com.fcc.module.activity.model.ActivitieActivitieEntity;
import com.fcc.module.activity.service.IActivitieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by acer on 2017/11/13.
 */
@Controller
@RequestMapping("/activity")
public class ActivitieController {

    @Autowired
    IActivitieService activitieService;

    @RequestMapping("/list")
    @ResponseBody
    public Tip getActivity(@RequestParam Integer page,@RequestParam Integer pageSize){
        List<Map<String,Object>> list = activitieService.getActivities(page,pageSize);
        return new SuccessTip(list);
    }

    @RequestMapping("/detail")
    @ResponseBody
    public Tip getDetail(@RequestParam Integer id){
        Map<String,Object> activity = activitieService.getActivity(id);
        return new SuccessTip(activity);
    }

    @RequestMapping(value="/enroll-{activityId}",method = RequestMethod.POST)
    @ResponseBody
    public Tip enroll(@PathVariable Integer activityId,@RequestParam String name,@RequestParam String email, @RequestParam String tel){
        Map<String,Object> enroll = activitieService.enroll(activityId,name,email,tel);
        return new SuccessTip(enroll);
    }
}
