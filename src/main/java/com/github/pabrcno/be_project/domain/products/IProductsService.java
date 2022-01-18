package com.github.pabrcno.be_project.domain.products;

import java.util.UUID;


public interface IProductsService {
    Product[] getAllProducts();
        void addProduct(Product product);
        Product getProductById(UUID productId);
        void emptyProductStock(UUID productId);
        void updateProductStock(UUID productId, int stock);
        void addObserver(UUID productId,UUID customerId);
        void removeObserver(UUID productId, UUID customerId);
}
