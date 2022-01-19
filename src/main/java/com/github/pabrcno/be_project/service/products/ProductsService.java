package com.github.pabrcno.be_project.service.products;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.github.pabrcno.be_project.domain.core.annotations.VerifyProduct;
import com.github.pabrcno.be_project.domain.customers.ICustomersDao;

import com.github.pabrcno.be_project.domain.products.IProductsService;
import com.github.pabrcno.be_project.domain.products.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class ProductsService implements IProductsService{
    ICustomersDao customersDao;
    CrudRepository<Product, Integer> productsDao;

    @Autowired
    public ProductsService( 
        @Qualifier("MySqlProductsDao") CrudRepository<Product,Integer> productsDao,
        @Qualifier("fakeCustomersDao") ICustomersDao customersDao) {
        this.productsDao = productsDao;
        this.customersDao = customersDao;
    }
   
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
    public Optional<Product> getProductById( Integer productId) {
        return productsDao.findById(productId);
    }

    @Override
    public void emptyProductStock( Integer productId) {
        productsDao.findById(productId).ifPresent(product -> product.setStock(0));
    }

    @Override
    public void updateProductStock ( Integer productId, int stock) {
        productsDao.findById(productId).ifPresent(product -> product.setStock(stock));
    }

    @Override
    public void deleteProduct(Integer productId) {
        productsDao.deleteById(productId);
        
    } 

    @Override
    public void addObserver(Integer productId,  UUID customerId) {
        // Customer customer = customersDao.getCustomerById(customerId);
        // productsDao.addObserver(productId, customer);
    }

    @Override
    public void removeObserver( Integer productId,  UUID customerId) {
        // Customer customer = customersDao.getCustomerById(customerId);
        // productsDao.removeObserver(productId, customer);
    }

   
}
