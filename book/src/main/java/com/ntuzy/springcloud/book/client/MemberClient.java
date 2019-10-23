package com.ntuzy.springcloud.book.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "member", fallback = MemberClient.MemberClientFallBack.class)
public interface MemberClient {

    @GetMapping("/check")
    public MemberResult checkMobile(@RequestParam("mobile") Long mobile);

    @Component
    static class MemberClientFallBack implements MemberClient {

        @Override
        public MemberResult checkMobile(Long mobile) {
            MemberResult mr = new MemberResult();
            mr.setCode("0");
            mr.setMessage("success");
            MemberDTO memberDTO = new MemberDTO();
            memberDTO.setMid(0l);
            mr.setData(memberDTO);
            return mr;
        }
    }


}
