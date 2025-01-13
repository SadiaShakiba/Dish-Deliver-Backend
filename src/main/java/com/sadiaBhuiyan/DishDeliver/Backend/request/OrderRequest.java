package com.sadiaBhuiyan.DishDeliver.Backend.request;

import com.sadiaBhuiyan.DishDeliver.Backend.Model.Address;

public class OrderRequest {

    private Long restaurantId;
    private Address deliveryAddress;

    public OrderRequest() {
    }

    // Parameterized Constructor
    public OrderRequest(Long restaurantId, Address deliveryAddress) {
        this.restaurantId = restaurantId;
        this.deliveryAddress = deliveryAddress;
    }

    // Getters and Setters
    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Address getDeliveryAddress() {
        return deliveryAddress;
    }

    public void setDeliveryAddress(Address deliveryAddress) {
        this.deliveryAddress = deliveryAddress;
    }

}

