package com.github.pabrcno.be_project.domain.order;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.Builder.Default;

@AllArgsConstructor
@RequiredArgsConstructor
@Document(collection = "orders")
@Builder
@Getter @Setter
public class Order {
    @Id
    private String id;
    private String customerEmail;
    private String deliverAddress;
    @Default
    private String createdAt = LocalDateTime.now().toString();
    @Default
    private String status = "GENERATED";
    List<OrderProduct> products;
}
    
