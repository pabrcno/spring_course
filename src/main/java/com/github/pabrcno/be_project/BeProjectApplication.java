package com.github.pabrcno.be_project;

import java.util.List;

import com.github.pabrcno.be_project.domain.restaurants.Category;
import com.github.pabrcno.be_project.domain.restaurants.City;
import com.github.pabrcno.be_project.domain.restaurants.Country;
import com.github.pabrcno.be_project.domain.restaurants.Restaurant;
import com.github.pabrcno.be_project.infrastructure.restaurant.RestaurantRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BeProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(BeProjectApplication.class, args);
	}
	@Bean
	public CommandLineRunner loadData(RestaurantRepository repository) {
		return (args) -> {
			repository.save(Restaurant.builder().categories(List.of(new Category("Pizza"))).city(new City(new Country("USA"), "New York")).name("Pizza Hut").build());
			repository.save(Restaurant.builder().categories(List.of(new Category("Soup"))).city(new City(new Country("USA"), "New York")).name("Souplantation").build());
			repository.save(Restaurant.builder().categories(List.of(new Category("Pizza"))).city(new City(new Country("USA"), "New York")).name("Papa Johns").build());
			};
}
}
