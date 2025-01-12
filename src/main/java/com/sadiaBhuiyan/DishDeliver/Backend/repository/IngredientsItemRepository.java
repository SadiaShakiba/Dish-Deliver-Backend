package com.sadiaBhuiyan.DishDeliver.Backend.repository;

import com.sadiaBhuiyan.DishDeliver.Backend.Model.IngredientsItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngredientsItemRepository  extends JpaRepository<IngredientsItem, Long> {

 List<IngredientsItem> findByRestaurantId(Long id);
}
