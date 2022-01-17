package com.github.pabrcno.be_project.domain.products;

import java.util.UUID;

import com.github.pabrcno.be_project.domain.core.Observer.IObserver;

public interface IProductsDao {
        Product[] getAllProducts();
        void addProduct(Product product);
        Product getProductById(UUID productId);
        void emptyProductStock(UUID productId);
        void updateProductStock(UUID productId, int stock);
        void addObserver(UUID productId,IObserver user);
        void removeObserver(UUID productId, IObserver observer);

}
