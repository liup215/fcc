package com.fcc.module.group.service.serviceImpl;

import com.fcc.core.support.BeanKit;
import com.fcc.core.support.DateTimeKit;
import com.fcc.module.auth.dao.AuthUserRepository;
import com.fcc.module.auth.model.AuthUserEntity;
import com.fcc.module.group.dao.GroupCommentRepository;
import com.fcc.module.group.dao.GroupGroupRepository;
import com.fcc.module.group.dao.GroupTopicRepository;
import com.fcc.module.group.model.GroupGroupEntity;
import com.fcc.module.group.model.GroupTopicEntity;
import com.fcc.module.group.service.IGroupService;
import com.fcc.module.group.wrapper.GroupGroupWrapper;
import com.fcc.module.group.wrapper.GroupTopicWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by acer on 2017/11/13.
 */
@Service
public class GroupServiceImpl implements IGroupService{

    @Autowired
    GroupGroupRepository groupGroupRepository;

    @Autowired
    GroupTopicRepository groupTopicRepository;

    @Autowired
    GroupCommentRepository groupCommentRepository;

    @Autowired
    AuthUserRepository authUserRepository;

    @Override
    public List<Map<String, Object>> getTopics(Integer groupId,Integer page, Integer pageSize) {
        List<Map<String,Object>> topicList = new ArrayList<>();

        Sort sort = new Sort(Sort.Direction.DESC,"id");
        Pageable pageable = new PageRequest(page,pageSize,sort);

        List<GroupTopicEntity> topics = groupTopicRepository.findByGroupId(groupId,pageable);

        for(GroupTopicEntity topic: topics){
            Map<String,Object> topici = BeanKit.beanToMap(topic);
            topici.put("author",authUserRepository.findOne(topic.getAuthorId()).getUsername());
            int replyCount = groupCommentRepository.findByTopicId(topic.getId()).size();

            System.out.println(groupCommentRepository.count());
            topici.put("reply", replyCount);
            topicList.add(topici);
        }

        return (List)(new GroupTopicWrapper(topicList)).warp();
    }

    @Override
    public Map<String, Object> getGroupDetail(Integer groupId) {
        GroupGroupEntity group = groupGroupRepository.findOne(groupId);
        Map<String,Object> map = BeanKit.beanToMap(group);
        map.put("image","http://www.51fcc.com/media/" + group.getImg());
        map.put("createTime", DateTimeKit.formatDateTime(new Date(((Timestamp)map.get("createAt")).getTime())));
        map.put("updateTime", DateTimeKit.formatDateTime(new Date(((Timestamp)map.get("updateAt")).getTime())));

        map.put("owner",authUserRepository.findOne(group.getOwnerId()).getUsername());
        return map;
    }

    @Override
    public List<Map<String, Object>> getGroups(Integer page, Integer pageSize) {
        List<Map<String, Object>> groupList = new ArrayList<>();

        Sort sort = new Sort(Sort.Direction.DESC,"id");
        Pageable pageable = new PageRequest(page,pageSize,sort);

        List<GroupGroupEntity> groups = groupGroupRepository.findAll(pageable).getContent();
        for(GroupGroupEntity group : groups){
            Map<String,Object> groupi = BeanKit.beanToMap(group);
            AuthUserEntity user = authUserRepository.findOne(group.getOwnerId());
            groupi.put("owner",user.getUsername());

            groupList.add(groupi);
        }

        return (List) (new GroupGroupWrapper(groupList)).warp();
    }
}
