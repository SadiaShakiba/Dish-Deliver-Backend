package com.sadiaBhuiyan.DishDeliver.Backend.service;

import com.sadiaBhuiyan.DishDeliver.Backend.Model.Order;
import com.sadiaBhuiyan.DishDeliver.Backend.Model.User;
import com.sadiaBhuiyan.DishDeliver.Backend.request.OrderRequest;

import java.util.List;

public interface OrderService {

    public Order createOrder(OrderRequest order, User user) throws Exception;

    public Order updateOrder(Long orderId, String orderStatus) throws Exception;

    public void cancelOrder(Long orderId) throws  Exception;

    public List<Order> getUserOrder(Long userId) throws  Exception;

    public List<Order> getRestaurantsOrder(Long restaurantId, String orderStatus) throws Exception;

    public  Order findOrderById  (Long orderId) throws Exception;

}
