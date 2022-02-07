package com.github.pabrcno.be_project.infrastructure.customers;

import com.github.pabrcno.be_project.domain.customers.Customer;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String>{
    Customer findByEmail(String customerEmail);
}
