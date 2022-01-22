package com.github.pabrcno.be_project.domain.products;

import java.util.List;


import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import com.github.pabrcno.be_project.domain.core.Observer.IObserver;


@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class Product {

    private String name;
    private String description;
    private double price;
    private int stock;
    @Id
    private String id;
    private List<IObserver> observers;
    private boolean isAvailable;
}
