package com.qingda.lr.mapper;

import com.qingda.lr.entity.Chat;

public interface ChatMapper {
    int insert(Chat record);

    int insertSelective(Chat record);
}