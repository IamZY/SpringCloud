package com.ntuzy.springcloud.member.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(name = "book")  // 指明这是book微服务的调用客户端
public interface BookClient {
    @GetMapping("/info") // 当调用getInfo方法的时候 自动向book微服务book的info发起请求
    // 会将bid=xxx 附加到info中
    public RestResult getInfo(@RequestParam("bid") Long bid);

    // Get请求对应getmapping Post请求postMapping
    // Post请求传递参数的时候使用@requestBody
    @PostMapping("/create")
    public String create(@RequestBody Map rec);


}
