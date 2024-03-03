package com.yaowz.train.member.controller;

import com.yaowz.common.resp.CommonResp;
import com.yaowz.train.member.req.MemberRegisterReq;
import com.yaowz.train.member.service.MemberService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/member")
public class MemberController {

    @Resource
    private MemberService memberService;

    @GetMapping("/count")
    public CommonResp count() {
        long i = memberService.count();
        return new CommonResp<>(i);
    }

    @PostMapping("/register")
    public CommonResp register(MemberRegisterReq req) {
        long i = memberService.register(req);
        return new CommonResp<>(i);
    }
}
