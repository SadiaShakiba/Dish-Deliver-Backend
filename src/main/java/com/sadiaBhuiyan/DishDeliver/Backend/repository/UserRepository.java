package com.sadiaBhuiyan.DishDeliver.Backend.repository;

import com.sadiaBhuiyan.DishDeliver.Backend.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    public User findByEmail(String email);
}
