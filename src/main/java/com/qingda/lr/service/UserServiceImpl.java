package com.qingda.lr.service;

import com.qingda.lr.entity.User;
import com.qingda.lr.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

@Service
public class UserServiceImpl extends UserService {

    @Override
    public int login(User user) {
        return userMapper.login(user).getUserId();
    }

    @Autowired
    UserMapper userMapper;

    @Override
    public int insertUser(User user) {
        int max=10000000;
        int min=1000000;
        Random random = new Random();
        int account = random.nextInt(max)%(max-min+1) + min;
        user.setUserAccount(account);
        user.setUserPic("images/userPic.png");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try{
            user.setUserBirthday(sdf.parse(user.getUserBirStr()));
            userMapper.insertSelective(user);
        }catch (Exception e){
            e.printStackTrace();
            account = 0;
        }
        return account;
    }
}
