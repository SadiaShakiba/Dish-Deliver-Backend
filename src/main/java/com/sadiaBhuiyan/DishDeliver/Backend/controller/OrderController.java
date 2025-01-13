package com.sadiaBhuiyan.DishDeliver.Backend.controller;

import com.sadiaBhuiyan.DishDeliver.Backend.Model.CartItem;
import com.sadiaBhuiyan.DishDeliver.Backend.Model.Order;
import com.sadiaBhuiyan.DishDeliver.Backend.Model.User;
import com.sadiaBhuiyan.DishDeliver.Backend.request.AddCartItemRequest;
import com.sadiaBhuiyan.DishDeliver.Backend.request.OrderRequest;
import com.sadiaBhuiyan.DishDeliver.Backend.service.OrderService;
import com.sadiaBhuiyan.DishDeliver.Backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @PostMapping("/order")
    public ResponseEntity<Order> createOrder(@RequestBody OrderRequest req,
                                                  @RequestHeader("Authorization") String jwt) throws  Exception{
        User user = userService.findUserByJwtToken(jwt);
        Order order = orderService.createOrder(req,user);
        return  new ResponseEntity<>(order, HttpStatus.CREATED);
    }


    @GetMapping("/order/user")
    public ResponseEntity<List<Order>> getOrderHistory(
                                             @RequestHeader("Authorization") String jwt) throws  Exception{
        User user = userService.findUserByJwtToken(jwt);
        List<Order> orders = orderService.getUserOrder(user.getId());
        return  new ResponseEntity<>(orders, HttpStatus.OK);
    }




}
