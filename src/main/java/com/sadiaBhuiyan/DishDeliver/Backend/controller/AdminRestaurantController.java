package com.sadiaBhuiyan.DishDeliver.Backend.controller;

import com.sadiaBhuiyan.DishDeliver.Backend.Model.Restaurant;
import com.sadiaBhuiyan.DishDeliver.Backend.Model.User;
import com.sadiaBhuiyan.DishDeliver.Backend.request.CreateRestaurantRequest;
import com.sadiaBhuiyan.DishDeliver.Backend.response.MessageResponse;
import com.sadiaBhuiyan.DishDeliver.Backend.service.RestaurntService;
import com.sadiaBhuiyan.DishDeliver.Backend.service.UserService;
import org.apache.logging.log4j.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/restaurants")
public class AdminRestaurantController {
    @Autowired
    private RestaurntService restaurntService;
    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<Restaurant> createRestaurant(
            @RequestBody CreateRestaurantRequest req,
            @RequestHeader("Authorization") String jwt
            ) throws Exception{
        User user = userService.findUserByJwtToken(jwt);

        Restaurant restaurant = restaurntService.createRestaurant(req,user);
        return new ResponseEntity<>(restaurant, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Restaurant> updateRestaurant(
            @RequestBody CreateRestaurantRequest req,
            @RequestHeader("Authorization") String jwt,
            @PathVariable Long id
    ) throws Exception{
        User user = userService.findUserByJwtToken(jwt);

        Restaurant restaurant = restaurntService.updateRestaurant(id,req);
        return new ResponseEntity<>(restaurant, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MessageResponse> deleteRestaurant(
            @RequestHeader("Authorization") String jwt,
            @PathVariable Long id
    ) throws Exception{
        User user = userService.findUserByJwtToken(jwt);

        restaurntService.deleteRestaurant(id);
        MessageResponse res = new MessageResponse();
        res.setMessage("restaurant deleted successfully");
        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<Restaurant> updateRestaurantStatus(
            @RequestHeader("Authorization") String jwt,
            @PathVariable Long id
    ) throws Exception{
        User user = userService.findUserByJwtToken(jwt);

        Restaurant restaurant = restaurntService.updateRestaurantStatus(id);

        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }


    @GetMapping("/user")
    public ResponseEntity<Restaurant> findRestaurantByUserId(
            @RequestHeader("Authorization") String jwt
    ) throws Exception{
        User user = userService.findUserByJwtToken(jwt);

       Restaurant restaurant = restaurntService.getRestaurantByUserId(user.getId());
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }

}
