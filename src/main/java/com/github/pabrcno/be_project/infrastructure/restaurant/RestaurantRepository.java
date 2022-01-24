package com.github.pabrcno.be_project.infrastructure.restaurant;

import com.github.pabrcno.be_project.domain.restaurants.Restaurant;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface RestaurantRepository extends CrudRepository<Restaurant, Long> {
    Restaurant findByName(String name);
}
