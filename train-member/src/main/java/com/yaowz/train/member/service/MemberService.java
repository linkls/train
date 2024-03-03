package com.yaowz.train.member.service;

import cn.hutool.core.collection.CollUtil;
import com.yaowz.common.exception.BusinessException;
import com.yaowz.common.exception.BusinessExceptionEnum;
import com.yaowz.train.member.domain.Member;
import com.yaowz.train.member.domain.MemberExample;
import com.yaowz.train.member.mapper.MemberMapper;
import com.yaowz.train.member.req.MemberRegisterReq;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Resource
    private MemberMapper memberMapper;

    public long count(){
        return memberMapper.countByExample(null);
    }

    public long register(MemberRegisterReq req){
        String mobile = req.getMobile();
        MemberExample memberExample = new MemberExample();
        memberExample.createCriteria().andMobileEqualTo(mobile);
        List<Member> memberList = memberMapper.selectByExample(memberExample);

        if(CollUtil.isNotEmpty(memberList)){
//            return memberList.get(0).getId();
            throw new BusinessException(BusinessExceptionEnum.MEMBER_MOBILE_EXIST);
        }

        Member member = new Member();
        member.setId(System.currentTimeMillis());
        member.setMobile(mobile);
        memberMapper.insert(member);
        return member.getId();
    }
}
