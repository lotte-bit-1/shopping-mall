package com.bit.shop.dao.cart;

import com.bit.shop.dao.CartRepository;
import com.bit.shop.domain.Cart;
import org.junit.jupiter.api.*;

public class CartInsertTest {

    private CartRepository cartRepository;

    @BeforeEach
    void beforeEach() throws Exception {
        cartRepository = new CartRepository();
        Cart cart1 = Cart.builder()
                .memberId(TestProperties.memberKey.getId())
                .productId(TestProperties.productKey.getId())
                .productQuantity(5)
                .build();
        cartRepository.insert(cart1);
    }

    @AfterEach
    void afterEach() throws Exception {
        cartRepository.deleteAllByMemberKey(TestProperties.memberKey);
    }

    @Test
    @DisplayName("장바구니에 상품 추가")
    void insert() throws Exception {
        // given
        Cart cart1 = Cart.builder()
                .memberId(TestProperties.memberKey.getId())
                .productId(TestProperties.memberKey.getId())
                .productQuantity(5)
                .build();

        // when
        cartRepository.insert(cart1);

        // then
        Assertions.assertSame(cartRepository.getAllByMemberId(TestProperties.memberKey.getId()).size(), 1);
    }
}
