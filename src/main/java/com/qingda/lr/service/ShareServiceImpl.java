package com.qingda.lr.service;

import com.qingda.lr.entity.Share;
import com.qingda.lr.entity.ShareComment;
import com.qingda.lr.mapper.ShareCommentMapper;
import com.qingda.lr.mapper.ShareMapper;
import com.qingda.lr.until.FileUploadGsq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShareServiceImpl implements ShareService {

    @Autowired
    ShareMapper shareMapper;

    @Autowired
    ShareCommentMapper shareCommentMapper;

    @Override
    public int insertShareComment(ShareComment shareComment) {
        return shareCommentMapper.insertSelective(shareComment);
    }

    @Override
    public List<ShareComment> getShareComment(Integer shareId, Integer userId) {
        List<ShareComment> shareComments =  shareCommentMapper.selectByShareId(shareId);
        for (ShareComment s : shareComments) {
            String shareCommentUserId = "shareCommentId:" + s.getScId() + "_" + "userId:" + userId;
            s.setLikeOrNot(shareMapper.getLikeOrNot(shareCommentUserId).getLikeOrNot());
        }
        return shareComments;
    }

    @Override
    public int insertCommentLikes(Integer scId, Integer userId) {
        String shareUserId = "shareCommentId:" + scId + "_" + "userId:" + userId;
        return shareMapper.insertShareLike(shareUserId) + shareCommentMapper.updateCommentLikes(scId);
    }

    @Override
    public int insertShareLike(Integer shareId, Integer userId) {
        String shareUserId = "shareId:" + shareId + "_" + "userId:" + userId;
        return shareMapper.insertShareLike(shareUserId) + shareMapper.updateLike(shareId);
    }

    @Override
    public Map<String, Object> getAllShares(Integer pageNum, Integer userId) {
        List<Share> shareList = shareMapper.getShares((pageNum-1)*3);
        for (Share share: shareList) {
            share.setShareCommentCount(shareMapper.getShareCommentAccount(share.getShareId()).getShareCommentCount());
            String shareUserId = "shareId:" + share.getShareId() + "_" + "userId:" + userId;
            share.setLikeOrNot(shareMapper.getLikeOrNot(shareUserId).getLikeOrNot());
        }
        int count = shareMapper.getShareCount().getShareCount();
        count = count%3>0 ? count/3+1 : count/3;
        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("pageCount",count);
        resultMap.put("list", shareList);
        return resultMap;
    }

    @Override
    public int insertShare(Share share, MultipartFile file) {
        int result = 0;
        try {
            if (!file.isEmpty()){
                share.setShareAnnexUrl(new FileUploadGsq().uploadToDisk(file));
            }
            result = shareMapper.insertSelective(share);
        }catch (Exception e){
            e.printStackTrace();
            result = 0;
        }
        return result;
    }
}
