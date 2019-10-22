package com.ntuzy.springcloud.member.controller;

import com.ntuzy.springcloud.member.entity.Member;
import com.ntuzy.springcloud.member.service.MemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
@CrossOrigin // 利用CrossOrigin 解决跨域访问问题
public class MemberController {
    @Resource
    private MemberService memberService = null;

    @RequestMapping("/check")
    @ResponseBody
    public Map checkMobile(String mobile) {
        Map result = new HashMap();
        try {
            result.put("code", 0);
            result.put("message", "success");

            Member member = memberService.checkByMyMobile(mobile);
            result.put("data", member);
        } catch (Exception e) {
            e.printStackTrace();
            result.put("code", e.getClass().getSimpleName());
            result.put("message", e.getMessage());
        }
        return result;
    }


}
