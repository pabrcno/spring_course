package com.github.pabrcno.be_project.domain.restaurants;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;


@Entity
@Getter
@ToString
@Setter

@Table(name = "city")
public class City {

   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @ManyToOne(cascade = CascadeType.ALL)
    private Country country; 
    
    public City(Country country, String name) {
        this.country = country;
        this.name = name;
    }
}
