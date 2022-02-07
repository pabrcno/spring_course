package com.github.pabrcno.be_project.domain.cart;

import java.util.Optional;

public interface ICartService {
    void addProduct(String cartId, CartProductRequest product);
    void removeProduct(String cartId, String productId);
    void updateProduct(String cartId, CartProductRequest product);
    void clearCart(String cartId);
    Optional<Cart> getCart(String cartId);
    Cart createCart(String customerId);
    Optional<Cart> getCartByCustomerId(String customerId);
}
