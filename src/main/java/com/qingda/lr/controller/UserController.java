package com.qingda.lr.controller;

import com.qingda.lr.entity.User;
import com.qingda.lr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/user/register")
    public int insertUser(User user){
        return userService.insertUser(user);
    }

    @RequestMapping("/user/login")
    public int login(User user){
        return userService.login(user);
    }


}
