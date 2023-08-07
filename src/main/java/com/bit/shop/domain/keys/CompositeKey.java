package com.bit.shop.domain.keys;

import java.util.Map;

public class CompositeKey<ID extends Number> implements EntityKey {
    private Map<String, ID> idStore;
}
