package com.java.ecommerce.maper;

import com.java.ecommerce.dto.CategoryDto;
import com.java.ecommerce.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CategoryMapper {

    CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    CategoryDto categoryToCategoryDto(Category category);
}
