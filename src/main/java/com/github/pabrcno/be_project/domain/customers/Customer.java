package com.github.pabrcno.be_project.domain.customers;

import com.bol.secure.Encrypted;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@RequiredArgsConstructor
@Document(collection = "customers")
@Getter @Setter
public class Customer {
    private String name;
    @Encrypted
    private String password;
    @MongoId
    @Id 
    private String id;
}
