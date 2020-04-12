package com.ntuzy.springcloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.ntuzy.springcloud.entities.CommonResult;
import com.ntuzy.springcloud.entities.Payment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author IamZY
 * @create 2020/4/11 17:06
 */
@RestController
public class RateLimitController {

    @GetMapping("/rateLimit/byUrl")
    @SentinelResource(value = "byUrl")
    public CommonResult byUrl() {
        return new CommonResult(200, "按url限流测试OK", new Payment(2020L, "serial002"));
    }


}
