package com.fcc.module.biz.controller;

import com.fcc.common.constant.tip.SuccessTip;
import com.fcc.common.constant.tip.Tip;
import com.fcc.module.biz.model.BizCommentEntity;
import com.fcc.module.biz.model.BizContentEntity;
import com.fcc.module.biz.model.BizImageEntity;
import com.fcc.module.biz.service.IBizService;
import javafx.scene.layout.TilePane;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * Created by acer on 2017/11/3.
 */
@Controller
@RequestMapping("/biz")
public class BizController {

    @Autowired
    IBizService bizService;

    @RequestMapping("/list")
    @ResponseBody
    public Tip getBiz(@RequestParam("page") Integer page, @RequestParam Integer pageSize){
        List<BizContentEntity> list = bizService.getBiz(page,pageSize);
        return new SuccessTip(list);
    }

    @RequestMapping("/detail")
    @ResponseBody
    public Tip getDetail(@RequestParam Integer bizId){
        Map<String,Object> biz = bizService.getDetail(bizId);
        return new SuccessTip(biz);
    }

    @RequestMapping("/bizImage")
    @ResponseBody
    public Tip getBizImage(@RequestParam Integer bizId){
        List<BizImageEntity> images = bizService.getBizImage(bizId);
        return new SuccessTip(images);
    }

    @RequestMapping("/comment")
    @ResponseBody
    public Tip getComments(@RequestParam Integer bizId){
        List<BizCommentEntity> comments = bizService.getComments(bizId);
        return new SuccessTip(comments);
    }
}
