package com.github.pabrcno.be_project.service.products;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


import com.github.pabrcno.be_project.domain.core.annotations.VerifyProduct;


import com.github.pabrcno.be_project.domain.products.IProductsService;
import com.github.pabrcno.be_project.domain.products.Product;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductsService implements IProductsService{
    @Autowired
    MongoRepository<Product, String> productsDao;

   
    @Override
    public List<Product> getAllProducts() {
        List<Product> products = new ArrayList<Product>();
        productsDao.findAll().forEach(products::add);
        return products;
    }
    
    @VerifyProduct
    @Override
    public void addProduct(Product product) {
        productsDao.save(product);
    }

    @Override
    public Optional<Product> getProductById( String productId) {
        return productsDao.findById(productId);
    }

    @Override
    public void emptyProductStock( String productId) {
        productsDao.findById(productId).ifPresent(product -> product.setStock(0));
    }

    @Override
    public void updateProductStock ( String productId, int stock) {
        productsDao.findById(productId).ifPresent(product -> product.setStock(stock));
    }

    @Override
    public void deleteProduct(String productId) {
        productsDao.deleteById(productId);
        
    } 
}
