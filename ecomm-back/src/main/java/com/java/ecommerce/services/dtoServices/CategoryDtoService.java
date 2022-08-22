package com.java.ecommerce.services.dtoServices;

import com.java.ecommerce.dto.CategoryDto;

import java.util.List;

public interface CategoryDtoService {
    List<CategoryDto> getAllCategories();
    CategoryDto getCategoryById(Long id);
    CategoryDto createCategory( CategoryDto dto);
    CategoryDto updateCategory(Long id, CategoryDto dto);
    public void deleteCategoryById(Long id);
}
