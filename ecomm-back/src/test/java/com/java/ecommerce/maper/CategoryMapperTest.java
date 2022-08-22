package com.java.ecommerce.maper;

import com.java.ecommerce.dto.CategoryDto;
import com.java.ecommerce.model.Category;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CategoryMapperTest {
    public static final long ID = 2L;
    public static final String NAME = "vasile";

    CategoryMapper mapper = CategoryMapper.INSTANCE;

    @Test
    public void categoryToCategoryDto() {
        
        Category category = new Category();
        category.setName(NAME);
        category.setId(ID);

        CategoryDto categoryDto = mapper.categoryToCategoryDto(category);

        assertEquals(Long.valueOf(ID), categoryDto.getId());
        assertEquals(NAME, categoryDto.getName());
    }
}