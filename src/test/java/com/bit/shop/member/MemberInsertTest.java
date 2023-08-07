package com.bit.shop.member;

import com.bit.shop.domain.Member;
import com.bit.shop.service.MemberService;
import com.bit.shop.service.impl.MemberServiceImpl;
import java.util.List;
import java.util.logging.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

public class MemberInsertTest {

    Logger log = Logger.getLogger("MemberInsertTest");

    MemberService service;

    @BeforeEach
    void before() throws Exception {
        service = new MemberServiceImpl();
    }

    @AfterEach
    void after() throws Exception {
        service.removeAll();
    }

    @DisplayName("Member Insert Test")
    @Test
    @Order(1)
    void insert() throws Exception {
        // given
        Member member = Member.builder()
            .email("abc@naver.com")
            .password("111111")
            .name("junyong")
            .build();

        // when
        service.register(member);

        // then
        List<Member> list = service.findAll();

        Assertions.assertTrue(list.get(list.size()-1).getEmail().equals("abc@naver.com"));

    }

}
