package com.bit.shop.product;

import com.bit.shop.dto.ProductResponseDto;
import com.bit.shop.service.ProductService;
import com.bit.shop.service.ProductServiceImpl;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProductSelectAllByCategoryTest {

    ProductService productService;

    @BeforeEach
    void before() throws Exception {
        productService = new ProductServiceImpl();
    }

    @DisplayName("Product Select By categoryId Test")
    @Test
    void select() throws Exception {
        // given
        long categoryId = 1L;

        // when
        List<ProductResponseDto> list = productService.findProductsByCategoryId(categoryId);
        // then
        Assertions.assertEquals(2, list.size());

    }
}
