package com.fcc.module.biz.wrapper;

import com.fcc.common.BaseControllerWrapper;
import com.fcc.core.support.DateTime;
import com.fcc.core.support.DateTimeKit;
import com.fcc.core.util.SpringContextHolder;
import com.fcc.module.auth.dao.AuthUserRepository;
import com.fcc.module.auth.model.AuthUserEntity;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

/**
 * Created by acer on 2017/11/3.
 */
public class BizContentWrapper extends BaseControllerWrapper {

    AuthUserRepository authUserRepository = SpringContextHolder.getBean(AuthUserRepository.class);

    public BizContentWrapper(Object obj) {
        super(obj);
    }

    @Override
    protected void warpTheMap(Map<String, Object> map) {
        Integer userId = (Integer) map.get("userId");
        AuthUserEntity user = authUserRepository.findOne(userId);

        map.put("user",user.getUsername());

        Timestamp createDate = (Timestamp) map.get("createDate");
        Timestamp editDate = (Timestamp) map.get("editDate");
        Timestamp releaseDate = (Timestamp) map.get("releaseDate");

        String formatCreateDate = DateTimeKit.formatDate(new Date(createDate.getTime()));
        String formateEditDate = DateTimeKit.formatDate(new Date(editDate.getTime()));
        String formateReleaseDate = DateTimeKit.formatDate(new Date(releaseDate.getTime()));

        map.put("createDate",formatCreateDate);
        map.put("editDate",formateEditDate);
        map.put("releaseDate",formateReleaseDate);
    }
}
