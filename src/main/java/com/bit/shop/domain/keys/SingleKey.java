package com.bit.shop.domain.keys;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class SingleKey<ID extends Number> implements EntityKey {
    private final ID id;
}
