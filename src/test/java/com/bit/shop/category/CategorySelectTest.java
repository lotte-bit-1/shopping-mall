package com.bit.shop.category;

import com.bit.shop.dao.CategoryRepository;
import com.bit.shop.domain.Category;
import com.bit.shop.service.CategoryServiceImpl;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CategorySelectTest {

    private CategoryServiceImpl categoryService;
    private CategoryRepository categoryRepository;

    @BeforeEach
    void beforeEach() throws Exception {
        categoryRepository = new CategoryRepository();
        categoryService = new CategoryServiceImpl(categoryRepository);
    }

    @Test
    @DisplayName("단일 카테고리 조회")
    void getById() throws Exception {
        // given
        Long id = 3L;

        // when
        List<Category> categories = categoryService.getAllWithParentById(id);

        // then
        Assertions.assertEquals(3, categories.size());
    }

    @Test
    @DisplayName("모든 카테고리 조회")
    void getAll() throws Exception {

        // when
        List<Category> categories = categoryService.getAll();

        // then
        Assertions.assertEquals(7, categories.size());
    }
}
