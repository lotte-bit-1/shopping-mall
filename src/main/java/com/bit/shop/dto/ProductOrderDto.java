package com.bit.shop.dto;

import com.bit.shop.domain.ProductOrder;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = false)
public class ProductOrderDto {
    private long productId;
    private String name;
    private int price;

    public ProductOrderDto(ProductOrder productOrder) {
        this.productId = productOrder.getProductId();
        this.name = productOrder.getName();
        this.price = productOrder.getPrice();
    }
}
