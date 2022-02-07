package com.github.pabrcno.be_project.domain.cart;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Getter @Setter
public class CartProductRequest {
    private String productId;
    private Integer quantity;
}
