package com.bit.shop.service;

import com.bit.shop.dao.CategoryRepository;
import com.bit.shop.domain.Category;
import com.bit.shop.domain.keys.SingleKey;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Category getById(Long id) throws Exception {
        return null;
    }

    public List<Category> getAllWithParentById(Long id) throws Exception {
        SingleKey<Long> key = new SingleKey<>(id);
        return categoryRepository.getAllWithById(key);
    }

    @Override
    public List<Category> getAll() throws Exception {
        return categoryRepository.getAll();
    }
}
