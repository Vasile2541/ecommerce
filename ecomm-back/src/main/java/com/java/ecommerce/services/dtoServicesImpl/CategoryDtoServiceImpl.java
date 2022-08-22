package com.java.ecommerce.services.dtoServicesImpl;

import com.java.ecommerce.dto.CategoryDto;
import com.java.ecommerce.maper.CategoryMapper;
import com.java.ecommerce.model.Category;
import com.java.ecommerce.services.dtoServices.CategoryDtoService;
import com.java.ecommerce.services.managerServices.CategoryManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CategoryDtoServiceImpl implements CategoryDtoService {
    private final CategoryManager manager;
    private final CategoryMapper mapper;

    public CategoryDtoServiceImpl(CategoryManager manager, CategoryMapper mapper) {
        this.manager = manager;
        this.mapper = mapper;
    }

    public List<CategoryDto> getAllCategories(){
        List<Category> categories = manager.getAllCategories();

        return categories.stream()
                .map(mapper::categoryToCategoryDto)
                .toList();
    }

    public CategoryDto getCategoryById(Long id){
        return mapper.categoryToCategoryDto(manager.getCategoryById(id));
    }

    public CategoryDto createCategory( CategoryDto dto){
        Category createdCategory =  manager.createCategory( new Category(dto.getName()));
        log.info("createdCateg"+ createdCategory);
        return mapper.categoryToCategoryDto(manager.updateCategory(createdCategory));
    }

    public CategoryDto updateCategory(Long id, CategoryDto dto){
        Category category = new Category( id, dto.getName() );

        Category updatedCategory = manager.updateCategory(category);
        return new CategoryDto(updatedCategory.getId(), updatedCategory.getName());
    }

    public void deleteCategoryById(Long id) {
        manager.deleteCategoryById(id);
    }
}
