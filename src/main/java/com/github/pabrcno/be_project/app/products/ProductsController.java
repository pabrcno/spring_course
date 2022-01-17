package com.github.pabrcno.be_project.app.products;
import java.util.UUID;
import com.github.pabrcno.be_project.domain.products.IProductsDao;
import com.github.pabrcno.be_project.domain.products.Product;
import com.github.pabrcno.be_project.domain.users.IUsersDao;
import com.github.pabrcno.be_project.domain.users.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("/api/v1/products")
@RestController
public class ProductsController {
    IUsersDao usersDao;
    IProductsDao productsDao;

    @Autowired
    public ProductsController(IProductsDao productsDao, IUsersDao usersDao) {
        this.productsDao = productsDao;
        this.usersDao = usersDao;
    }

    @GetMapping
    public Product[] getAllProducts() {
        return productsDao.getAllProducts();
    }
    
    @PostMapping
    public void addProduct(@RequestBody Product product) {
        productsDao.addProduct(product);
    }

    @GetMapping(path="{productId}")
    public Product getProductById(@PathVariable("productId") UUID productId) {
        return productsDao.getProductById(productId);
    }

    @PatchMapping(path="{productId}/emptyStock")
    public void emptyProductStock( @PathVariable("productId") UUID productId) {
        productsDao.emptyProductStock(productId);
    }

    @PatchMapping(path= "{productId}/updateStock")
    public void updateProductStock ( @PathVariable("productId") UUID productId, @RequestBody int stock) {
        productsDao.updateProductStock(productId, stock);
    }

    @PatchMapping(path ="{productId}/{userId}/addObserver")
    public void addObserver(@PathVariable("productId") UUID productId, @PathVariable("userId") UUID userId) {
        User user = usersDao.getUserById(userId);
        productsDao.addObserver(productId, user);
    }

    @PatchMapping(path= "{productId}/{userId}/removeObserver")
    public void removeObserver(@PathVariable("productId") UUID productId, @PathVariable("userId") UUID userId) {
        User user = usersDao.getUserById(userId);
        productsDao.removeObserver(productId, user);
    }
}
