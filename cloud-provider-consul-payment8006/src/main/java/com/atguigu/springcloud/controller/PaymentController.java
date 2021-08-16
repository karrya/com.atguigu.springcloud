package com.atguigu.springcloud.controller;

import cn.hutool.core.lang.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @RequestMapping(value = "/payment/consul")
    public String create() {
        return "SpringCloud with consul:" + serverPort + "\t" + UUID.randomUUID().toString();
    }


}
