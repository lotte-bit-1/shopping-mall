package com.bit.shop.service;

import com.bit.shop.domain.Member;
import com.bit.shop.dto.LoginMember;
import com.bit.shop.dto.LoginRequestDto;
import com.bit.shop.dto.MemberResponseDto;
import java.util.List;

public interface MemberService {
    void register(Member member) throws Exception;

    LoginMember login(LoginRequestDto loginFormDto) throws Exception;

    MemberResponseDto findMember(Long id) throws Exception;

    List<Member> findAll() throws Exception;

    void modifyMember(Member member) throws Exception;

    void removeMember(Long id) throws Exception;

    void removeByEmail(String email) throws Exception;

    void removeAll() throws Exception;



}
