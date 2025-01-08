package com.sadiaBhuiyan.DishDeliver.Backend.service;

import com.sadiaBhuiyan.DishDeliver.Backend.Model.Category;
import com.sadiaBhuiyan.DishDeliver.Backend.Model.Restaurant;
import com.sadiaBhuiyan.DishDeliver.Backend.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements  CategoryService{
    @Autowired
    private RestaurntService restaurntService;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category createCategory(String name, Long userId) throws Exception{
        Restaurant restaurant = restaurntService.getRestaurantByUserId(userId);

        Category category = new Category();
        category.setName(name);
        category.setRestaurant(restaurant);

        return categoryRepository.save(category);
    }

    @Override
    public List<Category> findCategoryByRestaurantId(Long id) throws Exception {

        Restaurant restaurant = restaurntService.getRestaurantByUserId(id);
        return categoryRepository.findByRestaurantId(restaurant.getId());
    }

    @Override
    public Category findCategoryById(Long id) throws Exception {

        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (optionalCategory.isEmpty()){
            throw new Exception("category not found");
        }
        return optionalCategory.get();
    }
}
