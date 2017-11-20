package com.fcc.module.group.service;

import java.util.List;
import java.util.Map;

/**
 * Created by acer on 2017/11/13.
 */
public interface IGroupService {
    public List<Map<String,Object>> getGroups(Integer page, Integer pageSize);

    public Map<String,Object> getGroupDetail(Integer groupId);

    public List<Map<String,Object>> getTopics(Integer groupId,Integer page, Integer pageSize);
}
