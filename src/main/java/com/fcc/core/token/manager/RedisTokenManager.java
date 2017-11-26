package com.fcc.core.token.manager;

import com.fcc.core.token.TokenModel;
import com.fcc.core.token.config.AuthConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/8/28.
 */
@Service
public class RedisTokenManager extends DefaultTokenManager{
    private RedisTemplate redis;

    @Autowired
    public void setRedis(RedisTemplate redisTemplate) {
        this.redis = redisTemplate;
        //泛型设置成Long后必须更改对应的序列化方案
        redis.setKeySerializer(new JdkSerializationRedisSerializer());
    }

    public TokenModel createToken(Integer userId) {
        //使用uuid作为源token
        String token = UUID.randomUUID().toString().replace("-", "");
        TokenModel model = new TokenModel(userId, token);
        //存储到redis并设置过期时间
        redis.boundValueOps(userId).set(token, AuthConstants.TOKEN_EXPIRES_HOUR, TimeUnit.HOURS);
        return model;
    }


    @Override
    public boolean checkToken(TokenModel model) {
        if (model == null) {
            return false;
        }
        String token = (String)(redis.boundValueOps(model.getUserId()).get());
        if (token == null || !token.equals(model.getToken())) {
            return false;
        }
        //如果验证成功，说明此用户进行了一次有效操作，延长token的过期时间
        redis.boundValueOps(model.getUserId()).expire(AuthConstants.TOKEN_EXPIRES_HOUR, TimeUnit.HOURS);
        return true;
    }

    @Override
    public void deleteToken(Integer userId) {
        redis.delete(userId);
    }
}
