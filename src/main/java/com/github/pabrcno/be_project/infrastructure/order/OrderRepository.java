package com.github.pabrcno.be_project.infrastructure.order;

import com.github.pabrcno.be_project.domain.order.Order;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface OrderRepository extends MongoRepository<Order, String> {
}
    
