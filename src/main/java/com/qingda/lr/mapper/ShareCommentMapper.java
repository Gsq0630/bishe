package com.qingda.lr.mapper;

import com.qingda.lr.entity.ShareComment;

public interface ShareCommentMapper {
    int deleteByPrimaryKey(Integer scId);

    int insert(ShareComment record);

    int insertSelective(ShareComment record);

    ShareComment selectByPrimaryKey(Integer scId);

    int updateByPrimaryKeySelective(ShareComment record);

    int updateByPrimaryKey(ShareComment record);
}