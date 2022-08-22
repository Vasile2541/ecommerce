package com.java.ecommerce.controller;

import com.java.ecommerce.dto.CategoryDto;
import com.java.ecommerce.exceptions.customExceptions.InvalidInputException;
import com.java.ecommerce.services.dtoServicesImpl.CategoryDtoServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController//combines @Controller and @ResponseBody(de aceia nu mai este nevoie de ResponseEntity si doar adaugam @ResponseStatus(HttpStatus.OK)// )
//@ResponseEntity is basicaly the same as @ResponseBody this why we can use is instea of @ResponseEntity(givs us little bit more control)
@CrossOrigin
//@CrossOrigin("http://localhost:4200")
@RequestMapping("/api/categories")
public class CategoryController {

    private final CategoryDtoServiceImpl dtoService;
    public CategoryController(CategoryDtoServiceImpl dtoService) {
        this.dtoService = dtoService;
    }

//    Done
    @GetMapping ///sau asa fara ResponseEntity daca clasa este adnotata cu @RestControlelr
    @ResponseStatus(HttpStatus.OK)
    public List<CategoryDto> getAllCategories(){
        return dtoService.getAllCategories();
    }

    //done
    @GetMapping("/{id}")
    public ResponseEntity<CategoryDto> getCategoryById( @Valid @PathVariable Long id){
        //sterg asta daca ma lamuresc cu @Valid
        if(null == id || id.equals(0L)) {
            throw new InvalidInputException("Employee Id is not valid, id=", id);
        }
        CategoryDto category = dtoService.getCategoryById(id);
        return ResponseEntity.status(HttpStatus.OK).body(category);
    }

    //done
    @PostMapping
    public ResponseEntity<CategoryDto> createCategory( @RequestBody CategoryDto categoryDto ){
        CategoryDto createdCategoryDto = dtoService.createCategory(categoryDto);
        log.info("createdDTO"+ createdCategoryDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdCategoryDto);
    }

    //done
    @PutMapping("/{id}")
    public ResponseEntity<CategoryDto> updateCategory(
            @PathVariable Long id,
            @RequestBody CategoryDto categoryDto){
        CategoryDto updatedCategory = dtoService.updateCategory(id, categoryDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(updatedCategory);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteCategoryById(@PathVariable Long id){
        dtoService.deleteCategoryById(id);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Delete Category","Category with id="+id+" deleted!");

        return new ResponseEntity<> (headers, HttpStatus.ACCEPTED);

    }
}
