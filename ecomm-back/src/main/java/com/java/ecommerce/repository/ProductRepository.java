package com.java.ecommerce.repository;

import com.java.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


public interface ProductRepository extends JpaRepository<Product, Long> {

//    List<Product> findPaginated(int pageNo, int pageSize);

    List<Product> findProductsByCategoryId(@RequestParam("id") Long id);
//    Page<Product> findProductsByCategoryId(@RequestParam("id") Long id, Pageable pageable);


    List<Product> findProductByNameContaining(@RequestParam("name") String name);

    Product getProductById(Long id);
}
