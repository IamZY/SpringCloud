package com.ntuzy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @Author IamZY
 * @create 2020/4/6 16:00
 */
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class PaymentFeignHystrixMain80 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentFeignHystrixMain80.class,args);
    }
}
