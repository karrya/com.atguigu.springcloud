package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
public class RestTemplateController {

    /**
     * 集群版，通过服务名调用
     */
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    /**
     * getForObject:
     *      返回对象为相应体中数据转化成的对象，基本可以理解为JSON
     *
     * @param id
     * @return
     */
    @GetMapping("/consumer/payment/getForObject/{id}")
    public CommonResult<Payment> getForObject(@PathVariable("id") Long id) {
        return restTemplate.getForObject(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
    }

    /**
     * getForEntity:
     *      返回对象ResponseEntity对象，包含了响应中共的一些重要信息，比如对象头、响应状态码，响应体等
     *
     * @param id
     * @return
     */
    @GetMapping("/consumer/payment/getForEntity/{id}")
    public CommonResult<Payment> getPayment(@PathVariable("id") Long id) {
        ResponseEntity<CommonResult> forEntity =
                restTemplate.getForEntity(PAYMENT_URL + "/payment/get/" + id, CommonResult.class);
        if (forEntity.getStatusCode().is2xxSuccessful()) {
            log.info(forEntity.getStatusCode() + "\t" + forEntity.getHeaders());
            return forEntity.getBody();
        } else {
            return new CommonResult<>(444, "操作失败");
        }
    }

}
