package com.github.pabrcno.be_project.service.order;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.github.pabrcno.be_project.domain.cart.Cart;
import com.github.pabrcno.be_project.domain.cart.ICartService;
import com.github.pabrcno.be_project.domain.customers.CustomerResponse;
import com.github.pabrcno.be_project.domain.customers.ICustomersService;
import com.github.pabrcno.be_project.domain.email.IEmailService;
import com.github.pabrcno.be_project.domain.order.IOrderService;
import com.github.pabrcno.be_project.domain.order.Order;
import com.github.pabrcno.be_project.domain.order.OrderProduct;
import com.github.pabrcno.be_project.domain.products.IProductsService;
import com.github.pabrcno.be_project.domain.products.Product;
import com.github.pabrcno.be_project.handle.exceptions.ApiRestTokenException;
import com.github.pabrcno.be_project.infrastructure.order.OrderRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OrderService implements IOrderService{
    private final OrderRepository repo;
    private final ICustomersService customersService;
    private final ICartService cartService;
    private final IProductsService productService;
    private final IEmailService emailService;

    @Override
    public Order createOrder(String cartId) throws ApiRestTokenException {
        Cart cart = cartService.getCart(cartId).orElse(null);
        if(cart == null) {
            throw new ApiRestTokenException("Cart not found");
        }
        CustomerResponse customer = customersService.getCustomerById(cart.getCustomerId());    
        List<OrderProduct> orderProducts = new ArrayList<>();
        cart.getProducts().forEach(cartProduct -> {
            Product product = productService.getProductById(cartProduct.getProductId()).orElse(null);
            OrderProduct orderProduct = OrderProduct.builder()
                    .productName(product.getName())
                    .productPrice(product.getPrice())
                    .productDescription(product.getDescription())
                    .quantity(cartProduct.getQuantity())
                    .build();
            orderProducts.add(orderProduct);
        });
        Order order = Order.builder()
                .customerEmail(customer.getEmail())
                .deliverAddress(cart.getDeliverAddress())
                .products(orderProducts)
                .build();
        emailService.sendOrderConfirmationEmail(customer.getEmail(), order);
        return repo.save(order);
    }

    @Override
    public Optional<Order> getOrderById(String orderId) {
        return repo.findById(orderId);
    }

    @Override
    public void deleteOrder(String orderId) {
        repo.deleteById(orderId);
    }

    @Override
    public void updateOrderStatus(String orderId, String status) {
        Optional<Order> order = getOrderById(orderId);
        if(order.isPresent()) {
            order.get().setStatus(status);
            repo.save(order.get());
        }   
    }

    @Override
    public List<Order> getAllOrders() {
        return repo.findAll();
    }
}
