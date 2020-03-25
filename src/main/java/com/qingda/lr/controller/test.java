package com.qingda.lr.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class test {

    @RequestMapping("/hello")
    public String mmo(){
        return "hello world";
    }
}
