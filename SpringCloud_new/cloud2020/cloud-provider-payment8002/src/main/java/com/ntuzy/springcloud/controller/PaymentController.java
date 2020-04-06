package com.ntuzy.springcloud.controller;

import com.ntuzy.springcloud.entities.CommonResult;
import com.ntuzy.springcloud.entities.Payment;
import com.ntuzy.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author IamZY
 * @create 2020/4/4 15:47
 */
@RestController
@Slf4j
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @PostMapping(value = "/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("*******插入結果: " + result);
        if (result > 0) {
            return new CommonResult(200,"success" + serverPort,result);
        } else {
            return new CommonResult(444,"error",null);
        }

    }


    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id) {
        Payment payment = paymentService.getPaymentById(id);
        log.info("*******插入結果: " + payment);
        if (payment != null) {
            return new CommonResult(200,"success"+ serverPort,payment);
        } else {
            return new CommonResult(444,"error",null);
        }

    }

    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }



}
