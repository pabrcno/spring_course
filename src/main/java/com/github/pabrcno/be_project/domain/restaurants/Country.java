package com.github.pabrcno.be_project.domain.restaurants;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

import com.github.pabrcno.be_project.domain.restaurants.Restaurant.RestaurantBuilder;

@Entity
@Getter
@Setter

@Table(name = "country")
@ToString
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    public static RestaurantBuilder builder() {
        return null;
    }

    public Country(String name) {
        this.name = name;
    }
}
