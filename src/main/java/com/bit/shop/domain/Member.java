package com.bit.shop.domain;

import com.bit.shop.domain.keys.SingleKey;
import lombok.*;

@AllArgsConstructor
@Getter
@Builder
@NoArgsConstructor
public class Member extends BaseEntity<SingleKey<Long>> {

    private String email;
    private String password;
    private String name;
}
