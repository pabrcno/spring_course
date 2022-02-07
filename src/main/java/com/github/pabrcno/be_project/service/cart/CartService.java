package com.github.pabrcno.be_project.service.cart;

import java.util.Optional;

import com.github.pabrcno.be_project.domain.cart.Cart;
import com.github.pabrcno.be_project.domain.cart.CartProduct;
import com.github.pabrcno.be_project.domain.cart.CartProductRequest;
import com.github.pabrcno.be_project.domain.cart.CartRequest;
import com.github.pabrcno.be_project.domain.cart.ICartService;
import com.github.pabrcno.be_project.handle.exceptions.ApiRestTokenException;
import com.github.pabrcno.be_project.infrastructure.cart.CartRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class CartService implements ICartService{
    private final CartRepository repo;

    @Override
    public void addProduct(String cartId, CartProductRequest productReq) throws ApiRestTokenException  {
        Cart cart = getCart(cartId).orElse(null);
        if(cart == null) {
            throw new ApiRestTokenException("Customer not found");
        }   
        CartProduct cartProduct = CartProduct.builder()
                .productId(productReq.getProductId())
                .quantity(productReq.getQuantity())
                .build();
        cart.getProducts().add(cartProduct);
        repo.save(cart);
    }

    @Override
    public void removeProduct(String cartId, String productId) throws ApiRestTokenException {
        Optional<Cart> cart = getCart(cartId);
        if(cart == null) {
            throw new ApiRestTokenException("Customer not found");
        }   
        cart.get().getProducts().removeIf(p -> p.getProductId().equals(productId));
        repo.save(cart.get());
        
    }

    @Override
    public void updateProduct(String cartId, CartProductRequest productReq) throws ApiRestTokenException {
        Cart cart = getCart(cartId).orElse(null);
        if(cart == null) {
            throw new ApiRestTokenException("Customer not found");
        }   
        CartProduct cartProduct = cart.getProducts().stream()
                .filter(cartProduct1 -> cartProduct1.getProductId().equals(productReq.getProductId()))
                .findFirst()
                .orElse(null);
        cartProduct.setQuantity(productReq.getQuantity());
        repo.save(cart);
    }

    @Override
    public void clearCart(String cartId) {
        Cart cart = getCart(cartId).orElse(null);
        cart.getProducts().clear();
        repo.save(cart);
    }

    @Override
    public Optional<Cart> getCart(String cartId) {
        return repo.findById(cartId);
    }

    @Override
    public Cart createCart(CartRequest cartRequest) {
        Cart cart = Cart.from(cartRequest);
        repo.save(cart);
        return cart;
    }

    @Override
    public Optional<Cart> getCartByCustomerId(String customerId) {
        return repo.findByCustomerId(customerId);
    }}
    

