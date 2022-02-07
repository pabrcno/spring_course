package com.github.pabrcno.be_project.domain.cart;

import java.util.Optional;

import com.github.pabrcno.be_project.handle.exceptions.ApiRestTokenException;

public interface ICartService {
    void addProduct(String cartId, CartProductRequest product) throws ApiRestTokenException;
    void removeProduct(String cartId, String productId) throws ApiRestTokenException;
    void updateProduct(String cartId, CartProductRequest product) throws ApiRestTokenException;
    void clearCart(String cartId);
    Optional<Cart> getCart(String cartId);
    Cart createCart(String customerId);
    Optional<Cart> getCartByCustomerId(String customerId);
}
