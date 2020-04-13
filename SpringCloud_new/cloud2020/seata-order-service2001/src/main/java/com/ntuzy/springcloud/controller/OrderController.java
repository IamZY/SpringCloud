package com.ntuzy.springcloud.controller;

import com.ntuzy.springcloud.domain.CommonResult;
import com.ntuzy.springcloud.domain.Order;
import com.ntuzy.springcloud.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author IamZY
 * @create 2020/4/12 16:30
 */
@RestController
public class OrderController{
    @Resource
    private OrderService orderService;


    @GetMapping("/order/create")
    public CommonResult create(Order order)
    {
        orderService.create(order);
        return new CommonResult(200,"订单创建成功");
    }
}