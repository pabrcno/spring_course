package com.github.pabrcno.be_project.infrastructure.products;

import com.github.pabrcno.be_project.domain.products.Product;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("MySqlProductsDao")
public interface MySqlProductsDao extends CrudRepository<Product, Integer> {
}
