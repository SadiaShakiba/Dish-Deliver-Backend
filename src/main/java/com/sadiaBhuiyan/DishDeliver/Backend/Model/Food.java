package com.sadiaBhuiyan.DishDeliver.Backend.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Food {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String description;

    private Long price;

    @ManyToOne
    private Category foodCategory;

    @Column(length = 1000)
    @ElementCollection
    private List<String> images;

    private boolean available;

    @ManyToOne
    private  Restaurant restaurant;

    private boolean isVegetarian;

    private boolean isSeasonal;

    @ManyToMany
    private List<IngredientsItem> ingredients = new ArrayList<>();

    private Date creationDate;

    public Food() {
    }

    // Parameterized Constructor
    public Food(Long id, String name, String description, Long price, Category foodCategory, List<String> images,
                boolean available, Restaurant restaurant, boolean isVegetarian, boolean isSeasonal,
                List<IngredientsItem> ingredients, Date creationDate) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.foodCategory = foodCategory;
        this.images = images;
        this.available = available;
        this.restaurant = restaurant;
        this.isVegetarian = isVegetarian;
        this.isSeasonal = isSeasonal;
        this.ingredients = ingredients;
        this.creationDate = creationDate;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Category getFoodCategory() {
        return foodCategory;
    }

    public void setFoodCategory(Category foodCategory) {
        this.foodCategory = foodCategory;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    public boolean isVegetarian() {
        return isVegetarian;
    }

    public void setVegetarian(boolean vegetarian) {
        isVegetarian = vegetarian;
    }

    public boolean isSeasonal() {
        return isSeasonal;
    }

    public void setSeasonal(boolean seasonal) {
        isSeasonal = seasonal;
    }

    public List<IngredientsItem> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<IngredientsItem> ingredients) {
        this.ingredients = ingredients;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    // toString Method for Debugging
    @Override
    public String toString() {
        return "Food{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", foodCategory=" + foodCategory +
                ", images=" + images +
                ", available=" + available +
                ", restaurant=" + restaurant +
                ", isVegetarian=" + isVegetarian +
                ", isSeasonal=" + isSeasonal +
                ", ingredients=" + ingredients +
                ", creationDate=" + creationDate +
                '}';
    }

}
