package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @Method
 * @Author likai31841
 * @Version  1.0
 * @Date 2021-08-14 15:56
 */
@Component
public class PaymentFallbackServiceImpl implements OrderHystrixService{

    @Override
    public String paymentInfoOk(Integer id) {
        return "---------PaymentFallbackServiceImpl fall back-paymentInfoOk（）, o(╥﹏╥)o";
    }

    @Override
    public String paymentInfoTimeOut(Integer id) {
        return "---------PaymentFallbackServiceImpl fall back-paymentInfoTimeOut（）, o(╥﹏╥)o";
    }
}
