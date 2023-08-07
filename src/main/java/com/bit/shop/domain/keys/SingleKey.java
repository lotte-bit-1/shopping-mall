package com.bit.shop.domain.keys;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class SingleKey<ID extends Number> implements EntityKey {

    private ID id;
}
