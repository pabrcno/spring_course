package com.github.pabrcno.be_project.service.products;

import java.util.List;
import java.util.Optional;

import com.github.pabrcno.be_project.domain.products.IProductsService;
import com.github.pabrcno.be_project.domain.products.Product;
import com.github.pabrcno.be_project.infrastructure.products.ProductRepository;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProductsService implements IProductsService{

    ProductRepository repo;
 
    @Override
    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    @Override
    public void addProduct(Product product) {
        repo.save(product);
    }

    @Override
    public Optional<Product> getProductById(String productId) {
        return repo.findById(productId);
    }
    @Override
    public void deleteProduct(String productId) {
        repo.delete(repo.findById(productId).get());
        
    }

    @Override
    public Optional<List<Product>> getProductsByCategory(String category) {
        return Optional.of(repo.findByCategory(category));
    }   
}
