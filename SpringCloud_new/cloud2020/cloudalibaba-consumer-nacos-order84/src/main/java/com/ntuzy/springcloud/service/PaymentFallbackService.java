package com.ntuzy.springcloud.service;

import com.ntuzy.springcloud.entities.CommonResult;
import com.ntuzy.springcloud.entities.Payment;
import org.springframework.stereotype.Component;

/**
 * @Author IamZY
 * @create 2020/4/12 9:55
 */
@Component
public class PaymentFallbackService implements PaymentService {
    @Override
    public CommonResult<Payment> paymentSQL(Long id) {
        return new CommonResult<>(444, "服务降级返回---PaymentFallbackService", new Payment(id, "errorService"));
    }
}
