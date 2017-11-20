package com.fcc.module.group.wrapper;

import com.fcc.common.BaseControllerWrapper;
import com.fcc.core.support.DateTimeKit;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

/**
 * Created by acer on 2017/11/13.
 */
public class GroupGroupWrapper extends BaseControllerWrapper {
    @Override
    protected void warpTheMap(Map<String, Object> map) {
        map.put("image","http://www.51fcc.com/media/" + map.get("img"));
        Timestamp createAt = (Timestamp) map.get("createAt");
        Timestamp updateAt = (Timestamp) map.get("updateAt");

        String formatCreateAt = DateTimeKit.formatDateTime(new Date(createAt.getTime()));
        String formatUpdateAt = DateTimeKit.formatDateTime(new Date(updateAt.getTime()));

        map.put("createTime",formatCreateAt);
        map.put("updateTime",formatUpdateAt);
    }

    public GroupGroupWrapper(Object obj) {
        super(obj);
    }
}
