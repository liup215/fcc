package com.fcc.module.auth.service;

import com.fcc.common.constant.tip.Tip;

/**
 * Created by acer on 2017/11/24.
 */
public interface IAuthService {
    public Tip register(String username, String password, String passwordConfirm);

    public Tip login(String phone, String password);

    public Tip stateLessLogin(String phone, String password);

    public Tip authCheck(String token);
}
