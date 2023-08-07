package com.bit.shop.service;

import com.bit.shop.dto.OrderCartDto;
import com.bit.shop.service.impl.OrderServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

class OrderServiceImplTest {

    OrderService orderService;

    Logger log = Logger.getLogger("OrderServiceImplTest");

    @BeforeEach
    void before() {
        orderService = new OrderServiceImpl();
    }

    @AfterEach
    void after() throws Exception {
//        orderService.removeAll();
    }

//    @Test
//    void register() throws Exception {
//        OrdersDto ordersDto = OrdersDto.builder()
//                .memberId(1L)
//                .status("상태")
//                .build();
//
//        orderService.register(ordersDto);
//    }
//
//    @Test
//    void modify() {
//    }
//
//    @Test
//    void remove() {
//    }
//
//    @Test
//    void getOrder() {
//    }
//
//    @Test
//    void getAll() throws Exception {
//        List<OrdersDto> list = orderService.getAll();
//        for (OrdersDto ordersDto : list) {
//            log.info(ordersDto.getRegDate().toString());
//        }
//    }
//
//    @Test
//    void getMembersOrder() {
//    }
//
//    @Test
//    void makeOrder() throws Exception {
//
//        log.info(String.valueOf(orderService.makeOrder(1L)));
//    }

    @Test
    void orderCart() throws Exception {

        List<OrderCartDto> orderCartDtoList = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            orderCartDtoList.add(
                    OrderCartDto.builder()
                            .productId(2L + i)
                            .productQuantity(2 + i)
                            .memberId(1L)
                            .build()
            );
        }

        log.info(String.valueOf(orderService.orderCart(orderCartDtoList)));
    }

    @Test
    void orderProduct() {

    }
}