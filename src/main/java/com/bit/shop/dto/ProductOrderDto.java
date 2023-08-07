package com.bit.shop.dto;

import com.bit.shop.domain.ProductOrder;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = false)
public class ProductOrderDto {
    private long productId;
    private long orderId;
    private long price;
    private long quantity;

    public ProductOrderDto(ProductOrder productOrder) {
        this.productId = productOrder.getProductId();
        this.orderId = productOrder.getOrderId();
        this.quantity = productOrder.getQuantity();
        this.price = productOrder.getPrice();
    }
}
