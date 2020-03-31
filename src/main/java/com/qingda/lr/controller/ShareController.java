package com.qingda.lr.controller;

import com.qingda.lr.entity.Share;
import com.qingda.lr.service.ShareService;
import com.qingda.lr.until.GetPlaceByIp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

}
