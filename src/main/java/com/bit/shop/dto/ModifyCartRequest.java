package com.bit.shop.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
public class ModifyCartRequest {
    private int productQuantity;
}
