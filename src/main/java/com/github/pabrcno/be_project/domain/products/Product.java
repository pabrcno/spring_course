package com.github.pabrcno.be_project.domain.products;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.pabrcno.be_project.domain.core.Observer.IObserver;
import com.github.pabrcno.be_project.domain.core.Observer.ISubject;
@Entity
@Table(name = "ecommerce")
public class Product implements ISubject{

    private String name;
    private String description;
    private double price;
    private int stock;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private UUID code;
    private List<IObserver> observers;
    private boolean isAvailable;


    public Product( 
        @JsonProperty("name") String name,
        @JsonProperty("description") String description,
        @JsonProperty("price") double price,
        @JsonProperty("stock") int stock) {
        this.setCode(UUID.randomUUID());
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.isAvailable = stock>0;
        this.observers = new ArrayList<IObserver>();
    }
    
   
    public UUID getCode() {
        return code;
    }


    public void setCode(UUID code) {
        this.code = code;
    }


    @Override
    public void registerObserver(IObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(IObserver observer) {
        observers.remove(observer);

    }

    @Override
    public void notifyObservers() {
        String availability = isAvailable? " available" : " not available";
        for (IObserver observer : observers) {
            observer.update("Product " + this.name + availability);
        }
    }
    // Getters and Setters
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public double getPrice() {
        return price;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public int getStock() {
        return stock;
    }
    public void setStock(int stock) {
        this.stock = stock;
    }
    public List<IObserver> getObservers() {
        return observers;
    }

    public boolean getIsAvailable() {
        
        return isAvailable;
    }
    public void setAvailable() {
        this.isAvailable = this.stock>0;
        notifyObservers();
    }
    public Integer getId() {
        return id;
    }
    
}
