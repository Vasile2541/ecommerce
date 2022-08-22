package com.java.ecommerce.services.dtoServices;

import com.java.ecommerce.services.ProductPageDto;

public interface ProductDtoService {
    ProductPageDto getAllProductsPaginated(int pageNo, int pageSize, String sortBy, String sortDir);
}
