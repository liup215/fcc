package com.fcc.common.constant.tip;

import com.fcc.common.exception.BizExceptionEnum;

/**
 * Created by Administrator on 2017/7/13.
 */
public class SuccessTip extends Tip{

    public SuccessTip() {
        super();
        code = 200;
        message = "操作成功！！！";
    }

    public SuccessTip(Object data){
        super();
        code = 200;
        message = "操作成功！！！";
        this.data = data;
    }

    public SuccessTip(int code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    public SuccessTip(int code, String message,Object data) {
        super();
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public SuccessTip(BizExceptionEnum bizExceptionEnum) {
        this.code = bizExceptionEnum.getCode();
        this.message = bizExceptionEnum.getMessage();
    }
}
