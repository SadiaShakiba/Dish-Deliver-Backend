package com.sadiaBhuiyan.DishDeliver.Backend.repository;

import com.sadiaBhuiyan.DishDeliver.Backend.Model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    public List<Category> findByRestaurantId(Long id);
}
