package com.github.pabrcno.be_project.infrastructure.cart;

import java.util.Optional;

import com.github.pabrcno.be_project.domain.cart.Cart;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CartRepository extends MongoRepository<Cart, String> {
    Optional<Cart>  findByCustomerId(String customerId);
}

    
