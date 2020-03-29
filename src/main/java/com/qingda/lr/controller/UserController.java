package com.qingda.lr.controller;

import com.qingda.lr.entity.User;
import com.qingda.lr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/user/register")
    public int insertUser(User user){
        return userService.insertUser(user);
    }

    @RequestMapping("/user/login")
    public int login(User user , HttpServletResponse response){
        return userService.login(user);
    }

    @RequestMapping("/user/getUserPic")
    public String getUserPic(Integer userId){
        return userService.getUserPic(userId);
    }

    @RequestMapping("/user/getUserData")
    public User getUserData(Integer userId){
        return userService.getUserData(userId);
    }

    @RequestMapping("/user/changeUserData")
    public void changeUserData(User user, MultipartFile file, HttpServletResponse response){
        try {
            if (userService.changeUserData(user, file) == 1 ){
                response.sendRedirect("/successChangeData.html");
            }else {
                response.sendRedirect("/errorChangeData.html");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @RequestMapping("/user/changeUserPassword")
    public int changeUserPassword(User user){
         return userService.changeUserPass(user);
    }

}
