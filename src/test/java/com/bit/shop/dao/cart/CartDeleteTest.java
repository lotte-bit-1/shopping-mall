package com.bit.shop.dao.cart;

import com.bit.shop.dao.CartRepository;
import com.bit.shop.domain.Cart;
import org.junit.jupiter.api.*;

public class CartDeleteTest {

    private CartRepository cartRepository;

    @BeforeEach
    void beforeEach() throws Exception {
        cartRepository = new CartRepository();
        Cart cart1 = Cart.builder()
                .memberId(TestProperties.memberKey.getId())
                .productId(TestProperties.memberKey.getId())
                .productQuantity(5)
                .build();
        cartRepository.insert(cart1);
    }

    @AfterEach
    void afterEach() throws Exception {
        cartRepository.deleteAllByMemberKey(TestProperties.memberKey);
    }

    @Test
    @DisplayName("장바구니에 있는 상품 수정")
    void deleteAllByMemberId() throws Exception {
        // given
        Cart cart1 = Cart.builder()
                .memberId(TestProperties.memberKey.getId())
                .productId(TestProperties.productKey.getId())
                .productQuantity(7)
                .build();

        // when
        cartRepository.deleteAllByMemberKey(TestProperties.memberKey);

        // then
        Assertions.assertEquals(0, cartRepository.getAllByMemberId(TestProperties.memberKey.getId()).size());
    }
}
