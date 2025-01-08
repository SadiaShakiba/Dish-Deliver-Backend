package com.sadiaBhuiyan.DishDeliver.Backend.service;

import com.sadiaBhuiyan.DishDeliver.Backend.Model.User;

public interface UserService {

    public User findUserByJwtToken(String jwt) throws Exception;

    public  User findUserByEmail(String Email) throws Exception;
}
