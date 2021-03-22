package com.service.impl;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTCreator;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.po.UserInfo;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 * @Version 1.0
 * @Author:penguins Shaw
 * @Date: 2021 03 2021-03-21 23:17
 * Description: No Description
 */
@Service
public class UserServiceImpl implements UserService {
    //密钥
    @Value("application.secret.jwt")
    private String secret;

    @Override
    public String login(UserInfo user){
        //todo 验证用户信息
        if(user==null){
            return "error";
        }
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("user_id",user.getUserID());
        return createToken(hashMap);
    }
    /**
     * 生成token
     * @param map
     * @return
     */
    public String createToken(Map<String,String> map){
        Calendar calendar = Calendar.getInstance();
        //默认7天过期
        calendar.add(Calendar.DATE,7);
        JWTCreator.Builder builder = JWT.create();
        map.forEach((k,v)->{
            builder.withClaim(k,v);
        });
        String token = builder.withExpiresAt(calendar.getTime())//指定令牌时间
                .sign(Algorithm.HMAC256(secret));//签名
        return token;
    }

    /**
     * 验证token 返回token信息
     * @param token
     * @return
     */
    @Override
    public DecodedJWT verify(String token){
        return JWT.require(Algorithm.HMAC256(secret)).build().verify(token);
    }
}