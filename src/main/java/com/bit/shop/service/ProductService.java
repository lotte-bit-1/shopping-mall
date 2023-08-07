package com.bit.shop.service;

import com.bit.shop.domain.Product;
import com.bit.shop.dto.ProductResponseDto;
import java.util.List;

public interface ProductService {

    void saveProduct(Product product) throws Exception;

    void modifyProduct(Product product) throws Exception;

    void deleteProduct(Long id) throws Exception;

    ProductResponseDto findProduct(Long id) throws Exception;

    List<ProductResponseDto> findProductsByCategoryId(Long categoryId) throws Exception;
}
