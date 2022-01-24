package com.github.pabrcno.be_project.infrastructure.restaurant;

import com.github.pabrcno.be_project.domain.restaurants.Category;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
 
}
    

