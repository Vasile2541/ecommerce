package com.java.ecommerce.services.managerServices;

import com.java.ecommerce.exceptions.customExceptions.EntityNotFoundException;
import com.java.ecommerce.exceptions.customExceptions.NoDataFoundException;
import com.java.ecommerce.model.Category;
import com.java.ecommerce.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryManager {
    private final CategoryRepository repository;

    public CategoryManager(CategoryRepository repository) {
        this.repository = repository;
    }

    public List<Category> getAllCategories() {
        if (repository.findAll().isEmpty()) {
            throw new NoDataFoundException("No Data To be Delivered!");
        }
        return repository.findAll();
    }

    public Category getCategoryById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("No Category with id=", id));
//        return new Category(1111L, "default");
    }

    public Category createCategory(Category category) {
        return repository.save(category);
    }

    public Category updateCategory(Category categoryToUpdate) {
        Category companyToUpdate = getCategoryById(categoryToUpdate.getId());

        companyToUpdate.setName(categoryToUpdate.getName());
        return repository.save(companyToUpdate);
    }

    public void deleteCategoryById(Long id) {
        Category categeryToBeDeleted = getCategoryById(id);
        repository.delete(categeryToBeDeleted);

    }
}

