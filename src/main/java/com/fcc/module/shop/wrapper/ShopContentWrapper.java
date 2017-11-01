package com.fcc.module.shop.wrapper;

import com.fcc.common.BaseControllerWrapper;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

/**
 * Created by acer on 2017/11/1.
 */
public class ShopContentWrapper extends BaseControllerWrapper {

    public ShopContentWrapper(Object obj) {
        super(obj);
    }

    @Override
    protected void warpTheMap(Map<String, Object> map) {
        Timestamp createDate = (Timestamp) map.get("createDate");
        Timestamp editDate = (Timestamp) map.get("editDate");

        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String formatCreateDate = formatter.format(new Date(createDate.getTime()));
        String formatEditDate = formatter.format(new Date(editDate.getTime()));

        map.put("createDate",formatCreateDate);
        map.put("editDate",formatEditDate);
    }
}
