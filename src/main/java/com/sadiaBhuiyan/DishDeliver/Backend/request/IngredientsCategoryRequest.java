package com.sadiaBhuiyan.DishDeliver.Backend.request;

public class IngredientsCategoryRequest {
    private String name;
    private Long restaurantId;

    public IngredientsCategoryRequest(){}

    public IngredientsCategoryRequest(String name,Long restaurantId){
        this.restaurantId = restaurantId;
        this.name = name;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }
}
