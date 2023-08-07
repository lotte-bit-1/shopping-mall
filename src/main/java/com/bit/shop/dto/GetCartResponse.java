package com.bit.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class GetCartResponse {
    private int productQuantity;
    private Long productId;
    private Long memberId;
}
