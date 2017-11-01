package com.fcc.module.shop.dao;

import com.fcc.module.shop.model.ShopImageEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Created by acer on 2017/11/1.
 */
public interface ShopImageRepository extends JpaRepository<ShopImageEntity,Integer> {
    public List<ShopImageEntity> findByShopId(Integer userId);
}
