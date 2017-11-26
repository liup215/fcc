package com.fcc.core.shiro.factory;

import com.fcc.core.shiro.ShiroUser;
import com.fcc.core.util.SpringContextHolder;
import com.fcc.module.auth.dao.AuthUserRepository;
import com.fcc.module.auth.model.AuthUserEntity;
import com.fcc.module.auth.status.AuthUserStatus;
import org.apache.shiro.authc.CredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.crypto.hash.Md5Hash;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@DependsOn("springContextHolder")
@Transactional(readOnly = true)
public class ShiroFactory implements IShiro {

    @Autowired
    private AuthUserRepository userRepository;

    public static IShiro me() {

        return (SpringContextHolder.getBean(IShiro.class));
    }

    @Override
    public AuthUserEntity user(String username) {
        AuthUserEntity user = userRepository.findByUsername(username);
        // 账号不存在
        if (null == user) {
            throw new CredentialsException();
        }
        // 账号被冻结
        if (user.getIsActive() != AuthUserStatus.OK.getCode()) {
            throw new LockedAccountException();
        }
        return user;
    }

    @Override
    public AuthUserEntity user(Integer userId) {
        AuthUserEntity user = userRepository.findOne(userId);
        // 账号不存在
        if (null == user) {
            throw new CredentialsException();
        }
        // 账号被冻结
        if (user.getIsActive() != AuthUserStatus.OK.getCode()) {
            throw new LockedAccountException();
        }
        return user;
    }

    @Override
    public ShiroUser shiroUser(Integer userId) {
        AuthUserEntity user = user(userId);
        return shiroUser(user);
    }

    @Override
    public ShiroUser shiroUser(AuthUserEntity user) {
        ShiroUser shiroUser = new ShiroUser();

        BeanUtils.copyProperties(user,shiroUser);
        return shiroUser;
    }


    @Override
    public SimpleAuthenticationInfo info(ShiroUser shiroUser, AuthUserEntity user, String realmName) {
        String credentials = user.getPassword();
        // 密码加盐处理
        String source = user.getUsername();
        ByteSource credentialsSalt = new Md5Hash(source);
        return new SimpleAuthenticationInfo(shiroUser, credentials, credentialsSalt, realmName);
    }

}
