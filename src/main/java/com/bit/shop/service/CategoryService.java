package com.bit.shop.service;

import com.bit.shop.domain.Category;

import java.util.List;

public interface CategoryService {

    Category getById(Long id) throws Exception;
    List<Category> getAll() throws Exception;
}
