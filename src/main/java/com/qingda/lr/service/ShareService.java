package com.qingda.lr.service;

import com.qingda.lr.entity.Share;
import com.qingda.lr.entity.ShareComment;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Map;

public interface ShareService {
    int insertShare(Share share, MultipartFile file);

    Map<String, Object> getAllShares(Integer pageNum, Integer userId);

    int insertShareLike(Integer shareId, Integer userId);

    List<ShareComment> getShareComment(Integer shareId, Integer userId);

    int insertShareComment(ShareComment shareComment);

    int insertCommentLikes(Integer scId, Integer userId);
}
