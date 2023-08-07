package com.bit.shop.controller;


import com.bit.shop.domain.keys.SingleKey;
import com.bit.shop.dto.CartDto;
import com.bit.shop.dto.ProductDto;
import com.bit.shop.service.OrderService;
import com.bit.shop.service.OrderServiceImpl;

import java.util.List;
import java.util.logging.Logger;

public class OrderController {
    Logger log = Logger.getLogger("OrderController");

    private OrderService orderService;

    public OrderController() {
        orderService = new OrderServiceImpl();
    }


    // 카트에서 주문 -> 총 금액 반환
    public Long orderCart(List<CartDto> carts) throws Exception {
        return orderService.orderCart(carts);
    }

    // 상품조회에서 주문 -> 총 금액 반환
    public Long orderProduct(ProductDto productDto, Long memberId) throws Exception {
        return orderService.orderProduct(productDto, memberId);
    }

    // 주문 취소
    public void orderCancel(Long orderId) throws Exception {
        orderService.remove(new SingleKey<Long>(orderId));
    }

}
