package com.qingda.lr.entity;

import java.util.Date;

public class User {
    private Integer userId;

    private String userName;

    private String userSex;

    private Date userBirthday;

    private String userPic;

    private String userPassword;

    private Integer userAccount;

    private String userBirStr;

    private String userNewPass;

    private String userHobby;

    private String userAge;

    private Date mathStart;

    private Date mathStop;

    public Date getMathStart() {
        return mathStart;
    }

    public void setMathStart(Date mathStart) {
        this.mathStart = mathStart;
    }

    public Date getMathStop() {
        return mathStop;
    }

    public void setMathStop(Date mathStop) {
        this.mathStop = mathStop;
    }

    public String getUserAge() {
        return userAge;
    }

    public void setUserAge(String userAge) {
        this.userAge = userAge;
    }

    public String getUserHobby() {
        return userHobby;
    }

    public void setUserHobby(String userHobby) {
        this.userHobby = userHobby;
    }

    public String getUserNewPass() {
        return userNewPass;
    }

    public void setUserNewPass(String userNewPass) {
        this.userNewPass = userNewPass;
    }

    public String getUserBirStr() {
        return userBirStr;
    }

    public void setUserBirStr(String userBirStr) {
        this.userBirStr = userBirStr;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserSex() {
        return userSex;
    }

    public void setUserSex(String userSex) {
        this.userSex = userSex == null ? null : userSex.trim();
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    public String getUserPic() {
        return userPic;
    }

    public void setUserPic(String userPic) {
        this.userPic = userPic == null ? null : userPic.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public Integer getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(Integer userAccount) {
        this.userAccount = userAccount;
    }
}