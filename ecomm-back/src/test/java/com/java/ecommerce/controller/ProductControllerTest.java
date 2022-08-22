package com.java.ecommerce.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ProductControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @BeforeEach
    void setUp() {
    }

    @Test
    void getAllProductsPaginated() {
//                mockMvc.perform(get("/characters/page")
//                                .param("page", "5")
//                                .param("size", "10")
//                                .param("sort", "id,desc")   // <-- no space after comma!
//                                .param("sort", "name,asc")) // <-- no space after comma!
//                        .andExpect(status().isOk());
//
//                ArgumentCaptor<Pageable> pageableCaptor =
//                        ArgumentCaptor.forClass(Pageable.class);
//                verify(characterRepository).findAllPage(pageableCaptor.capture());
//                PageRequest pageable = (PageRequest) pageableCaptor.getValue();
//
//                assertThat(pageable).hasPageNumber(5);
//                assertThat(pageable).hasPageSize(10);
//                assertThat(pageable).hasSort("name", Sort.Direction.ASC);
//                assertThat(pageable).hasSort("id", Sort.Direction.DESC);
    }
    @Test
    void getProductById() {
    }

    @Test
    void getProductsByCategoryId() {
    }

    @Test
    void findProductByNameContaining() {
    }

    @Test
    void createCategory() {
    }

    @Test
    void updateCategory() {
    }

    @Test
    void deleteCategory() {
    }
}