package com.bit.shop.service.impl;

import com.bit.shop.dao.MemberRepository;
import com.bit.shop.domain.Member;
import com.bit.shop.domain.keys.SingleKey;
import com.bit.shop.dto.LoginMember;
import com.bit.shop.dto.LoginRequestDto;
import com.bit.shop.dto.MemberResponseDto;
import com.bit.shop.service.MemberService;

import java.util.List;

public class MemberServiceImpl implements MemberService {

    private MemberRepository memberRepository;

    public MemberServiceImpl() {
        memberRepository = new MemberRepository();
    }

    @Override
    public void register(Member member) throws Exception {
        memberRepository.insert(member);
    }

    @Override
    public LoginMember login(LoginRequestDto loginFormDto) throws Exception {
        return memberRepository.getByEmailAndPassword(loginFormDto.getEmail(),
            loginFormDto.getPassword()).orElseThrow(() ->
            new Exception("로그인 실패"));
    }

    @Override
    public Member findMember(Long id) throws Exception {
        return memberRepository.getById(
            new SingleKey<>(id)).orElseThrow(() ->
            new Exception("조회 에러"));
    }

    @Override
    public MemberResponseDto findMemberDto(Long id) throws Exception {
        return memberRepository.getDtoById(
            id).orElseThrow(() ->
            new Exception("조회 에러"));
    }

    @Override
    public void removeMember(Long id) throws Exception {
        memberRepository.delete(new SingleKey<>(id));
    }

    @Override
    public void removeByEmail(String email) throws Exception {
        memberRepository.deleteByEmail(email);
    }

    @Override
    public void modifyMember(Member member) throws Exception {
        memberRepository.update(member);
    }

    @Override
    public void removeAll() throws Exception {
        memberRepository.deleteAll();
    }

    @Override
    public List<Member> findAll() throws Exception {
        return memberRepository.getAll();
    }
}
