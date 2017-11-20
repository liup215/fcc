package com.fcc.module.group.controller;

import com.fcc.common.constant.tip.SuccessTip;
import com.fcc.common.constant.tip.Tip;
import com.fcc.module.group.service.IGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by acer on 2017/11/13.
 */
@Controller
@RequestMapping("/group")
public class GroupController {

    @Autowired
    IGroupService groupService;

    @RequestMapping("/list")
    @ResponseBody
    public Tip getGroups(@RequestParam Integer page,@RequestParam Integer pageSize){
        List<Map<String,Object>> groups = groupService.getGroups(page,pageSize);
        return new SuccessTip(groups);
    }

    @RequestMapping("/detail")
    @ResponseBody
    public Tip getDetail(@RequestParam Integer groupId){
        Map<String,Object> map = groupService.getGroupDetail(groupId);
        return new SuccessTip(map);
    }

    @RequestMapping("/topic")
    @ResponseBody
    public Tip getTopic(@RequestParam Integer groupId,@RequestParam Integer page,@RequestParam Integer pageSize){
        List<Map<String,Object>> topics = groupService.getTopics(groupId,page,pageSize);
        return new SuccessTip(topics);
    }
}
