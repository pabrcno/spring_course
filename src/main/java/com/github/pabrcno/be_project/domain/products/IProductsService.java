package com.github.pabrcno.be_project.domain.products;

import java.util.List;
import java.util.Optional;


public interface IProductsService {
        List<Product> getAllProducts();
        void addProduct(Product product);
        Optional<Product> getProductById(String productId);
        void deleteProduct(String productId);
        Optional<List<Product>> getProductsByCategory(String category);
}
