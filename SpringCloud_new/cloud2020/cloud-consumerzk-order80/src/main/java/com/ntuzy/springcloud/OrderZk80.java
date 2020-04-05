package com.ntuzy.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author IamZY
 * @create 2020/4/5 15:57
 */
@SpringBootApplication
@EnableDiscoveryClient
public class OrderZk80 {
    public static void main(String[] args){
        SpringApplication.run(OrderZk80.class,args);
    }
}
