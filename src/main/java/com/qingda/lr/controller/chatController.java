package com.qingda.lr.controller;

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
    public Map<String, List> getAllChats(Integer userId){
        return chatService.getAllChats(userId);
    }

}
