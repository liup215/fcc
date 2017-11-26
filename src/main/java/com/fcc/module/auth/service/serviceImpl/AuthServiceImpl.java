package com.fcc.module.auth.service.serviceImpl;

import com.fcc.common.constant.tip.ErrorTip;
import com.fcc.common.constant.tip.SuccessTip;
import com.fcc.common.constant.tip.Tip;
import com.fcc.common.exception.BizExceptionEnum;
import com.fcc.core.log.LogManager;
import com.fcc.core.shiro.ShiroKit;
import com.fcc.core.shiro.ShiroUser;
import com.fcc.core.shiro.factory.ShiroFactory;
import com.fcc.core.support.HttpKit;
import com.fcc.core.token.TokenModel;
import com.fcc.core.token.manager.TokenManager;
import com.fcc.module.auth.dao.AuthUserRepository;
import com.fcc.module.auth.model.AuthUserEntity;
import com.fcc.module.auth.service.IAuthService;
import com.fcc.module.auth.status.AuthSuperUserType;
import com.fcc.module.auth.status.AuthUserStatus;
import com.fcc.module.auth.status.AuthUserType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by acer on 2017/11/24.
 */
@Service
public class AuthServiceImpl implements IAuthService{

    @Autowired
    AuthUserRepository authUserRepository;

    @Autowired
    private TokenManager defaultTokenManager;

    @Override
    public Tip login(String username, String password) {

        return null;
    }

    @Override
    public Tip stateLessLogin(String username, String password) {
        ShiroUser shiroUser = null;
        TokenModel model = null;

        AuthUserEntity user = authUserRepository.findByUsername(username);
        if(user == null){
            return new ErrorTip((BizExceptionEnum.USER_NOT_EXISTED));
        }
        if(!ShiroKit.md5(password,username).equals(user.getPassword())){
            return new ErrorTip(BizExceptionEnum.PWD_NOT_RIGHT);
        }
        shiroUser = ShiroFactory.me().shiroUser(user.getId());
        HttpKit.getRequest().getSession().setAttribute("shiroUser", shiroUser);

        user.setLastLogin(new Timestamp(new Date().getTime()));
        authUserRepository.save(user);
        HttpKit.getRequest().getSession().setAttribute("sessionFlag",true);

        model = defaultTokenManager.createToken(user.getId());

        return new SuccessTip(model);
    }

    @Override
    public Tip register(String username, String password, String passwordConfirm) {
        if(authUserRepository.findByUsername(username)!=null){
            return new ErrorTip(BizExceptionEnum.USER_ALREADY_REG);
        }

        if(!password.equals(passwordConfirm)){
            return new ErrorTip(BizExceptionEnum.TWO_PWD_NOT_MATCH);
        }

        AuthUserEntity user = new AuthUserEntity();
        user.setUsername(username);
        user.setEmail("");
        user.setFirstName("");
        user.setLastName("");
        user.setPassword(ShiroKit.md5(password,username));
        user.setDateJoined(new Timestamp(new Date().getTime()));
        user.setIsActive((byte) AuthUserStatus.OK.getCode());
        user.setIsStaff((byte)AuthUserType.notStuff.getCode());
        user.setIsSuperuser((byte)AuthSuperUserType.notSuperUser.getCode());


        authUserRepository.save(user);
        return new SuccessTip();
    }

    @Override
    public Tip authCheck(String authorization) {
        TokenModel model = defaultTokenManager.getToken(authorization);
        System.out.println(model);

        boolean checkToken = defaultTokenManager.checkToken(model);
        if(checkToken){
            return new SuccessTip();
        }else {
            return new ErrorTip(BizExceptionEnum.TOKEN_NOT_RIGHT);
        }
    }
}
