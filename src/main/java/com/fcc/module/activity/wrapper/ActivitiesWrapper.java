package com.fcc.module.activity.wrapper;

import com.fcc.common.BaseControllerWrapper;
import com.fcc.core.support.DateTimeKit;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

/**
 * Created by acer on 2017/11/13.
 */
public class ActivitiesWrapper extends BaseControllerWrapper {
    @Override
    protected void warpTheMap(Map<String, Object> map) {
        Timestamp startTime = (Timestamp) map.get("startTime");
        Timestamp endTime = (Timestamp) map.get("endTime");
        Timestamp createAt = (Timestamp) map.get("createAt");
        Timestamp updateAt = (Timestamp) map.get("updateAt");

        String formatStartTime = DateTimeKit.formatDate(new Date(startTime.getTime()));
        String formatEndTime = DateTimeKit.formatDate(new Date(endTime.getTime()));
        String formatCreateTime = DateTimeKit.formatDate(new Date(createAt.getTime()));
        String formatUpdateTime = DateTimeKit.formatDate(new Date(updateAt.getTime()));

        map.put("startTime",formatStartTime);
        map.put("endTime",formatEndTime);
        map.put("createTime",formatCreateTime);
        map.put("updateTime",formatUpdateTime);
    }

    public ActivitiesWrapper(Object obj) {
        super(obj);
    }
}
