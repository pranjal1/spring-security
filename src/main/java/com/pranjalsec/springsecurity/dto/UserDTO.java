package com.pranjalsec.springsecurity.dto;

public class UserDTO {
    private Long userId;
    private String userName;
    private String userPassword;
    private String userRoles;

    public UserDTO(Long userId, String userName, String userPassword, String userRoles) {
        this.userId = userId;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userRoles = userRoles;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "userId=" + userId +
                ", userName='" + userName + '\'' +
                ", userPassword='" + userPassword + '\'' +
                ", userRoles='" + userRoles + '\'' +
                '}';
    }

    public UserDTO() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return userPassword;
    }



    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserRoles() {
        return userRoles;
    }

    public void setUserRoles(String userRoles) {
        this.userRoles = userRoles;
    }
}
