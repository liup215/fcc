package com.fcc.core.shiro;

import com.fcc.core.shiro.factory.IShiro;
import com.fcc.core.shiro.factory.ShiroFactory;
import com.fcc.module.auth.model.AuthUserEntity;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Administrator on 2017/7/7.
 */
public class ShiroDBRealm extends AuthorizingRealm {
    /**
     * 登录认证
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authcToken)
            throws AuthenticationException {
        IShiro shiroFactory = ShiroFactory.me();
        if(authcToken instanceof UsernamePasswordToken){
            UsernamePasswordToken token = (UsernamePasswordToken) authcToken;
            AuthUserEntity user = shiroFactory.user(token.getUsername());
            ShiroUser shiroUser = shiroFactory.shiroUser(user);
            SimpleAuthenticationInfo info = shiroFactory.info(shiroUser, user, super.getName());
            return info;
        }

        return null;
    }

    /**
     * 权限认证
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        IShiro shiroFactory = ShiroFactory.me();
        ShiroUser shiroUser = (ShiroUser) principals.getPrimaryPrincipal();
//        List<Integer> roleList = shiroUser.getRoleList();
        List<Integer> roleList = null;

        Set<String> permissionSet = new HashSet<>();
        Set<String> roleNameSet = new HashSet<>();

//        for (Integer roleId : roleList) {
//            List<String> permissions = shiroFactory.findPermissionsByRoleId(roleId);
//            if (permissions != null) {
//                for (String permission : permissions) {
//                    if (ToolUtil.isNotEmpty(permission)) {
//                        permissionSet.add(permission);
//                    }
//                }
//            }
//            String roleName = shiroFactory.findRoleNameByRoleId(roleId);
//            roleNameSet.add(roleName);
//        }
//
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.addStringPermissions(permissionSet);
        info.addRoles(roleNameSet);
        return info;
    }

    /**
     * 设置认证加密方式
     */
    @Override
    public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
        HashedCredentialsMatcher md5CredentialsMatcher = new HashedCredentialsMatcher();
        md5CredentialsMatcher.setHashAlgorithmName(ShiroKit.hashAlgorithmName);
        md5CredentialsMatcher.setHashIterations(ShiroKit.hashIterations);
        super.setCredentialsMatcher(md5CredentialsMatcher);
    }
}
