package com.bit.shop.dto;

import com.bit.shop.domain.Product;
import com.bit.shop.domain.ProductOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = false)
public class ProductDto {
    private Long categoryId;
    private String name;
    private long price;
    private long quantity;
    private LocalDateTime regDate;
    private String code;

    public ProductDto(Product product) {
        this.categoryId = product.getCategoryId();
        this.name = product.getName();
        this.price = product.getPrice();
        this.quantity = product.getQuantity();
        this.regDate = product.getRegDate();
        this.code = product.getCode();
    }
}
