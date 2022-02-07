package com.github.pabrcno.be_project.domain.cart;

import java.util.ArrayList;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.Builder.Default;

@AllArgsConstructor
@RequiredArgsConstructor
@Document(collection = "carts")
@Builder
@Getter @Setter
public class Cart {
    @MongoId
    String id;
    @Default
    String createdAt = LocalDateTime.now().toString();
    String customerId;
    @Default
    List<CartProduct> products= new ArrayList<>();
    String deliverAddress;

    public static Cart from(CartRequest request) {
        return Cart.builder()
                .customerId(request.getCustomerId())
                .deliverAddress(request.getDeliverAddress())
                .build();
    }
}
