package com.sadiaBhuiyan.DishDeliver.Backend.response;

import com.sadiaBhuiyan.DishDeliver.Backend.Model.USER_ROLE;


public class AuthResponse {
    private String jwt;
    private String message;
    private USER_ROLE role;

    public AuthResponse() {
    }

    // All-Args Constructor
    public AuthResponse(String jwt, String message, USER_ROLE role) {
        this.jwt = jwt;
        this.message = message;
        this.role = role;
    }

    // Getters and Setters
    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public USER_ROLE getRole() {
        return role;
    }

    public void setRole(USER_ROLE role) {
        this.role = role;
    }

    // toString Method
    @Override
    public String toString() {
        return "AuthResponse{" +
                "jwt='" + jwt + '\'' +
                ", message='" + message + '\'' +
                ", role=" + role +
                '}';
    }
}
