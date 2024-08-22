package com.grepp.model.dtos;

public class MemberDto {
    private String userId;
    private String userPw;

    public String getUserId() {
        return userId;
    }

    public String getUserPw() {
        return userPw;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void setUserPw(String userPw) {
        this.userPw = userPw;
    }

    @Override
    public String toString() {
        return "MemberDto{" +
                "userId='" + userId + '\'' +
                ", userPw='" + userPw + '\'' +
                '}';
    }
}
