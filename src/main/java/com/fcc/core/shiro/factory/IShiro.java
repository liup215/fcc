package com.fcc.core.shiro.factory;

import com.fcc.core.shiro.ShiroUser;
import com.fcc.module.auth.model.AuthUserEntity;
import org.apache.shiro.authc.SimpleAuthenticationInfo;

/**
 * Created by Administrator on 2017/7/7.
 */
public interface IShiro {

    /**
     * 根据用户Id获取用户
     * @param userId
     * @return
     */
    AuthUserEntity user(Integer userId);

    /**
     * 根据账号获取登录用户
     * @param username 账号
     * @return 登录用户
     */
    AuthUserEntity user(String username);

    /**
     * 根据系统用户获取Shiro的用户
     *
     * @param user 系统用户
     * @return Shiro用户
     */
    ShiroUser shiroUser(AuthUserEntity user);

    ShiroUser shiroUser(Integer userId);

    /**
     * 获取shiro的认证信息
     * @param shiroUser shiro用户
     * @param user 用户
     * @param realmName 认证
     * @return 认证信息
     */
    SimpleAuthenticationInfo info(ShiroUser shiroUser, AuthUserEntity user, String realmName);
}
