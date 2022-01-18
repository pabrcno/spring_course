package com.github.pabrcno.be_project.service.products;
import java.util.UUID;
import com.github.pabrcno.be_project.domain.customers.Customer;
import com.github.pabrcno.be_project.domain.customers.ICustomersDao;
import com.github.pabrcno.be_project.domain.products.IProductsDao;
import com.github.pabrcno.be_project.domain.products.IProductsService;
import com.github.pabrcno.be_project.domain.products.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class ProductsService implements IProductsService{
    ICustomersDao customersDao;
    IProductsDao productsDao;

    @Autowired
    public ProductsService( 
        @Qualifier("fakeProductsDao") IProductsDao productsDao,
        @Qualifier("fakeCustomersDao") ICustomersDao customersDao) {
        this.productsDao = productsDao;
        this.customersDao = customersDao;
    }
    @Override
    public Product[] getAllProducts() {
        return productsDao.getAllProducts();
    }
    
    @Override
    public void addProduct(Product product) {
        productsDao.addProduct(product);
    }

    @Override
    public Product getProductById( UUID productId) {
        return productsDao.getProductById(productId);
    }

    @Override
    public void emptyProductStock( UUID productId) {
        productsDao.emptyProductStock(productId);
    }

    @Override
    public void updateProductStock ( UUID productId, int stock) {
        productsDao.updateProductStock(productId, stock);
    }

    @Override
    public void addObserver(UUID productId,  UUID customerId) {
        Customer customer = customersDao.getCustomerById(customerId);
        productsDao.addObserver(productId, customer);
    }

    @Override
    public void removeObserver( UUID productId,  UUID customerId) {
        Customer customer = customersDao.getCustomerById(customerId);
        productsDao.removeObserver(productId, customer);
    } 
}
