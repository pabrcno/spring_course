package com.github.pabrcno.be_project.app.restaurant;

import java.util.List;

import com.github.pabrcno.be_project.domain.restaurants.Restaurant;
import com.github.pabrcno.be_project.service.restaurant.RestaurantService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RequestMapping("/api/v1/restaurants")
@RestController
@AllArgsConstructor
public class RestaurantController {
        RestaurantService restaurantService;

        @RequestMapping("/")
        public List<Restaurant> getAllRestaurants() {
                return restaurantService.getAllRestaurants();
        }

        @RequestMapping("/{restaurantId}")
        public Restaurant getRestaurantById(@PathVariable("restaurantId") Long restaurantId) {
                return restaurantService.getRestaurantById(restaurantId);
        }
        
        @PostMapping("/")
        public void createRestaurant(Restaurant restaurant) {
                restaurantService.createRestaurant(restaurant);
        }

        @PatchMapping("/{restaurantId}")
        public void updateRestaurant(Restaurant restaurant) {
                restaurantService.updateRestaurant(restaurant);
        }

        @DeleteMapping("/{restaurantId}")
        public void deleteRestaurant(@PathVariable("restaurantId") Long restaurantId) {
                restaurantService.deleteRestaurant(restaurantId);
        }
}
