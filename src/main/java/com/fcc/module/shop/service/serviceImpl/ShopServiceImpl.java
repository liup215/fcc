package com.fcc.module.shop.service.serviceImpl;

import com.fcc.core.support.BeanKit;
import com.fcc.module.shop.dao.ShopCommentRepository;
import com.fcc.module.shop.dao.ShopContentRepository;
import com.fcc.module.shop.dao.ShopImageRepository;
import com.fcc.module.shop.model.ShopCommentEntity;
import com.fcc.module.shop.model.ShopContentEntity;
import com.fcc.module.shop.model.ShopImageEntity;
import com.fcc.module.shop.service.IShopService;
import com.fcc.module.shop.wrapper.ShopCommentWrapper;
import com.fcc.module.shop.wrapper.ShopContentWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by acer on 2017/11/1.
 */
@Service
public class ShopServiceImpl implements IShopService{

    @Autowired
    ShopContentRepository shopContentRepository;

    @Autowired
    ShopImageRepository shopImageRepository;

    @Autowired
    ShopCommentRepository shopCommentRepository;

    @Override
    public List getShop() {
        return getShop(0,30);
    }

    @Override
    public List<ShopContentEntity> getShop(Integer page, Integer pageSize) {
        List<Map<String,Object>> shopList = new ArrayList<>();
        Sort sort = new Sort(Sort.Direction.fromStringOrNull(Sort.Direction.DESC.name()),"id");
        Pageable pageAble = new PageRequest(page,pageSize,sort);

        List<ShopContentEntity> shops = shopContentRepository.findAll(pageAble).getContent();

        for(ShopContentEntity shop:shops){
            Map<String,Object> shopi = new HashMap<>();
            shopi = BeanKit.beanToMap(shop);
            List<ShopImageEntity> images = shopImageRepository.findByShopId(shop.getId());
            List<String> imgs = new ArrayList<>();
            for(ShopImageEntity image:images){
                imgs.add("http://www.51fcc.com/media/"+image.getUrl());
            }
            shopi.put("images",imgs);

            shopList.add(shopi);
        }
        return (List)(new ShopContentWrapper(shopList)).warp();
    }

    @Override
    public List<ShopImageEntity> getShopImage(Integer shopId) {
        List<ShopImageEntity> shopImages = shopImageRepository.findByShopId(shopId);
        return shopImages;
    }

    @Override
    public ShopContentEntity getShopById(Integer shopId) {
        ShopContentEntity shop = shopContentRepository.findOne(shopId);
        return shop;
    }

    @Override
    public List<ShopCommentEntity> getComment(Integer shopId) {
        List<ShopCommentEntity> comments = shopCommentRepository.findByShopId(shopId);
        List<Map<String,Object>> list = new ArrayList<>();
        for(ShopCommentEntity comment:comments){
            Map<String,Object> map = BeanKit.beanToMap(comment);
            list.add(map);
        }
        return (List)(new ShopCommentWrapper(list)).warp();
    }
}
