package com.github.pabrcno.be_project.infrastructure.products;

import java.util.List;

import com.github.pabrcno.be_project.domain.products.Product;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, String> {
     List<Product> findByCategory(String category);
}
    

