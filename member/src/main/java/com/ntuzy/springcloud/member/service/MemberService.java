package com.ntuzy.springcloud.member.service;

import com.ntuzy.springcloud.member.entity.Member;
import com.ntuzy.springcloud.member.repository.MemberRepository;
import com.ntuzy.springcloud.member.service.exception.MemberNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MemberService {

    @Resource
    private MemberRepository memberRepository = null;

    public Member checkByMyMobile(String mobile) {

        List<Member> members = memberRepository.findByMobile(mobile);

        if (members.size() == 0) {
            throw new MemberNotFoundException("会员不存在");
        }
        // 用户已过期

        return members.get(0);

    }


}
