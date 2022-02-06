package com.github.pabrcno.be_project.infrastructure.products;

import java.util.List;

import com.github.pabrcno.be_project.domain.products.Product;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
     List<Product> findByCategory(String category);
}
    

