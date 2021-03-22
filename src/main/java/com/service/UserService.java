package com.service;

import com.auth0.jwt.interfaces.DecodedJWT;
import com.po.UserInfo;

import java.util.Map;

public interface UserService {
    DecodedJWT verify(String token);
    String login(UserInfo user);
}
