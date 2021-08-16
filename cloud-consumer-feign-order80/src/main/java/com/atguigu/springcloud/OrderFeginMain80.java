package com.atguigu.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

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
@EnableEurekaClient
@SpringBootApplication
@EnableFeignClients
public class OrderFeginMain80 {

    public static void main(String[] args) {
        SpringApplication.run(OrderFeginMain80.class, args);
    }
}
