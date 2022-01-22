package com.github.pabrcno.be_project.controller_test;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.pabrcno.be_project.domain.products.Product;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.Assert;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

@SpringBootTest
@AutoConfigureAfter
public class ProductsControllerTest {
    // create tests for ProductsController methods

    private final ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @BeforeAll
    static void setup() {
        System.out.println("@BeforeAll - setup");
    }

    @BeforeEach
    void init() {
        System.out.println("@BeforeEach - init");
    }

    @Test
    void testGetAllProducts() throws Exception {
       
        var result = mockMvc.perform(get("/api/v1/products")).andDo(print()).andExpect(status().isOk()).andReturn();
        var content = result.getResponse().getContentAsString();
        var products = mapper.readValue(content, List.class);

        Assert.notNull(products, "Products list is null");
        Assert.notEmpty(products, "Products list is empty");
        Assert.isTrue(products.size() == 5, "Products list size is not 5");
    }

    @Test
    void testGetProductById() throws Exception {
        var result = mockMvc.perform(get("/api/v1/products/1")).andDo(print()).andExpect(status().isOk()).andReturn();
        var content = result.getResponse().getContentAsString();
        var product = mapper.readValue(content, Product.class);

        Assert.notNull(product, "Product is null");
        Assert.isTrue(product.getId().equals("1"), "Product id is not 1");
        Assert.isTrue(product.getName().equals("Product 1"), "Product name is not Product 1");
        Assert.isTrue(product.getStock() == 10, "Product stock is not 10");
    }

    @Test
    void testEmptyProductStock() throws Exception {
        var result = mockMvc.perform(get("/api/v1/products/1/emptyStock")).andDo(print()).andExpect(status().isOk()).andReturn();
        var content = result.getResponse().getContentAsString();
        var product = mapper.readValue(content, Product.class);

        Assert.notNull(product, "Product is null");
        Assert.isTrue(product.getId().equals("1"), "Product id is not 1");
        Assert.isTrue(product.getName().equals("Product 1"), "Product name is not Product 1");
        Assert.isTrue(product.getStock() == 0, "Product stock is not 0");
    }

    @Test
    void testUpdateProductStock() throws Exception {
        var result = mockMvc.perform(get("/api/v1/products/1/updateStock/5")).andDo(print()).andExpect(status().isOk()).andReturn();
        var content = result.getResponse().getContentAsString();
        var product = mapper.readValue(content, Product.class);

        Assert.notNull(product, "Product is null");
        Assert.isTrue(product.getId().equals("1"), "Product id is not 1");
        Assert.isTrue(product.getName().equals("Product 1"), "Product name is not Product 1");
        Assert.isTrue(product.getStock() == 5, "Product stock is not 5");
    }

    @Test
    void testDeleteProduct() throws Exception {
        var result = mockMvc.perform(get("/api/v1/products/1/delete")).andDo(print()).andExpect(status().isOk()).andReturn();
        var content = result.getResponse().getContentAsString();
        var product = mapper.readValue(content, Product.class);

        Assert.notNull(product, "Product is null");
        Assert.isTrue(product.getId().equals("1"), "Product id is not 1");
        Assert.isTrue(product.getName().equals("Product 1"), "Product name is not Product 1");
        Assert.isTrue(product.getStock() == 0, "Product stock is not 0");
    }
    
    
}
