package com.sadiaBhuiyan.DishDeliver.Backend.controller;

import com.sadiaBhuiyan.DishDeliver.Backend.Model.Restaurant;
import com.sadiaBhuiyan.DishDeliver.Backend.Model.User;
import com.sadiaBhuiyan.DishDeliver.Backend.dto.RestaurantDto;
import com.sadiaBhuiyan.DishDeliver.Backend.request.CreateRestaurantRequest;
import com.sadiaBhuiyan.DishDeliver.Backend.service.RestaurntService;
import com.sadiaBhuiyan.DishDeliver.Backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/restaurants")
public class RestaurantController {

    @Autowired
    private RestaurntService restaurntService;
    @Autowired
    private UserService userService;

    @GetMapping("/search")
    public ResponseEntity<List<Restaurant>> searchRestaurant(
            @RequestHeader("Authorization") String jwt,
            @RequestParam String keyword
    ) throws Exception{
        User user = userService.findUserByJwtToken(jwt);

        List<Restaurant> restaurant = restaurntService.searchRestaurant(keyword);
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity<List<Restaurant>> getAllRestaurant(
            @RequestHeader("Authorization") String jwt
    ) throws Exception{
        User user = userService.findUserByJwtToken(jwt);

        List<Restaurant> restaurant = restaurntService.getAllRestaurant();
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Restaurant> findRestaurantById(
            @RequestHeader("Authorization") String jwt,
            @PathVariable Long id
    ) throws Exception{
        User user = userService.findUserByJwtToken(jwt);

        Restaurant restaurant = restaurntService.findRestaurantById(id);
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }

    @PutMapping("/{id}/add-favourites")
    public ResponseEntity<RestaurantDto> addToFavourites(
            @RequestHeader("Authorization") String jwt,
            @PathVariable Long id
    ) throws Exception{
        User user = userService.findUserByJwtToken(jwt);

        RestaurantDto restaurant = restaurntService.addToFavourites(id,user);
        return new ResponseEntity<>(restaurant, HttpStatus.OK);
    }

}
