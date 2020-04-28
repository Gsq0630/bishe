package com.qingda.lr.mapper;

import com.qingda.lr.entity.Chat;
import com.qingda.lr.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ChatMapper {
    int insert(Chat record);

    int insertSelective(Chat record);

    List<Chat> getAllChats(Integer userIdA,Integer userIdB);
}