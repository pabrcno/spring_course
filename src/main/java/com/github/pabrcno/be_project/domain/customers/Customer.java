package com.github.pabrcno.be_project.domain.customers;

import com.bol.secure.Encrypted;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@RequiredArgsConstructor
@Document(collection = "customers")
@Builder
@Getter @Setter
public class Customer {
    private String username;
    private String token;
    private String email;
    @Encrypted
    private String password;
    @Id 
    private String id;
    public Customer from(CustomerRequest request) {
        return Customer.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .password(request.getPassword())
                .build();
    }
}
