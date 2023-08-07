package com.bit.shop.domain;

import com.bit.shop.domain.keys.CompositeKey;
<<<<<<< HEAD
import com.bit.shop.domain.keys.SingleKey;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
=======
>>>>>>> fb4a7286ed21c5391567e53eeb62164b85a714db
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Likes extends BaseEntity<CompositeKey<Long>> {
<<<<<<< HEAD
    private final Long memberId;
    private final Long productId;

    public CompositeKey<Long> getCompositeKey(){
        Map<String,Long> map = new HashMap<>();
        map.put(String.valueOf(memberId), productId);
        CompositeKey<Long> cp = new CompositeKey<>(map);
        return cp;
    }

=======

    private Long memberId;
    private Long productId;
>>>>>>> fb4a7286ed21c5391567e53eeb62164b85a714db
}
