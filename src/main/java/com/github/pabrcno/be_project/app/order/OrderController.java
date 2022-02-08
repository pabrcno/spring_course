package com.github.pabrcno.be_project.app.order;

import java.util.List;
import java.util.Optional;

import com.github.pabrcno.be_project.domain.order.IOrderService;
import com.github.pabrcno.be_project.domain.order.Order;
import com.github.pabrcno.be_project.handle.exceptions.ApiRestTokenException;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RequestMapping("/api/v1/orders")
@RestController
@AllArgsConstructor
public class OrderController {
    private final IOrderService orderService;

    @RequestMapping("")
    public List<Order> getAllOrders() {
        return orderService.getAllOrders();
    }
    
    @RequestMapping("{orderId}")
    public Optional<Order> getOrderById(@PathVariable("orderId") String orderId) {
        return orderService.getOrderById(orderId);
    }

    @PatchMapping("{orderId}/status/{status}")
    public void updateOrderStatus(@PathVariable("orderId") String orderId, @PathVariable("status") String status) {
        orderService.updateOrderStatus(orderId, status);
    }

    @DeleteMapping("{orderId}")
    public void deleteOrder(@PathVariable("orderId") String orderId) {
        orderService.deleteOrder(orderId);
    }
    
    @PostMapping("{cartId}")
    public Order createOrder(@PathVariable("cartId") String cartId) throws ApiRestTokenException {
        return orderService.createOrder(cartId);
    }
}
