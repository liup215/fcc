package com.fcc.module.shop.service;

import com.fcc.module.shop.model.ShopCommentEntity;
import com.fcc.module.shop.model.ShopContentEntity;
import com.fcc.module.shop.model.ShopImageEntity;

import java.util.List;

/**
 * Created by acer on 2017/11/1.
 */
public interface IShopService {

    public List getShop();
    public List<ShopImageEntity> getShopImage(Integer shopId);

    public ShopContentEntity getShopById(Integer shopId);

    public List<ShopCommentEntity> getComment(Integer shopId);

    public List<ShopContentEntity> getShop(Integer page, Integer pageSize);
}
