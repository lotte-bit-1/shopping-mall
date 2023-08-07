package com.bit.shop.domain.keys;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CompositeKey<ID extends Number> implements EntityKey {

    private final Map<String, ID> idStore;

    public CompositeKey() {
        idStore = new HashMap<>();
    }

    public void add(ID memberId, ID productId){
        idStore.put(String.valueOf(memberId),productId);
    }
}
