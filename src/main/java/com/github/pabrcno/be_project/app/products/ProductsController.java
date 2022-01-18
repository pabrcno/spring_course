package com.github.pabrcno.be_project.app.products;
import java.util.UUID;
import com.github.pabrcno.be_project.domain.products.IProductsService;
import com.github.pabrcno.be_project.domain.products.Product;
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
    IProductsService productsService;

    @Autowired
    public ProductsController(IProductsService productsService) {
        this.productsService = productsService;
        
    }

    @GetMapping
    public Product[] getAllProducts() {
        return productsService.getAllProducts();
    }
    
    @PostMapping
    public void addProduct(@RequestBody Product product) {
        productsService.addProduct(product);
    }

    @GetMapping(path="{productId}")
    public Product getProductById(@PathVariable("productId") UUID productId) {
        return productsService.getProductById(productId);
    }

    @PatchMapping(path="{productId}/emptyStock")
    public void emptyProductStock( @PathVariable("productId") UUID productId) {
        productsService.emptyProductStock(productId);
    }

    @PatchMapping(path= "{productId}/updateStock")
    public void updateProductStock ( @PathVariable("productId") UUID productId, @RequestBody int stock) {
        productsService.updateProductStock(productId, stock);
    }

    @PatchMapping(path ="{productId}/{customerId}/addObserver")
    public void addObserver(@PathVariable("productId") UUID productId, @PathVariable("customerId") UUID customerId) {
        productsService.addObserver(productId, customerId);
    }

    @PatchMapping(path= "{productId}/{customerId}/removeObserver")
    public void removeObserver(@PathVariable("productId") UUID productId, @PathVariable("customerId") UUID customerId) {
        productsService.removeObserver(productId, customerId);
    }
}
