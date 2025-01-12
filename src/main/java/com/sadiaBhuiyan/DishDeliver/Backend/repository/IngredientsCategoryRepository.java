package com.sadiaBhuiyan.DishDeliver.Backend.repository;

import com.sadiaBhuiyan.DishDeliver.Backend.Model.IngredientsCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredientsCategoryRepository extends JpaRepository<IngredientsCategory, Long> {

 List<IngredientsCategory> findByRestaurantId(Long id);
}
