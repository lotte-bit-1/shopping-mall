package com.bit.shop.product;

import com.bit.shop.domain.Member;
import com.bit.shop.domain.Product;
import com.bit.shop.dto.ProductResponseDto;
import com.bit.shop.service.ProductService;
import com.bit.shop.service.ProductServiceImpl;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProductInsertTest {

    ProductService productService;

    @BeforeEach
    void before() throws Exception {
        productService = new ProductServiceImpl();
    }

    @AfterEach
    void after() throws Exception {
        List<ProductResponseDto> list = productService.findProductsByCategoryId(6L);
        productService.deleteProduct(list.get(0).getId());
    }

    @DisplayName("Product Insert Test")
    @Test
    void insert() throws Exception {
        // given
        Product product = Product.builder()
            .categoryId(6L)
            .name("MAC-PC")
            .price(20000)
            .quantity(100)
            .code("PRODUCT-006")
            .build();

        // when
        productService.saveProduct(product);

        // then
        List<ProductResponseDto> list = productService.findProductsByCategoryId(6L);
        Assertions.assertEquals(list.get(0).getName(),"MAC-PC");

    }

}
