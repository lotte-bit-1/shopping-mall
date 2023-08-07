package com.bit.shop.domain.keys;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class SingleKey<ID extends Number> implements EntityKey {
    private  ID id;
}
