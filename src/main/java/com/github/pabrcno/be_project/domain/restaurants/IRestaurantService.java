package com.github.pabrcno.be_project.domain.restaurants;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;

import org.hibernate.mapping.Map;

public interface IRestaurantService {
    
    List<Restaurant> getAllRestaurants();
    
    Restaurant getRestaurantById(Long id);
    
    void createRestaurant(Restaurant restaurant);
    
   void updateRestaurant(Restaurant restaurant);
    
    void deleteRestaurant(Long id);
    
    Map deserialize(String restaurantString) throws JsonProcessingException;
    
}
