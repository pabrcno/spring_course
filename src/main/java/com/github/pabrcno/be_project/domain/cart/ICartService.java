package com.github.pabrcno.be_project.domain.cart;

import java.util.Optional;

import com.github.pabrcno.be_project.handle.exceptions.ApiRestTokenException;

public interface ICartService {
    void addProduct(String cartId, CartProduct product) throws ApiRestTokenException;
    void removeProduct(String cartId, String productId) throws ApiRestTokenException;
    void updateProduct(String cartId, CartProduct product) throws ApiRestTokenException;
    void clearCart(String cartId);
    Optional<Cart> getCart(String cartId);
    Cart createCart(CartRequest cart);
    Optional<Cart> getCartByCustomerId(String customerId);
}
