package com.bit.shop.controller;


import com.bit.shop.domain.keys.SingleKey;
import com.bit.shop.dto.OrderCartDto;
import com.bit.shop.dto.OrderProductDto;
import com.bit.shop.dto.OrdersDto;
import com.bit.shop.dto.ProductDto;
import com.bit.shop.service.OrderService;
import com.bit.shop.service.impl.OrderServiceImpl;

import java.util.List;
import java.util.logging.Logger;

public class OrderController {
    Logger log = Logger.getLogger("OrderController");

    private OrderService orderService;

    public OrderController() {
        orderService = new OrderServiceImpl();
    }


    // 카트에서 주문 -> 총 금액 반환
    public Long orderCart(List<OrderCartDto> carts) throws Exception {
        return orderService.orderCart(carts);
    }

    // 상품조회에서 주문 -> 총 금액 반환
    public Long orderProduct(OrderProductDto orderProductDto) throws Exception {
        return orderService.orderProduct(orderProductDto);
    }

    // 주문 취소
    public void orderCancel(Long orderId) throws Exception {
        orderService.cancelOrder(new SingleKey<Long>(orderId));
    }

    // 주문내역 조회
    public List<OrdersDto> getMyOrderList(Long memberId) throws Exception {
        return orderService.getMembersOrder(memberId);
    }

}
