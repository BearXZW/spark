package com.sana.sparkdemo.service;


import com.sana.sparkdemo.model.User;

public interface TokenService {

    String getToken(User user);
}
