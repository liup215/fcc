package com.fcc.module.biz.dao;

import com.fcc.module.biz.model.BizImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by acer on 2017/11/3.
 */
public interface BizImageRepository extends JpaRepository<BizImageEntity,Integer> {
   public List<BizImageEntity> findByBizId(Integer bizId);
}
