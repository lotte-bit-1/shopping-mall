package com.bit.shop.domain;

import com.bit.shop.domain.keys.CompositeKey;
import java.util.HashMap;
import java.util.Map;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Likes extends BaseEntity<CompositeKey<Long>> {

    private final Long memberId;
    private final Long productId;

    public CompositeKey<Long> getCompositeKey(){
        Map<String,Long> map = new HashMap<>();
        map.put(String.valueOf(memberId), productId);
        CompositeKey<Long> cp = new CompositeKey<>(map);
        return cp;
    }

}
