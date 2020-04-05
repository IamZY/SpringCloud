package com.ntuzy.springcloud;

import com.ntuzy.springcloud.entities.Payment;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author IamZY
 * @create 2020/4/5 16:27
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain8006 {
    public static void main(String[] args){
        SpringApplication.run(PaymentMain8006.class,args);
    }
}
