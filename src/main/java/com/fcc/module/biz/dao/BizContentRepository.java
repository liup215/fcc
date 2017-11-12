package com.fcc.module.biz.dao;

import com.fcc.module.biz.model.BizContentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by acer on 2017/11/3.
 */
public interface BizContentRepository extends JpaRepository<BizContentEntity,Integer> {
}
