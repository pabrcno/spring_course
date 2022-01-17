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
        LOGGER.info("getAllProducts");
        return products.toArray(new Product[products.size()]);
    }

    @Override
    public void addProduct(Product product) {
        if (product == null) {
            throw new FirstApplicationException("Product is null");
        }
        
        if (product.getName() == null || product.getName().isEmpty()) {
            throw new FirstApplicationException("Product name is null");
        }
        
        if ( product.getPrice() < 0) {
            throw new FirstApplicationException("Product price cant be negative");
        }
        if( products.stream().filter(p -> p.getName().equals(product.getName())).count() > 0 ){
            throw new FirstApplicationException("Product already exists");
        }
        LOGGER.info("Adding product: " + product.getName());
        products.add(product);
    }

    @Override
    public Product getProductById(UUID productId) {
        LOGGER.info("Getting product with id: " + productId);
        return products.stream().filter(p -> p.getId().equals(productId)).findFirst().orElse(null);
    }

    @Override
    public void emptyProductStock(UUID productId) {
        LOGGER.info("Emptying product stock with id: " + productId);
        Product product = getProductById(productId);
        if (product == null) {
            throw new FirstApplicationException("Product not found");
        }
        product.setStock(0);
        product.setAvailable();
    }

    @Override
    public void updateProductStock(UUID productId, int stock) {
        LOGGER.info("Updating product stock with id: " + productId);
        Product product = getProductById(productId);
        if (product == null) {
            throw new FirstApplicationException("Product not found");
        }
        product.setStock(stock);
        product.setAvailable();
    }

    @Override
    public void addObserver(UUID productId, IObserver observer) {
        LOGGER.info("Adding observer to product with id: " + productId);
        Product product = getProductById(productId);
        if (product == null) {
            throw new FirstApplicationException("Product not found");
        }
        product.registerObserver(observer);
    }

    @Override
    public void removeObserver(UUID productId, IObserver observer) {
        LOGGER.info("Removing observer from product with id: " + productId);
        Product product = getProductById(productId);
        if (product == null) {
            throw new FirstApplicationException("Product not found");
        }
        product.removeObserver(observer);
        
    }
}
