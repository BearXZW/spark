package com.sana.sparkdemo.service.impl;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.sana.sparkdemo.model.User;
import com.sana.sparkdemo.service.TokenService;
import org.springframework.stereotype.Service;

@Service(value="TokenService")
public class TokenServiceImpl implements TokenService {

    @Override
    public  String getToken(User user){
        String token="";
        token= JWT.create().withAudience((user.getUserid()).toString()).sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }
}
