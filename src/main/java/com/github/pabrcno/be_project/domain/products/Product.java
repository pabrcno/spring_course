package com.github.pabrcno.be_project.domain.products;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
@AllArgsConstructor
@RequiredArgsConstructor
@Document(collection = "products")
@Getter @Setter
public class Product {
    @Id
    private String id;
    private String name;
    private String description;
    private double price;
    private String category;    
}
