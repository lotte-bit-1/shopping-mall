package com.bit.shop.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
public class RegisterCartRequest {
    private int productQuantity;
    private Long productId;
    private Long memberId;
}
