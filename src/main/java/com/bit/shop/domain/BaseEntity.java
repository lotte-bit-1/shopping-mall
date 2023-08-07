package com.bit.shop.domain;


import com.bit.shop.domain.keys.EntityKey;
import lombok.Getter;

<<<<<<< HEAD
import java.util.Date;
import lombok.Getter;

=======
>>>>>>> fb4a7286ed21c5391567e53eeb62164b85a714db
@Getter
public abstract class BaseEntity<KEY extends EntityKey> {
    protected KEY key;
}
