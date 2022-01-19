package com.github.pabrcno.be_project.domain.products;


import com.github.pabrcno.be_project.domain.core.Observer.IObserver;

public interface IProductsDao {
        Product[] getAllProducts();
        void addProduct(Product product);
        Product getProductById(Integer productId);
        void emptyProductStock(Integer productId);
        void updateProductStock(Integer productId, int stock);
        void addObserver(Integer productId,IObserver user);
        void removeObserver(Integer productId, IObserver observer);

}
