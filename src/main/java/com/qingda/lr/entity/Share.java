package com.qingda.lr.entity;

import java.util.Date;

public class Share {
    private Integer shareId;

    private Integer userId;

    private String shareText;

    private String shareTitle;

    private String shareAnnexUrl;

    private String shareLocation;

    private Integer shareLikes;

    private Integer shareFromId;

    private Date shareTime;

    private int shareCommentCount;

    private String userName;

    private String userPic;

    private int shareCount;

    private int likeOrNot;

    public int getShareCount() {
        return shareCount;
    }

    public void setShareCount(int shareCount) {
        this.shareCount = shareCount;
    }

    public int getLikeOrNot() {
        return likeOrNot;
    }

    public void setLikeOrNot(int likeOrNot) {
        this.likeOrNot = likeOrNot;
    }

    public String getUserPic() {
        return userPic;
    }

    public void setUserPic(String userPic) {
        this.userPic = userPic;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getShareCommentCount() {
        return shareCommentCount;
    }

    public void setShareCommentCount(int shareCommentCount) {
        this.shareCommentCount = shareCommentCount;
    }

    public Integer getShareId() {
        return shareId;
    }

    public void setShareId(Integer shareId) {
        this.shareId = shareId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getShareText() {
        return shareText;
    }

    public void setShareText(String shareText) {
        this.shareText = shareText == null ? null : shareText.trim();
    }

    public String getShareTitle() {
        return shareTitle;
    }

    public void setShareTitle(String shareTitle) {
        this.shareTitle = shareTitle == null ? null : shareTitle.trim();
    }

    public String getShareAnnexUrl() {
        return shareAnnexUrl;
    }

    public void setShareAnnexUrl(String shareAnnexUrl) {
        this.shareAnnexUrl = shareAnnexUrl == null ? null : shareAnnexUrl.trim();
    }

    public String getShareLocation() {
        return shareLocation;
    }

    public void setShareLocation(String shareLocation) {
        this.shareLocation = shareLocation == null ? null : shareLocation.trim();
    }

    public Integer getShareLikes() {
        return shareLikes;
    }

    public void setShareLikes(Integer shareLikes) {
        this.shareLikes = shareLikes;
    }

    public Integer getShareFromId() {
        return shareFromId;
    }

    public void setShareFromId(Integer shareFromId) {
        this.shareFromId = shareFromId;
    }

    public Date getShareTime() {
        return shareTime;
    }

    public void setShareTime(Date shareTime) {
        this.shareTime = shareTime;
    }
}