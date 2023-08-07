package com.bit.shop.service;

import com.bit.shop.dao.MemberRepository;
import com.bit.shop.domain.Member;
import com.bit.shop.domain.keys.SingleKey;

public class MemberServiceImpl implements MemberService {

    private MemberRepository memberRepository;

    MemberServiceImpl() {
        memberRepository = new MemberRepository();
    }

    @Override
    public void register(Member member) throws Exception {
        memberRepository.insert(member);
    }

    @Override
    public Member findMember(Long id) throws Exception {
        return memberRepository.getById(
            new SingleKey<>(id)).orElseThrow(() ->
            new Exception("조회 에러"));
    }

    @Override
    public void removeMember(Long id) throws Exception {
        memberRepository.delete(new SingleKey<>(id));
    }

    @Override
    public void modifyMember(Member member) throws Exception {
        memberRepository.update(member);
    }
}
