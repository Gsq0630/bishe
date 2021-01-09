package com.qingda.lr.controller;

import com.qingda.lr.entity.Chat;
import com.qingda.lr.entity.User;
import com.qingda.lr.service.ChatService;
import com.qingda.lr.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class chatController {

    @Autowired
    ChatService chatService;

    @RequestMapping("chat/getAllChats")
    public Map<String, List> getAllChats(Integer userId, Integer firstId){
        return chatService.getAllChats(userId, firstId);
    }

    @RequestMapping("chat/matchFriend")
    public User mathFriend(User user){
        return chatService.mathFriend(user);
    }


    @RequestMapping("chat/insertChat")
    public int insertChat(Chat chat){
        return chatService.insertChat(chat);
    }
}
