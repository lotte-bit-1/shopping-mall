package com.bit.shop.domain;

import com.bit.shop.domain.keys.SingleKey;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
@Builder
public class Member extends BaseEntity<SingleKey<Long>> {

    private String email;
    private String password;
    private String name;
}
