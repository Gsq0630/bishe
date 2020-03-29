package com.qingda.lr.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class test {
//    CreatCookie creatCookie = new CreatCookie();

//    @RequestMapping("/hello")
//    public String mmo(HttpServletResponse response){
//
//
////        return creatCookie.setCookies(response);
//    }
//
//    @RequestMapping("hi")
//    public String getCookie(HttpServletRequest request){
//
////        return  creatCookie.getCookies(request);
//    }

    @RequestMapping("/file")
    public String getFile(@RequestParam("file") MultipartFile file){
        System.out.println("21");
        return "0";
    }

}
