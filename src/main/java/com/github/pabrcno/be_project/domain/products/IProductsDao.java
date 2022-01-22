package com.github.pabrcno.be_project.domain.products;


public interface IProductsDao {
        Product[] getAllProducts();
        void addProduct(Product product);
        Product getProductById(Integer productId);
        void emptyProductStock(Integer productId);
        void updateProductStock(Integer productId, int stock);
}
