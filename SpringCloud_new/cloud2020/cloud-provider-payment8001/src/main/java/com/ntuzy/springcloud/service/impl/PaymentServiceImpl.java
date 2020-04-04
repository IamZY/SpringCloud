package com.ntuzy.springcloud.service.impl;

import com.ntuzy.springcloud.dao.PaymentDao;
import com.ntuzy.springcloud.entities.Payment;
import com.ntuzy.springcloud.service.PaymentService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author IamZY
 * @create 2020/4/4 15:45
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;


    public int create(Payment payment){
        return paymentDao.create(payment);
    }

    public Payment getPaymentById(Long id){
        return paymentDao.getPaymentById(id);
    }

}
