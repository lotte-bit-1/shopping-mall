package com.bit.shop.dao;

import com.bit.shop.domain.Product;
import com.bit.shop.domain.keys.SingleKey;
import java.util.List;
import java.util.Optional;

public class ProductRepository implements DaoFrame<SingleKey<Long>, Product> {

    @Override
    public Optional<Product> getById(SingleKey<Long> key) {
        return Optional.empty();
    }

    @Override
    public List<Product> getAll() {
        return null;
    }

    @Override
    public void insert(Product object) {

    }

    @Override
    public void delete(SingleKey<Long> key) {

    }

    @Override
    public void update(Product object) {

    }
}
