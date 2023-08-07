package com.bit.shop.member;

import com.bit.shop.domain.Member;
import com.bit.shop.service.MemberService;
import com.bit.shop.service.MemberServiceImpl;
import java.util.List;
import java.util.logging.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class MemberDeleteTest {

    MemberService service;

    @BeforeEach
    void before() throws Exception {
        service = new MemberServiceImpl();
    }

    @DisplayName("Member Delete Test")
    @Test
    @Order(1)
    void delete() throws Exception {
        // given
        Member member = Member.builder()
            .email("abc@naver.com")
            .password("111111")
            .name("junyong")
            .build();

        service.register(member);

        // when, then
        service.removeByEmail(member.getEmail());

        Assertions.assertEquals(0, service.findAll().size());

    }
}
