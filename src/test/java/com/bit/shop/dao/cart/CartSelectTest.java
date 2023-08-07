package com.bit.shop.dao.cart;

import com.bit.shop.dao.CartRepository;
import com.bit.shop.domain.Cart;
import com.bit.shop.domain.keys.SingleKey;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class CartSelectTest {

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
    @DisplayName("단일 장바구니 상품 조회")
    void getById() throws Exception {
        // given
        Long id = 1L;

        // when
        Optional<Cart> optionalCart = cartRepository.getById(new SingleKey<>(id));

        // then
        assertTrue(optionalCart.isPresent());
        assertNotNull(optionalCart.get().getKey().getId());
        assertSame(optionalCart.get().getProductQuantity(), 10);
    }

    @Test
    @DisplayName("모든 장바구니 상품 조회")
    void getAllByMemberId() throws Exception {
        // given
        Long memberId = 1L;

        // when
        List<Cart> carts = cartRepository.getAllByMemberId(memberId);

        // then
        assertEquals(carts.size(), 1);
    }
}
