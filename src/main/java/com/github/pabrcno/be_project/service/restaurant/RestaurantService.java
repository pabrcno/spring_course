package com.github.pabrcno.be_project.service.restaurant;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.pabrcno.be_project.domain.restaurants.IRestaurantService;
import com.github.pabrcno.be_project.domain.restaurants.Restaurant;
import com.github.pabrcno.be_project.infrastructure.restaurant.RestaurantRepository;

import org.hibernate.mapping.Map;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@AllArgsConstructor
@Log4j2
public class RestaurantService  implements IRestaurantService{
    RestaurantRepository restaurantRepository;
    private final ObjectMapper mapper;
    @PostConstruct
    private void PostConstruct() {
        mapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        mapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss"));
    }
    @Override
    public List<Restaurant> getAllRestaurants() {
        List<Restaurant> restaurants = new ArrayList<Restaurant>();
        restaurantRepository.findAll().forEach(restaurants::add);
        return  restaurants;
    }

    @Override
    public Restaurant getRestaurantById(Long id) {
        return restaurantRepository.findById(id).get();
    }

    @Override
    public void createRestaurant(Restaurant restaurant) {
        try {
            mapperToString(restaurant);
            mapperToMap(restaurant);
            mapperToClass(restaurant);

            restaurantRepository.save(restaurant);
        } catch (JsonProcessingException e) {
            log.error("Error converting message to string", e);
        }
       
    }

    @Override
    public void updateRestaurant(Restaurant restaurant) {
      
        restaurantRepository.save(restaurant);

    }

    @Override
    public void deleteRestaurant(Long id) {
        restaurantRepository.deleteById(id);
    }

    @Override
    public Map deserialize(String restaurantString) throws JsonProcessingException {
        return mapper.readValue(restaurantString, Map.class);
    }
    void mapperToString(Restaurant restaurant) throws JsonProcessingException {
        var restaurantString = mapper.writeValueAsString(restaurant);
        log.info("Message format String : {}", restaurantString);
    }
    void mapperToMap(Restaurant restaurant) throws JsonProcessingException {
        var restaurantString = mapper.writeValueAsString(restaurant);
        var restaurantMap = mapper.readValue(restaurantString, Map.class);
        log.info("Message format Map<String> : {}", restaurantMap);
    }

    void mapperToClass(Restaurant restaurant) throws JsonProcessingException {
        var restaurantString = mapper.writeValueAsString(restaurant);
        var restaurantClass = mapper.readValue(restaurantString, Restaurant.class);
        log.info("Message format Class : {}", restaurantClass);
    }


}
