package com.bit.shop.service;

import com.bit.shop.domain.Member;

public interface MemberService {
    void register(Member member) throws Exception;

    Member findMember(Long id) throws Exception;

    void removeMember(Long id) throws Exception;

    void modifyMember(Member member) throws Exception;

}
