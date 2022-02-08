package com.github.pabrcno.be_project.domain.order;

import java.util.List;
import java.util.Optional;

import com.github.pabrcno.be_project.handle.exceptions.ApiRestTokenException;

public interface IOrderService {
    Order createOrder(String cartId) throws ApiRestTokenException;
    Optional<Order> getOrderById(String orderId);
    void deleteOrder(String orderId);
    void updateOrderStatus(String orderId, String status);
    List<Order> getAllOrders();
}
