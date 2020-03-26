package com.qingda.lr.entity;

import java.util.Date;

public class Chat {
    private Integer userIdA;

    private Integer userIdB;

    private String chatText;

    private Date chatTime;

    public Integer getUserIdA() {
        return userIdA;
    }

    public void setUserIdA(Integer userIdA) {
        this.userIdA = userIdA;
    }

    public Integer getUserIdB() {
        return userIdB;
    }

    public void setUserIdB(Integer userIdB) {
        this.userIdB = userIdB;
    }

    public String getChatText() {
        return chatText;
    }

    public void setChatText(String chatText) {
        this.chatText = chatText == null ? null : chatText.trim();
    }

    public Date getChatTime() {
        return chatTime;
    }

    public void setChatTime(Date chatTime) {
        this.chatTime = chatTime;
    }
}