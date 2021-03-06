package com.github.pabrcno.be_project.app.products;
import java.util.List;
import java.util.Optional;

import com.github.pabrcno.be_project.domain.products.IProductsService;
import com.github.pabrcno.be_project.domain.products.Product;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;


@RequestMapping("/api/v1/products")
@RestController
@AllArgsConstructor
public class ProductsController {
    IProductsService productsService;


    @GetMapping
    public List<Product> getAllProducts() {
        return productsService.getAllProducts();
    }
    
    @PostMapping
    public void addProduct(@RequestBody Product product) {
        productsService.addProduct(product);
    }

    @GetMapping(path="{productId}")
    public Optional<Product> getProductById(@PathVariable("productId") String productId) {
        return productsService.getProductById(productId);
    }

    @GetMapping(path="category/{category}")
    public Optional<List<Product>> getProductsByCategory(@PathVariable("category") String category) {
        return productsService.getProductsByCategory(category);
    }

}
