package com.github.pabrcno.be_project.app.cart;

import java.util.Optional;

import com.github.pabrcno.be_project.domain.cart.Cart;
import com.github.pabrcno.be_project.domain.cart.CartProductRequest;
import com.github.pabrcno.be_project.domain.cart.CartRequest;
import com.github.pabrcno.be_project.domain.cart.ICartService;
import com.github.pabrcno.be_project.handle.exceptions.ApiRestTokenException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RequestMapping("/api/v1/cart")
@RestController
@AllArgsConstructor
public class CartController {
    
    final ICartService cartService;

    @PatchMapping(path = "add/{cartId}")
    public void addProduct(@PathVariable("cartId") String cartId, @RequestBody CartProductRequest cartProductRequest) throws ApiRestTokenException {
        cartService.addProduct(cartId, cartProductRequest);
    }
    @PatchMapping(path = "remove/{cartId}/{productId}")
    public void removeProduct(@PathVariable("cartId") String cartId,@PathVariable("productId") String productId) throws ApiRestTokenException {
        cartService.removeProduct(cartId, productId);
    }
    @PatchMapping(path= "{cartId}")
    public void updateProduct(@PathVariable("cartId") String cartId, @RequestBody CartProductRequest cartProductRequest) throws ApiRestTokenException {
        cartService.updateProduct(cartId, cartProductRequest);
    }
    @PatchMapping(path= "clear/{cartId}")
    public void clearCart(@PathVariable("cartId") String cartId) {
        cartService.clearCart(cartId);
    }
    @GetMapping(path= "{cartId}")
    public Optional<Cart> getCart(@PathVariable("cartId") String cartId) {
        return cartService.getCart(cartId);
    }
    @PostMapping(path= "create")
    public Cart createCart(@RequestBody CartRequest cart) {
        return cartService.createCart(cart);
    }
    
}
