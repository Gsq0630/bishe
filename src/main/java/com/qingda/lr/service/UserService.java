package com.qingda.lr.service;

import com.qingda.lr.entity.User;

import java.util.Map;

public abstract class UserService {
    public abstract int insertUser(User user);

    public abstract int login(User user);

    public abstract String getUserPic(Integer userId);
}
