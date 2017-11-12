package com.fcc.module.biz.service;

import com.fcc.module.biz.model.BizCommentEntity;
import com.fcc.module.biz.model.BizContentEntity;
import com.fcc.module.biz.model.BizImageEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by acer on 2017/11/3.
 */
public interface IBizService {
   public List<BizContentEntity> getBiz(Integer page, Integer pageSize);

   public Map<String,Object> getDetail(Integer bizId);

   public List<BizImageEntity> getBizImage(Integer bizId);

   public List<BizCommentEntity> getComments(Integer bizId);
}
