package com.atguigu.springcloud.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Method
 * @Author likai31841
 * @Version 1.0
 * @Date 2021-08-14 12:13
 */
@Component
@FeignClient(value = "CLOUD-PROVIDER-HYSTRIX-PAYMENT",fallback = PaymentFallbackServiceImpl.class)
public interface OrderHystrixService {
    /**
     * 正常的方法
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/payment/hsytrix/ok/{id}")
    String paymentInfoOk(@PathVariable("id") Integer id);

    /**
     * 超时的方法
     *
     * @param id
     * @return
     */
    @GetMapping(value = "/payment/hsytrix/timeout/{id}")
    String paymentInfoTimeOut(@PathVariable("id") Integer id);


}
