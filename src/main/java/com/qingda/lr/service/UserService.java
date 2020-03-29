package com.qingda.lr.service;

import com.qingda.lr.entity.User;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

public interface  UserService {
    int insertUser(User user);

    int login(User user);

    String getUserPic(Integer userId);

    User getUserData(Integer userId);

    int changeUserData(User user, MultipartFile file);

    int changeUserPass(User user);
}
