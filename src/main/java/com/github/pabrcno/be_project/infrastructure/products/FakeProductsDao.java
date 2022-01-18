package com.github.pabrcno.be_project.infrastructure.products;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.github.pabrcno.be_project.domain.core.FirstApplicationException;
import com.github.pabrcno.be_project.domain.core.Observer.IObserver;
import com.github.pabrcno.be_project.domain.products.IProductsDao;
import com.github.pabrcno.be_project.domain.products.Product;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;
@Repository("fakeProductsDao")
public class FakeProductsDao implements IProductsDao {

    private static List<Product> products = new ArrayList<Product>();
    private static final Logger LOGGER = LogManager.getLogger(FakeProductsDao.class);
    
    @Override
    public Product[] getAllProducts() {
        
        return products.toArray(new Product[products.size()]);
    }

    @Override
    public void addProduct(Product product) {
     
        products.add(product);
    }

    @Override
    public Product getProductById(UUID productId) {
        return products.stream().filter(p -> p.getId().equals(productId)).findFirst().orElse(null);
    }

    @Override
    public void emptyProductStock(UUID productId) {
        Product product = getProductById(productId);
        if (product == null) {
            throw new FirstApplicationException("Product not found");
        }
        product.setStock(0);
        product.setAvailable();
    }

    @Override
    public void updateProductStock(UUID productId, int stock) {
        Product product = getProductById(productId);
        if (product == null) {
            throw new FirstApplicationException("Product not found");
        }
        product.setStock(stock);
        product.setAvailable();
    }

    @Override
    public void addObserver(UUID productId, IObserver observer) {
        Product product = getProductById(productId);
        if (product == null) {
            throw new FirstApplicationException("Product not found");
        }
        product.registerObserver(observer);
    }

    @Override
    public void removeObserver(UUID productId, IObserver observer) {
        Product product = getProductById(productId);
        if (product == null) {
            throw new FirstApplicationException("Product not found");
        }
        product.removeObserver(observer);
        
    }
}
