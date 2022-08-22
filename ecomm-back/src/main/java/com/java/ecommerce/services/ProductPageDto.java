package com.java.ecommerce.services;

import com.java.ecommerce.dto.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductPageDto implements EntityResponse {


    private List<ProductDto> data;
    private ProductPageMetadata metadata;

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class ProductPageMetadata{
        private int pageNo;
        private int pageSize;
        private long totalElements;
        private int totalPages;
        private boolean last;

    }
}
