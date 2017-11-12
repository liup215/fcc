package com.fcc.module.biz.service.serviceImpl;

import com.fcc.core.support.BeanKit;
import com.fcc.module.biz.dao.*;
import com.fcc.module.biz.model.*;
import com.fcc.module.biz.service.IBizService;
import com.fcc.module.biz.wrapper.BizCommentWrapper;
import com.fcc.module.biz.wrapper.BizContentWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by acer on 2017/11/3.
 */
@Service
public class BizServiceImpl implements IBizService{

    @Autowired
    BizContentRepository bizContentRepository;

    @Autowired
    BizTypeRepository bizTypeRepository;

    @Autowired
    BizTypeRelationRepository bizTypeRelationRepository;

    @Autowired
    BizImageRepository bizImageRepository;

    @Autowired
    BizCommentRepository bizCommentRepository;

    @Override
    public Map<String, Object> getDetail(Integer bizId) {
        BizContentEntity biz = bizContentRepository.findOne(bizId);
        Map<String,Object> map = BeanKit.beanToMap(biz);
        List<BizTypeRelationEntity> relations = bizTypeRelationRepository.findByBizId(biz.getId());
        List<String> types = new ArrayList<>();
        for(BizTypeRelationEntity relation: relations){
            BizTypeEntity type = bizTypeRepository.findOne(relation.getTypeId());
            types.add(type.getValue());
        }

        map.put("type",types);

        biz.setView(biz.getView() + 1);
        bizContentRepository.save(biz);
        return (Map)(new BizContentWrapper(map)).warp();
    }

    @Override
    public List<BizContentEntity> getBiz(Integer page, Integer pageSize) {
        Sort sort = new Sort(Sort.Direction.DESC,"id");
        Pageable pageable = new PageRequest(page,pageSize,sort);

        List<BizContentEntity> bizs = bizContentRepository.findAll(pageable).getContent();
        List<Map<String,Object>> list = new ArrayList<>();
        for(BizContentEntity biz:bizs){
            Map<String,Object> map = BeanKit.beanToMap(biz);
            list.add(map);
        }

        return (List) (new BizContentWrapper(list)).warp();
    }

    @Override
    public List<BizCommentEntity> getComments(Integer bizId) {
        List<BizCommentEntity> comments = bizCommentRepository.findByBizId(bizId);
        return (List)(new BizCommentWrapper(comments)).warp();
    }

    @Override
    public List<BizImageEntity> getBizImage(Integer bizId) {
        List<BizImageEntity> bizImages = bizImageRepository.findByBizId(24);
        return bizImages;
    }
}
