package com.fcc.module.group.dao;

import com.fcc.module.group.model.GroupCommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by acer on 2017/11/13.
 */
public interface GroupCommentRepository extends JpaRepository<GroupCommentEntity,Integer> {
    public List<GroupCommentEntity> findByTopicId(int id);
}
