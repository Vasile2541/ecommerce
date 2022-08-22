package com.java.ecommerce.services.dtoServicesImpl;

import com.java.ecommerce.dto.ProductDto;
import com.java.ecommerce.maper.CategoryMapper;
import com.java.ecommerce.model.Product;
import com.java.ecommerce.services.ProductPageDto;
import com.java.ecommerce.services.dtoServices.ProductDtoService;
import com.java.ecommerce.services.managerServices.ProductManager;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProductDtoServiceImpl implements ProductDtoService {

    private final ProductManager manager;
    private final CategoryMapper mapper;

    public ProductDtoServiceImpl(ProductManager manager, CategoryMapper mapper) {
        this.manager = manager;
        this.mapper = mapper;
    }

//    public List<ProductDto> getAllProducts() {
//        List<Product> products = manager.getAllProducts();
//        return  products.stream()
//                .map(p -> new ProductDto(
//                        p.getId(),
//                        p.getSku(),
//                        p.getName(),
//                        p.getDescription(),
//                        p.getUnitPrice(),
//                        p.getImageUrl(),
//                        true,
//                        p.getUnitsInStock(),
//                        p.getDateCreated(),
//                        p.getLastUpdated(),
//                        p.getCategory().getId())
//                )
//                .collect(Collectors.toList());
//    }
    public ProductPageDto getAllProductsPaginated(int pageNo, int pageSize, String sortBy, String sortDir) {
        Page<Product> productPage = manager.getAllProductsPaginated(pageNo, pageSize, sortBy, sortDir) ;

        List<Product> productList = productPage.getContent();

        List<ProductDto> productDtoList = productList.stream()
                .map(p -> new ProductDto(
                        p.getId(),
                        p.getSku(),
                        p.getName(),
                        p.getDescription(),
                        p.getUnitPrice(),
                        p.getImageUrl(),
                        true,
                        p.getUnitsInStock(),
                        p.getDateCreated(),
                        p.getLastUpdated(),
                        p.getCategory().getId())
                ).toList();

        ProductPageDto productResponseDto = new ProductPageDto(
                productDtoList,
                new ProductPageDto.ProductPageMetadata(
                    productPage.getNumber(),
                    productPage.getSize(),
                    productPage.getTotalElements(),
                    productPage.getTotalPages(),
                    productPage.isLast()
                )
        );
        return productResponseDto;
    }

    public ProductDto getProductById(Long id) {
        Product p = manager.getProductById(id);
        return new ProductDto(
                p.getId(),
                p.getSku(),
                p.getName(),
                p.getDescription(),
                p.getUnitPrice(),
                p.getImageUrl(),
                true,
                p.getUnitsInStock(),
                p.getDateCreated(),
                p.getLastUpdated(),
                p.getCategory().getId());
    }

    public List<ProductDto> getProductsByCategoryId(Long id) {
        List<Product> products = manager.getProductsByCategoryId(id);
        return  products.stream()
                .map(p -> new ProductDto(
                        p.getId(),
                        p.getSku(),
                        p.getName(),
                        p.getDescription(),
                        p.getUnitPrice(),
                        p.getImageUrl(),
                        true,
                        p.getUnitsInStock(),
                        p.getDateCreated(),
                        p.getLastUpdated(),
                        p.getCategory().getId())
                )
                .collect(Collectors.toList());

    }

    public List<ProductDto> findProductByNameContaining(String name) {
        List<Product> products = manager.findProductByNameContaining(name);
        return  products.stream()
                .map(p -> new ProductDto(
                        p.getId(),
                        p.getSku(),
                        p.getName(),
                        p.getDescription(),
                        p.getUnitPrice(),
                        p.getImageUrl(),
                        true,
                        p.getUnitsInStock(),
                        p.getDateCreated(),
                        p.getLastUpdated(),
                        p.getCategory().getId())
                )
                .collect(Collectors.toList());
    }

    public void createProduct(ProductDto productDto) {

    }


}
