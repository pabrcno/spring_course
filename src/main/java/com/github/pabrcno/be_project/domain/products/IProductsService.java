package com.github.pabrcno.be_project.domain.products;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface IProductsService {
        List<Product> getAllProducts();
        void addProduct(Product product);
        Optional<Product> getProductById(Integer productId);
        void emptyProductStock(Integer productId);
        void updateProductStock(Integer productId, int stock);
        void deleteProduct(Integer productId);
        void addObserver(Integer productId,UUID customerId);
        void removeObserver(Integer productId, UUID customerId);
}
