package com.github.pabrcno.be_project.domain.order;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Getter @Setter
public class OrderProduct {
    private String productName;
    private String productDescription;
    private double productPrice;
    private int quantity;
}
