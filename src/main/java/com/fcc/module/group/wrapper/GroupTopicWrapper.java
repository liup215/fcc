package com.fcc.module.group.wrapper;

import com.fcc.common.BaseControllerWrapper;
import com.fcc.core.support.DateTimeKit;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

/**
 * Created by acer on 2017/11/13.
 */
public class GroupTopicWrapper extends BaseControllerWrapper{
    @Override
    protected void warpTheMap(Map<String, Object> map) {
        map.put("createTime", DateTimeKit.formatDateTime(new Date(((Timestamp)map.get("createAt")).getTime())));
        map.put("updateTime", DateTimeKit.formatDateTime(new Date(((Timestamp)map.get("updateAt")).getTime())));
    }

    public GroupTopicWrapper(Object obj) {
        super(obj);
    }
}
