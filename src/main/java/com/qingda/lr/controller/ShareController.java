package com.qingda.lr.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qingda.lr.entity.Share;
import com.qingda.lr.entity.ShareComment;
import com.qingda.lr.service.ShareService;
import com.qingda.lr.until.GetPlaceByIp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class ShareController {

    @Autowired
    ShareService shareService;

    @RequestMapping("/share/insertShare")
    public void insert(Share share, MultipartFile file, HttpServletResponse response, HttpServletRequest request){
        try {
            share.setShareLocation(GetPlaceByIp.getPlace(request));
            if (shareService.insertShare(share, file) == 1 ){
                response.sendRedirect("/square.html");
            }else {
                response.sendRedirect("/errorChangeData.html");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @RequestMapping("/share/getAllShares")
    public List<Share> getAllShares(@RequestParam(value = "pageNum", defaultValue = "1") Integer pageNum, Integer userId) {
        return shareService.getAllShares(pageNum, userId);
    }

    @RequestMapping("share/addLikes")
    public int addLikes(Integer shareId, Integer userId){
        return shareService.insertShareLike(shareId,userId);
    }

    @RequestMapping("share/getShareComment")
    public List<ShareComment> getShareComment(Integer shareId, Integer userId){
        return shareService.getShareComment(shareId, userId);
    }

    @RequestMapping("share/insertShareComment")
    public int insertShareComment(ShareComment shareComment){
        return shareService.insertShareComment(shareComment);
    }

    @RequestMapping("share/addCommentLikes")
    public int addCommentLikes(Integer scId, Integer userId){
        return shareService.insertCommentLikes(scId, userId);
    }



}
