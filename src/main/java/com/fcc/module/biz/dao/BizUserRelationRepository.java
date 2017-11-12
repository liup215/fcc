package com.fcc.module.biz.dao;

import com.fcc.module.biz.model.BizUserRelationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by acer on 2017/11/3.
 */
public interface BizUserRelationRepository extends JpaRepository<BizUserRelationEntity,Integer> {
}
