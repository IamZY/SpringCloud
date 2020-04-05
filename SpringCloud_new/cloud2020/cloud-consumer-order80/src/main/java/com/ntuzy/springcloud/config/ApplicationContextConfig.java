package com.ntuzy.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author IamZY
 * @create 2020/4/4 16:41
 */
@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced  // 配置負載均衡
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}

