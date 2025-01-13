package com.sadiaBhuiyan.DishDeliver.Backend.repository;

import com.sadiaBhuiyan.DishDeliver.Backend.Model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {


}
