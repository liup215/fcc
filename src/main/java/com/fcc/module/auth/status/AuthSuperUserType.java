package com.fcc.module.auth.status;

/**
 * Created by acer on 2017/11/24.
 */
public enum AuthSuperUserType {
    SuperUser(1, "超级用户"), notSuperUser(0, "普通用户");

    int code;
    String message;

    AuthSuperUserType(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static String valueOf(Integer value) {
        if (value == null) {
            return "";
        } else {
            for (AuthSuperUserType ms : AuthSuperUserType.values()) {
                if (ms.getCode() == value) {
                    return ms.getMessage();
                }
            }
            return "";
        }
    }
}
