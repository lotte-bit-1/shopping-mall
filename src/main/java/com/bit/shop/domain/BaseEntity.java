package com.bit.shop.domain;


import com.bit.shop.domain.keys.EntityKey;

import java.util.Date;

public abstract class BaseEntity<KEY extends EntityKey> {
    private KEY key;
}
