package com.github.pabrcno.be_project.app.products;

import java.util.UUID;

import com.github.pabrcno.be_project.domain.products.IProductsDao;
import com.github.pabrcno.be_project.domain.products.Product;
import com.github.pabrcno.be_project.domain.users.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/api/v1/products")
@RestController
public class ProductsController {
    
    IProductsDao productsDao;

    @Autowired
    public ProductsController(IProductsDao productsDao) {
        this.productsDao = productsDao;
    }

    @GetMapping
    public Product[] getAllProducts() {
        return productsDao.getAllProducts();
    }
    
    @PostMapping
    public void addProduct(@RequestBody Product product) {
        productsDao.addProduct(product);
    }

    @GetMapping("{productId}")
    public Product getProductById(UUID productId) {
        return productsDao.getProductById(productId);
    }

    @PostMapping("{productId}/emptyStock")
    public void emptyProductStock(UUID productId) {
        productsDao.emptyProductStock(productId);
    }

    @PostMapping("{productId}/updateStock")
    public void updateProductStock(UUID productId, int stock) {
        productsDao.updateProductStock(productId, stock);
    }

    @PostMapping("{productId}/addObserver")
    public void addObserver(UUID productId, User observer) {
        productsDao.addObserver(productId, observer);
    }

    @PostMapping("{productId}/removeObserver")
    public void removeObserver(UUID productId, User observer) {
        productsDao.removeObserver(productId, observer);
    }
}
