package com.sadiaBhuiyan.DishDeliver.Backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @GetMapping
    public ResponseEntity<String> HomeController(){
        return new ResponseEntity<>("Welcome to food deliver project", HttpStatus.OK);
    }
}
