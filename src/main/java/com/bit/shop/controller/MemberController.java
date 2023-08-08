package com.bit.shop.controller;

import com.bit.shop.domain.Member;
import com.bit.shop.dto.LoginMember;
import com.bit.shop.dto.LoginRequestDto;
import com.bit.shop.dto.MemberResponseDto;
import com.bit.shop.service.MemberService;
import com.bit.shop.service.impl.MemberServiceImpl;
import java.util.HashMap;
import java.util.Map;

public class MemberController {

    private static final String SUCCESS = "SUCCESS";
    private static final String FAIL = "FAIL";
    private MemberService memberService;

    MemberController() {
        memberService = new MemberServiceImpl();
    }

    public String memberAdd(Member member) {
        try {
            memberService.register(member);
        } catch (Exception e) {
            return FAIL;
        }
        return SUCCESS;
    }

    public Map<String, Object> memberDetails(Long id) {
        Map<String, Object> result = new HashMap<>();
        try {
            MemberResponseDto memberDto = memberService.findMemberDto(id);
            result.put("result", SUCCESS);
            result.put("data", memberDto);
            return result;
        } catch (Exception e) {
            result.put("result", FAIL);
            return result;
        }
    }

    public Map<String, Object> login(LoginRequestDto dto) {
        Map<String, Object> result = new HashMap<>();
        try {
            LoginMember loginMember = memberService.login(dto);
            result.put("result", SUCCESS);
            result.put("data", loginMember);
            return result;
        } catch (Exception e) {
            result.put("result", FAIL);
            return result;
        }
    }

    public String removeMember(Long id) {
        try {
            memberService.removeMember(id);
            return SUCCESS;
        } catch (Exception e) {
            return FAIL;
        }
    }
}
