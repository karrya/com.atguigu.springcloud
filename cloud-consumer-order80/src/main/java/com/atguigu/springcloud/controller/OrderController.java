package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.lb.lbimpl.LoadBalanceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.ResponseEntity;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;

import java.net.URI;
import java.util.List;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: com.atguigu.springcloud
 * @Package: com.atguigu.springcloud.controller
 * @Description: note
 * @Author: likai31841
 * @CreateDate: 2021-08-08 11:16
 * @UpdateUser: likai31841
 * @UpdateDate: 2021-08-08 11:16
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * @Date: 2021-08-08 11:16
 * Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved
 **/
@RestController
@Slf4j
public class OrderController {

    /**
     * 单机版
     */
    // public static final String PAYMENT_URL = "http://localhost:8001";

    /**
     * 集群版，通过服务名调用
     */
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    /**
     * 自写轮询算法使用
     */
    @Autowired
    private LoadBalanceImpl loadBalance;
    /**
     * 对外暴露服务信息
     */
    @Autowired
    private DiscoveryClient discoveryClient;


    @GetMapping("/consumer/payment/create")
    public CommonResult<Payment> create(Payment payment) {
        return restTemplate.postForObject(PAYMENT_URL + "/payment/create", payment, CommonResult.class);
    }

    @GetMapping("/consumer/payment/get/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }


    /***
     * 自写负载均衡算法测试
     * @return
     */
    @GetMapping("/consumer/payment/lb")
    public String lbPaymentGet() {
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if (instances == null || instances.size() <= 0) {
            return null;
        }

        ServiceInstance serviceInstance = loadBalance.instance(instances);
        URI uri = serviceInstance.getUri();

        return restTemplate.getForObject(uri + "/payment/lb", String.class);
    }

}