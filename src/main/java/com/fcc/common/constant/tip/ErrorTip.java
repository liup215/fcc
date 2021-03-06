package com.fcc.common.constant.tip;


import com.fcc.common.exception.BizExceptionEnum;

/**
 * Created by acer on 2017/7/8.
 */
public class ErrorTip extends Tip{
    public ErrorTip(int code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    public ErrorTip(BizExceptionEnum bizExceptionEnum) {
        this.code = bizExceptionEnum.getCode();
        this.message = bizExceptionEnum.getMessage();
    }
}
