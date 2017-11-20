package com.fcc.module.group.dao;

import com.fcc.module.group.model.GroupTopicEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by acer on 2017/11/13.
 */
public interface GroupTopicRepository extends JpaRepository<GroupTopicEntity,Integer> {
    public List<GroupTopicEntity> findByGroupId(Integer groupId, Pageable page);
}
