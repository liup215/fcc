package com.fcc.module.shop.dao;

import com.fcc.module.shop.model.ShopCommentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by acer on 2017/11/1.
 */
public interface ShopCommentRepository extends JpaRepository<ShopCommentEntity,Integer> {

    public List<ShopCommentEntity> findByShopId(Integer shopId);
}
