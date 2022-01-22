package com.github.pabrcno.be_project.infrastructure.products;

import com.github.pabrcno.be_project.domain.products.Product;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MongoProductsDao extends MongoRepository<Product, String> {
}
    

