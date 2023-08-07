package com.bit.shop.domain;


import com.bit.shop.domain.keys.EntityKey;
import lombok.Getter;


import java.util.Date;
import lombok.Getter;

@Getter
public abstract class BaseEntity<KEY extends EntityKey> {
    protected KEY key;
}
