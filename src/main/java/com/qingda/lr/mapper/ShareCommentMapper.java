package com.qingda.lr.mapper;

import com.qingda.lr.entity.ShareComment;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ShareCommentMapper {
    int deleteByPrimaryKey(Integer scId);

    int insert(ShareComment record);

    int insertSelective(ShareComment record);

    ShareComment selectByPrimaryKey(Integer scId);

    int updateByPrimaryKeySelective(ShareComment record);

    int updateByPrimaryKey(ShareComment record);

    List<ShareComment> selectByShareId(Integer shareId);

    int updateCommentLikes(Integer scId);
}