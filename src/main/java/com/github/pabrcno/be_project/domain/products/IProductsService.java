package com.github.pabrcno.be_project.domain.products;

import java.util.List;
import java.util.Optional;



public interface IProductsService {
        List<Product> getAllProducts();
        void addProduct(Product product);
        Optional<Product> getProductById(String productId);
        void emptyProductStock(String productId);
        void updateProductStock(String productId, int stock);
        void deleteProduct(String productId);
}
