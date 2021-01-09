package com.qingda.lr.service;

import com.qingda.lr.entity.Chat;
import com.qingda.lr.entity.User;

import java.util.List;
import java.util.Map;

public interface ChatService {

    Map<String, List> getAllChats(Integer userId, Integer firstId);

    User mathFriend(User user);

    int insertChat(Chat chat);
}
