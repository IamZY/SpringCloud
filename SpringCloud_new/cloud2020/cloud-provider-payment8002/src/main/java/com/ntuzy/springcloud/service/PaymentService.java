package com.ntuzy.springcloud.service;

import com.ntuzy.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @Author IamZY
 * @create 2020/4/4 15:44
 */
public interface PaymentService {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);
}
