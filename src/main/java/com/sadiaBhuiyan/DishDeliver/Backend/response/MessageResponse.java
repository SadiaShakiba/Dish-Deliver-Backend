package com.sadiaBhuiyan.DishDeliver.Backend.response;

import lombok.Data;

@Data
public class MessageResponse {
    private String message;

        public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
