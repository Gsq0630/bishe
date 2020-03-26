package com.qingda.lr.service;

import com.qingda.lr.entity.User;

public abstract class UserService {
    public abstract int insertUser(User user);

    public abstract int login(User user);
}
