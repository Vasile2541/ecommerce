package com.java.ecommerce.repository;

import com.java.ecommerce.model.Category;

import org.springframework.data.jpa.repository.JpaRepository;

//@RepositoryRestResource(collectionResourceRel = "productCategory", path = "product-category")
//name of JSON entity , path
public interface CategoryRepository extends JpaRepository<Category, Long> {

}
