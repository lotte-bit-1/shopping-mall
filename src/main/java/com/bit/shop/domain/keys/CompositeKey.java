package com.bit.shop.domain.keys;

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;

@Getter
public class CompositeKey<ID extends Number> implements EntityKey {

    private final Map<String, ID> idStore;

    public CompositeKey() {
        idStore = new HashMap<>();
    }

}
