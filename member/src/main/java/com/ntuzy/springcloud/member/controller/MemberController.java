package com.ntuzy.springcloud.member.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.ntuzy.springcloud.member.client.BookClient;
import com.ntuzy.springcloud.member.client.RestResult;
import com.ntuzy.springcloud.member.entity.Member;
import com.ntuzy.springcloud.member.service.MemberService;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Controller
@CrossOrigin // 利用CrossOrigin 解决跨域访问问题
@DefaultProperties(defaultFallback = "defaultFallBack")
public class MemberController {
    @Resource
    private MemberService memberService = null;

    // 负载均衡客户端 Ribbon核心组件
//    @Resource
//    private LoadBalancerClient loadBalancerClient;

    @Resource
    private RestTemplate restTemplate;


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


    @GetMapping("/test")
    @ResponseBody
    @HystrixCommand(fallbackMethod = "fallback")
    public String test(Long bid) {
        // 最简单的情况就是使用内置Spring Cloud 内置的RestTemplate
        // RestTemplate 底层http传输就是apache HttpClient 组件
//        RestTemplate restTemplate = new RestTemplate();
//        String json = restTemplate.getForObject("http://localhost:8100/info?bid=" + bid, String.class);
//        System.out.println(json);
//        return json;

        // Ribbon
//        RestTemplate restTemplate = new RestTemplate();
//        ServiceInstance instance = loadBalancerClient.choose("book");
//        String host = instance.getHost(); // 获取主机名
//        int port = instance.getPort();  // 获取端口号
//        String json = restTemplate.getForObject("http://"+ host +":"+ port +"/info?bid=" + bid, String.class);
//        return json;

        // 利用注解简化url通信
        String json = null;
        if (bid % 2 == 0) {
            json = restTemplate.getForObject("http://book/info?bid=" + bid, String.class);
        } else {
            json = "success";
        }
        return json;
    }

    // 服务降级的方法 要求返回值参数与目标方法保持一致
    private String fallback(Long bid) {
        return "当前系统正忙,请稍后再试";
    }


    // 全局默认的降级方法 不需要参数 且返回String或者任何可以被Json序列化的对象
    private String defaultFallBack() {
        return "当前系统正忙,请稍后再试111";
    }


    @Resource
    private BookClient bookClient;


    @GetMapping("/test1")
    @ResponseBody
    public String test1(Long bid) {
        RestResult info = bookClient.getInfo(bid);
        return info.getData().getName();
    }


}
