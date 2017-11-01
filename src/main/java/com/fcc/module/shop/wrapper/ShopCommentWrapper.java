package com.fcc.module.shop.wrapper;

import com.fcc.common.BaseControllerWrapper;
import com.fcc.core.support.DateTimeKit;
import com.fcc.module.auth.dao.AuthUserRepository;
import com.fcc.module.auth.model.AuthUserEntity;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

/**
 * Created by acer on 2017/11/1.
 */
public class ShopCommentWrapper extends BaseControllerWrapper {

    @Autowired
    AuthUserRepository authUserRepository;

    public ShopCommentWrapper(Object obj) {
        super(obj);
    }

    @Override
    protected void warpTheMap(Map<String, Object> map) {
        Timestamp createDate = (Timestamp) map.get("createDate");
        Timestamp editDate = (Timestamp) map.get("editDate");

        String formatCreateDate = DateTimeKit.formatDate(new Date(createDate.getTime()));
        String formatEditDate = DateTimeKit.formatDate(new Date(editDate.getTime()));

        map.put("createDate",formatCreateDate);
        map.put("editDate",formatEditDate);

        AuthUserEntity user = authUserRepository.findOne((Integer) map.get("userId"));
        map.put("user",user.getUsername());
    }
}
