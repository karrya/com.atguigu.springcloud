package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import feign.Param;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: com.atguigu.springcloud
 * @Package: com.atguigu.springcloud
 * @Description: note
 * @Author: likai31841
 * @CreateDate: 2021-08-08 11:12
 * @UpdateUser: likai31841
 * @UpdateDate: 2021-08-08 11:12
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * @Date: 2021-08-08 11:12
 * Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved
 **/
@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentFeignService {

    /**
     * 按id查找
     *
     * @param id id
     * @return
     */
    @GetMapping(value = "/payment/get/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id);

    /**
     * OpenFeign
     * @return
     */
    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeOut();
}
