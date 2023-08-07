package com.bit.shop.domain;

import com.bit.shop.domain.keys.SingleKey;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@RequiredArgsConstructor
public class Member extends BaseEntity<SingleKey<Long>> {
    private Long id;
    private String email;
    private String password;
    private String name;
}
