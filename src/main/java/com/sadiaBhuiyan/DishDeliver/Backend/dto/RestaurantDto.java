package com.sadiaBhuiyan.DishDeliver.Backend.dto;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Data;

import java.util.List;

@Data
@Embeddable
public class RestaurantDto {
    private String title;

    @Column(length = 1000)
    private List<String> images;

    private String description;

    private Long id;

    public RestaurantDto() {
    }

    // Parameterized Constructor
    public RestaurantDto(String title, List<String> images, String description, Long id) {
        this.title = title;
        this.images = images;
        this.description = description;
        this.id = id;
    }

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // toString Method
    @Override
    public String toString() {
        return "RestaurantDto{" +
                "title='" + title + '\'' +
                ", images=" + images +
                ", description='" + description + '\'' +
                ", id=" + id +
                '}';
    }

}
