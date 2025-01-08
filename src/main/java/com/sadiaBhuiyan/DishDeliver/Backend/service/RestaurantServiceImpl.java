package com.sadiaBhuiyan.DishDeliver.Backend.service;

import com.sadiaBhuiyan.DishDeliver.Backend.Model.Address;
import com.sadiaBhuiyan.DishDeliver.Backend.Model.Restaurant;
import com.sadiaBhuiyan.DishDeliver.Backend.Model.User;
import com.sadiaBhuiyan.DishDeliver.Backend.dto.RestaurantDto;
import com.sadiaBhuiyan.DishDeliver.Backend.repository.AddressRepository;
import com.sadiaBhuiyan.DishDeliver.Backend.repository.RestaurantRepository;
import com.sadiaBhuiyan.DishDeliver.Backend.repository.UserRepository;
import com.sadiaBhuiyan.DishDeliver.Backend.request.CreateRestaurantRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class RestaurantServiceImpl implements RestaurntService{
    @Autowired
    private RestaurantRepository restaurantRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private UserRepository userRepository;

    @Override
    public Restaurant createRestaurant(CreateRestaurantRequest req, User user) {
        Address address = addressRepository.save(req.getAddress());

        Restaurant restaurant = new Restaurant();
        restaurant.setAddress(address);
        restaurant.setContactInformation(req.getContactInformation());
        restaurant.setCuisineType(req.getCuisineType());
        restaurant.setDescription(req.getDescription());
        restaurant.setImages(req.getImages());
        restaurant.setName(req.getName());
        restaurant.setOpeningHours(req.getOpeningHours());
        restaurant.setRegistrationDate(LocalDateTime.now());
        restaurant.setOwner(user);

        return restaurantRepository.save(restaurant);

    }

    @Override
    public Restaurant updateRestaurant(Long restaurantId, CreateRestaurantRequest updateRestaurant) throws Exception {

        Restaurant restaurant = findRestaurantById(restaurantId);

        if (restaurant.getCuisineType()!=null){
            restaurant.setCuisineType(updateRestaurant.getCuisineType());
        }

        if (restaurant.getDescription()!=null){
            restaurant.setDescription(updateRestaurant.getDescription());
        }

        if (restaurant.getName()!=null){
            restaurant.setName(updateRestaurant.getName());
        }

        if (restaurant.getOpeningHours()!=null){
            restaurant.setOpeningHours(updateRestaurant.getOpeningHours());
        }

        return restaurantRepository.save(restaurant);
    }

    @Override
    public void deleteRestaurant(Long restaurantId) throws Exception {

        Restaurant restaurant = findRestaurantById(restaurantId);

        restaurantRepository.delete(restaurant);
    }

    @Override
    public List<Restaurant> getAllRestaurant() {
        return restaurantRepository.findAll();
    }

    @Override
    public List<Restaurant> searchRestaurant(String keyword) {
        return restaurantRepository.findBySearchQuery(keyword);
    }

    @Override
    public Restaurant findRestaurantById(Long restaurantId) throws Exception {
        Optional<Restaurant> opt = restaurantRepository.findById(restaurantId);

        if (opt.isEmpty()){
            throw new Exception("restaurant not found with id" + restaurantId);
        }

        return opt.get();
    }

    @Override
    public Restaurant getRestaurantByUserId(Long userId) throws Exception {
        Restaurant restaurant = restaurantRepository.findByOwnerId(userId);

        if (restaurant==null){
            throw new Exception("restaurant not found with  user id" + userId);
        }

        return restaurant;
    }

    @Override
    public RestaurantDto addToFavourites(Long restaurantId, User user) throws Exception {
        Restaurant restaurant = findRestaurantById(restaurantId);

        RestaurantDto restaurantDto  = new RestaurantDto();
        restaurantDto.setDescription(restaurant.getDescription());
        restaurantDto.setImages(restaurant.getImages());
        restaurantDto.setTitle(restaurant.getName());
        restaurantDto.setId(restaurantId);

        boolean isFavourite = false;
        List<RestaurantDto> favourites = user.getFavourites();

        for (RestaurantDto favourite : favourites){
            if (favourite.getId().equals(restaurantId)){
                isFavourite = true;
                break;
            }
        }

        if (isFavourite){
            favourites.removeIf(favourite-> favourite.getId().equals(restaurantId));
        }else{
            favourites.add(restaurantDto);
        }

        userRepository.save(user);

        return restaurantDto;
    }

    @Override
    public Restaurant updateRestaurantStatus(Long id) throws Exception {
        Restaurant restaurant= findRestaurantById(id);

        restaurant.setOpen(!restaurant.isOpen());
        return  restaurantRepository.save(restaurant);
    }
}
