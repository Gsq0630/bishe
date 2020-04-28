package com.qingda.lr.service;

import com.qingda.lr.entity.Chat;
import com.qingda.lr.entity.User;
import com.qingda.lr.mapper.ChatMapper;
import com.qingda.lr.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    ChatMapper chatMapper;

    @Autowired
    UserMapper userMapper;

    @Override
    public Map<String, List> getAllChats(Integer userId) {
        //根据用户id获取所有好友
        List<User> friends = userMapper.getAllFriends(userId);
        //获得最近联系好友的聊天记录
        List<Chat> chats = chatMapper.getAllChats(userId, friends.get(0).getUserId());
        Map<String,List> resultMap = new HashMap<>();
        resultMap.put("chats",chats);
        resultMap.put("friends",friends);
        return resultMap;
    }
}
