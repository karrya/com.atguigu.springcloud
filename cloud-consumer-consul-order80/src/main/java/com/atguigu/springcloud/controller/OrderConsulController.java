package com.atguigu.springcloud.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

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
public class OrderConsulController {


    /**
     * 集群版，通过服务名调用
     */
    public static final String PAYMENT_URL = "http://cloud-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @RequestMapping("/consumer/payment/consul")
    public String getPayment() {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/consul", String.class);
    }


}