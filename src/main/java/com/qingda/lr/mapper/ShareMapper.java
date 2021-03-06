package com.qingda.lr.mapper;

import com.qingda.lr.entity.Share;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ShareMapper {
    int deleteByPrimaryKey(Integer shareId);

    int insert(Share record);

    int insertSelective(Share record);

    Share selectByPrimaryKey(Integer shareId);

    int updateByPrimaryKeySelective(Share record);

    int updateByPrimaryKey(Share record);

    List<Share> getShares(Integer pageNum);

    Share getShareCommentAccount(Integer shareId);

    Share getLikeOrNot(String shareUserId);

    int insertShareLike(String shareUserId);

    int updateLike(Integer shareId);

    Share getShareCount();

}