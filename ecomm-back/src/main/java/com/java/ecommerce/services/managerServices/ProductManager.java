package com.java.ecommerce.services.managerServices;

import com.java.ecommerce.dto.ProductDto;
import com.java.ecommerce.exceptions.customExceptions.NoDataFoundException;
import com.java.ecommerce.model.Product;
import com.java.ecommerce.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductManager {

    private final ProductRepository repository;

    public ProductManager(ProductRepository repository) {
        this.repository = repository;
    }

    public List<Product> getAllProducts() {
        List<Product> products = repository.findAll();
        return products;
    }
    public Page<Product> getAllProductsPaginated(int pageNo, int pageSize, String sortBy, String sortDir) {
        Sort sort = sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortBy).ascending()
                : Sort.by(sortBy).descending();
        Pageable paging = PageRequest.of(pageNo, pageSize, sort);
        Page<Product> pagedResult = repository.findAll(paging);

        return pagedResult;
    }
    public Product getProductById(Long id) {
        return repository.getProductById(id);
    }

    public List<Product> getProductsByCategoryId(Long id) {
//        Pageable pageable = PageRequest.of(1, 10);
//        List<Product> page = repository.findProductsByCategoryId(id, pageable);
        List<Product> page = repository.findProductsByCategoryId(id);

        return page;
    }

    public List<Product> findProductByNameContaining(String name) {
        List<Product> foundProducts = repository.findProductByNameContaining(name);
        if(foundProducts.isEmpty()){
            throw new NoDataFoundException("No data to be found, you searched for:"+ name);
        }
        return  foundProducts;
    }


}
