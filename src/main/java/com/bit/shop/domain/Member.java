package com.bit.shop.domain;

import com.bit.shop.domain.keys.SingleKey;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member extends BaseEntity<SingleKey<Long>> {

    private String email;
    private String password;
    private String name;
}
