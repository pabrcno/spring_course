package com.github.pabrcno.be_project.domain.restaurants;


import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor(staticName = "of")
@NoArgsConstructor
@ToString
@Table(name = "restaurant")
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @OneToMany(mappedBy="id")
    private List<Category> categories;
    private String description;
    private String openingTime;
    private String closingTime;
    private String latitude;
    private String longitude;
    private String name;
    private Date creationDate;
    @ManyToOne(cascade = CascadeType.ALL)
    private City city;
    private String phone;


}
