package com.bit.shop.service;

import com.bit.shop.dao.ProductRepository;
import com.bit.shop.domain.Product;
import com.bit.shop.domain.keys.SingleKey;
import com.bit.shop.dto.ProductResponseDto;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;

    public ProductServiceImpl() {
        productRepository = new ProductRepository();
    }

    @Override
    public void saveProduct(Product product) throws Exception {
        productRepository.insert(product);
    }

    @Override
    public void modifyProduct(Product product) throws Exception {
        productRepository.update(product);
    }

    @Override
    public void deleteProduct(Long id) throws Exception {
        productRepository.delete(new SingleKey<>(id));
    }

    @Override
    public ProductResponseDto findProduct(Long id) throws Exception {
        return productRepository.getDtoById(id)
            .orElseThrow(() -> new Exception("조회에러"));
    }

    @Override
    public List<ProductResponseDto> findProductsByCategoryId(Long categoryId) throws Exception {
        return productRepository.getAllDtoByCategory(categoryId);
    }
}
