package com.fcc.module.biz.dao;

import com.fcc.module.biz.model.BizTypeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by acer on 2017/11/3.
 */
public interface BizTypeRepository extends JpaRepository<BizTypeEntity,Integer> {
}

