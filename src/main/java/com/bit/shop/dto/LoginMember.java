package com.bit.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class LoginMember {

    private Long id;
    private String email;
    private String name;
}
