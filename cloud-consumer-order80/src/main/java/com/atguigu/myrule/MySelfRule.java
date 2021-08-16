package com.atguigu.myrule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
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
public class MySelfRule {

    /**
     * 注意：默认是轮询的，但是这里修改为随机的了，因此需要在主启动类上加@RibbonClient
     *   @RibbonClient(name = "CLOUD-PAYMENT-SERVICE", configuration = MySelfRule.class)
     * @return
     */
    @Bean
    public IRule myRule(){
        return new RandomRule();  //定义为随机
    }

}
