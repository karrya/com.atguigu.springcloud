package com.atguigu.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

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
@Configuration
public class FeginLogCfg {

    @Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
    }
}
