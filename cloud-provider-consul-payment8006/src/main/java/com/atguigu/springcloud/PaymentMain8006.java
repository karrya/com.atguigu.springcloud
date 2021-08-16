package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: com.atguigu.springcloud
 * @Package: com.atguigu.springcloud
 * @Description: note
 * @Author: likai31841
 * @CreateDate: 2021-08-07 19:37
 * @UpdateUser: likai31841
 * @UpdateDate: 2021-08-07 19:37
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * @Date: 2021-08-07 19:37
 * Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain8006 {

    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8006.class, args);
    }
}
