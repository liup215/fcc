package com.fcc.module.shop.controller;

import com.fcc.common.constant.tip.SuccessTip;
import com.fcc.common.constant.tip.Tip;
import com.fcc.core.support.BeanKit;
import com.fcc.module.shop.model.ShopCommentEntity;
import com.fcc.module.shop.model.ShopContentEntity;
import com.fcc.module.shop.model.ShopImageEntity;
import com.fcc.module.shop.service.IShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by acer on 2017/11/1.
 */

@Controller
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    IShopService shopService;

    @RequestMapping("/list")
    @ResponseBody
    public Tip shopList(){
        List<ShopContentEntity> list = shopService.getShop();
        return new SuccessTip(list);
    }

    @RequestMapping("/shopImages")
    @ResponseBody
    public Tip shopImage(@RequestParam("shopId") Integer shopId){

        List<ShopImageEntity> shopImages = shopService.getShopImage(shopId);
        return new SuccessTip(shopImages);
    }

    @RequestMapping("/detail")
    @ResponseBody
    public Tip getShopDetail(@RequestParam("shopId") Integer shopId){
        ShopContentEntity shop = shopService.getShopById(shopId);
        return new SuccessTip(shop);
    }

    @RequestMapping("/comment")
    @ResponseBody
    public Tip getComment(@RequestParam("shopId") Integer shopId){
        List<ShopCommentEntity> comments = shopService.getComment(shopId);
        return new SuccessTip(comments);
    }
}
