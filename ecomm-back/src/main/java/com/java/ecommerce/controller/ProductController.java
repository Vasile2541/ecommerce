package com.java.ecommerce.controller;

import com.java.ecommerce.config.AppConstant;
import com.java.ecommerce.dto.ProductDto;
import com.java.ecommerce.services.ProductPageDto;
import com.java.ecommerce.services.dtoServicesImpl.ProductDtoServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@CrossOrigin
//@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/products")
public class ProductController {
    private final ProductDtoServiceImpl dtoService;

    public ProductController(ProductDtoServiceImpl dtoService) {
        this.dtoService = dtoService;
    }
//
//    @GetMapping
//    public List<ProductDto> getAllProducts(){
//        return dtoService.getAllProducts();
//    }

    // page isn't a Resource, encoding the page information in the URI isn't an option.
    @GetMapping(params = { "page", "size", "sortBy", "sortDir" })
    public ProductPageDto getAllProductsPaginated(
            @RequestParam(defaultValue = AppConstant.DEFAULT_PAGE_NUMBER) int page,
            @RequestParam(defaultValue = AppConstant.DEFAULT_PAGE_SIZE)   int size,
            @RequestParam(defaultValue = AppConstant.DEFAULT_SORT_BY,        required = false) String sortBy,
            @RequestParam(defaultValue = AppConstant.DEFAULT_SORT_DIRECTION, required = false) String sortDir) {
        log.info("Request for  getAllProductsPaginated() !");
        return dtoService.getAllProductsPaginated(page, size, sortBy, sortDir);
    }


    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable Long id){
        return dtoService.getProductById(id);
    }

    //Done
    @GetMapping("/search/byCategoryID/{id}")
    public ResponseEntity<List<ProductDto>> getProductsByCategoryId(@PathVariable Long id){
        List<ProductDto> products = dtoService.getProductsByCategoryId(id);
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    @GetMapping("/search/findByNameContaining")
    public ResponseEntity<List<ProductDto>> findProductByNameContaining(@RequestParam String name){
        List<ProductDto> products = dtoService.findProductByNameContaining(name);
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }

    @PostMapping
    public String createCategory(@RequestBody ProductDto productDto){
        dtoService.createProduct(productDto);
        return "getAllCategories()";
    }

    @PutMapping
    public String updateCategory(@RequestBody ProductDto productDto){
        return "getAllCategories()";

    }

    @DeleteMapping("/{id}")
    public String deleteCategory(@PathVariable Integer id){
        return "getAllCategories()";

    }




}
