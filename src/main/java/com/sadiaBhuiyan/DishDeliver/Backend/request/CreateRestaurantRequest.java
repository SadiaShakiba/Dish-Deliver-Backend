package com.sadiaBhuiyan.DishDeliver.Backend.request;

import com.sadiaBhuiyan.DishDeliver.Backend.Model.Address;
import com.sadiaBhuiyan.DishDeliver.Backend.Model.ContactInformation;

import java.time.LocalDateTime;
import java.util.List;

public class CreateRestaurantRequest {

    private Long id;

    private String name;

    private String description;

    private String cuisineType;

    private Address address;

    private ContactInformation contactInformation;

    private String openingHours;

    private List<String> images;

    private LocalDateTime registrationDate;

    public CreateRestaurantRequest() {}

    // Parameterized constructor
    public CreateRestaurantRequest(Long id, String name, String description, Address address,
                                   ContactInformation contactInformation, String cuisineType, String openingHours, List<String> images) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.address = address;
        this.contactInformation = contactInformation;
        this.cuisineType = cuisineType;
        this.openingHours = openingHours;
        this.images = images;
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

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }


    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }



    public String getCuisineType() {
        return cuisineType;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public ContactInformation getContactInformation() {
        return contactInformation;
    }

    public void setContactInformation(ContactInformation contactInformation) {
        this.contactInformation = contactInformation;
    }

    public String getOpeningHours() {
        return openingHours;
    }

    public void setOpeningHours(String openingHours) {
        this.openingHours = openingHours;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    @Override
    public String toString() {
        return "CreateRestaurantRequest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", address=" + address +
                ", contactInformation=" + contactInformation +
                ", openingHours='" + openingHours + '\'' +
                ", images=" + images +
                '}';
    }
}
