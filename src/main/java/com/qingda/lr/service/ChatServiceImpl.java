package com.qingda.lr.service;

import com.qingda.lr.entity.Chat;
import com.qingda.lr.entity.User;
import com.qingda.lr.mapper.ChatMapper;
import com.qingda.lr.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ChatServiceImpl implements ChatService {

    @Autowired
    ChatMapper chatMapper;

    @Autowired
    UserMapper userMapper;

    @Override
    public Map<String, List> getAllChats(Integer userId, Integer firstId) {
        List<User> resultFriends = new ArrayList<>();
        //根据用户id获取所有好友
        List<User> friends = userMapper.getAllFriends(userId);
        if (firstId != 0){
            User user = userMapper.selectByPrimaryKey(firstId);
            resultFriends.add(user);
            for (User u : friends) {
                if (firstId.equals(u.getUserId())){
                    friends.remove(u);
                    break;
                }
            }
            friends.remove(user);
        }
        resultFriends.addAll(friends);
        //获得最近联系好友的聊天记录
        List<Chat> chats = new ArrayList<>();
        if (firstId != 0){
            chats = chatMapper.getAllChats(userId, firstId);
        }else{
            chats = chatMapper.getAllChats(userId, friends.get(0).getUserId());
        }
        Map<String,List> resultMap = new HashMap<>();
        resultMap.put("chats",chats);
        resultMap.put("friends",resultFriends);
        return resultMap;
    }


    @Override
    public int insertChat(Chat chat) {
        return chatMapper.insertSelective(chat);
    }

    @Override
    public User mathFriend(User user) {
        String userAge = user.getUserAge();
        String userSex = user.getUserSex();
        String userHobby = user.getUserHobby();
        if (userAge != null){
            if (userAge.equals("18-20")){
                user = getSartAndStop(user,18,20);
            }else if(userAge.equals("20-30")){
                user = getSartAndStop(user,20,30);
            }
        }
        if (userSex != null && userSex.equals("都行") ){
            user.setUserSex(null);
        }
        if (userHobby != null && userHobby.equals("都行")){
            user.setUserHobby(null);
        }

        return userMapper.mathFriend(user);
    }

    public User getSartAndStop(User user, int min, int max){
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.YEAR, -max);
        Date start = c.getTime();
        user.setMathStart(start);
        c.setTime(new Date());
        c.add(Calendar.YEAR, -min);
        Date stop = c.getTime();
        user.setMathStop(stop);
        return user;
    }
}
