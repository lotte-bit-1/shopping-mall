package com.bit.shop.dao;

import com.bit.shop.domain.ProductOrder;
import com.bit.shop.domain.keys.SingleKey;
import java.util.List;
import java.util.Optional;

public class ProductOrderRepository implements DaoFrame<SingleKey<Long>, ProductOrder> {


    @Override
    public Optional<ProductOrder> getById(SingleKey<Long> key) {
        return Optional.empty();
    }

    @Override
    public List<ProductOrder> getAll() {
        return null;
    }

    @Override
    public void insert(ProductOrder object) {

    }

    @Override
    public void delete(SingleKey<Long> key) {

    }

    @Override
    public void update(ProductOrder object) {

    }
}
