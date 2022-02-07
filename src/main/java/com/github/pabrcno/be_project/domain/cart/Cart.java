package com.github.pabrcno.be_project.domain.cart;

import java.util.List;

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
@Document(collection = "carts")
@Builder
@Getter @Setter
public class Cart {
    @Id
    String id;
    String customerId;
    List<CartProduct> products;
}
