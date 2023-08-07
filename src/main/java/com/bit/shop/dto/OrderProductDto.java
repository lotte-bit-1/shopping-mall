package com.bit.shop.dto;

import com.bit.shop.domain.ProductOrder;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor(force = false)
public class OrderProductDto {
    private long productId;
    private long orderId;
    private long memberId;
    private long price;
    private long quantity;
    private CouponTypeDto couponTypeDto;

    public OrderProductDto(ProductOrder productOrder) {
        this.productId = productOrder.getProductId();
        this.orderId = productOrder.getOrderId();
        this.quantity = productOrder.getQuantity();
        this.price = productOrder.getPrice();
    }

}
