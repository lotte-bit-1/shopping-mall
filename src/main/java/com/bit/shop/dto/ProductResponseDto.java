package com.bit.shop.dto;

import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class ProductResponseDto {

    private Long id;
    private Long categoryId;
    private String name;
    private Long price;
    private int quantity;
    private LocalDateTime regDate;
    private String code;
}
