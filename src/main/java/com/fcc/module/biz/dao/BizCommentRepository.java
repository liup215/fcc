package com.fcc.module.biz.dao;

import com.fcc.module.biz.model.BizCommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by acer on 2017/11/3.
 */
public interface BizCommentRepository extends JpaRepository<BizCommentEntity,Integer> {
   public List<BizCommentEntity> findByBizId(Integer bizId);
}
