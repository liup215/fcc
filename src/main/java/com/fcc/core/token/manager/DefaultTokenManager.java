package com.fcc.core.token.manager;

import com.fcc.core.token.TokenModel;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * Created by acer on 2017/11/24.
 */
@Service
public class DefaultTokenManager implements TokenManager{
    public static Map<Integer,TokenModel> models = new HashMap<>();

    @Override
    public TokenModel createToken(Integer userId) {
        //使用uuid作为源token
        String token = UUID.randomUUID().toString().replace("-", "");
        TokenModel model = new TokenModel(userId, token);
        models.put(userId,model);
        return model;
    }

    @Override
    public boolean checkToken(TokenModel model) {
        if (model == null) {
            return false;
        }
        TokenModel tokenModel = models.get(model.getUserId());

        if(tokenModel == null){
            return false;
        }

        String token = tokenModel.getToken();

        if (token == null || !token.equals(model.getToken())) {
            return false;
        }
        return true;
    }

    @Override
    public TokenModel getToken(String authentication) {
        if (authentication == null || authentication.length() == 0) {
            return null;
        }
        String[] param = authentication.split("_");
        if (param.length != 2) {
            return null;
        }
        //使用userId和源token简单拼接成的token，可以增加加密措施
        Integer userId = Integer.parseInt(param[0]);
        String token = param[1];
        return new TokenModel(userId, token);
    }

    @Override
    public void deleteToken(Integer userId) {
        models.remove(userId);
    }
}
