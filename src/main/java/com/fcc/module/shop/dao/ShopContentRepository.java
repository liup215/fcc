package com.fcc.module.shop.dao;

import com.fcc.module.shop.model.ShopContentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by acer on 2017/11/1.
 */
public interface ShopContentRepository extends JpaRepository<ShopContentEntity,Integer> {
}
