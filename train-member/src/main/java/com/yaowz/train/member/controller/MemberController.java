package com.yaowz.train.member.controller;

import com.yaowz.common.resp.CommonResp;
import com.yaowz.train.member.req.MemberLoginReq;
import com.yaowz.train.member.req.MemberRegisterReq;
import com.yaowz.train.member.req.MemberSendCodeReq;
import com.yaowz.train.member.resp.MemberLoginResp;
import com.yaowz.train.member.service.MemberService;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

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
    public CommonResp register(@Valid MemberRegisterReq req) {
        long i = memberService.register(req);
        return new CommonResp<>(i);
    }

    @PostMapping("/send-code")
    public CommonResp<Long> sendCode(@Valid @RequestBody MemberSendCodeReq req) {
        memberService.sendCode(req);
        return new CommonResp<>();
    }

    @PostMapping("/login")
    public CommonResp<MemberLoginResp> login(@Valid @RequestBody MemberLoginReq req) {
        MemberLoginResp resp = memberService.login(req);
        return new CommonResp<>(resp);
    }

}
