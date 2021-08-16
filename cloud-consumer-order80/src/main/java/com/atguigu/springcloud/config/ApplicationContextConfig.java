package com.atguigu.springcloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: com.atguigu.springcloud
 * @Package: com.atguigu.springcloud.config
 * @Description: note
 * @Author: likai31841
 * @CreateDate: 2021-08-08 11:19
 * @UpdateUser: likai31841
 * @UpdateDate: 2021-08-08 11:19
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * @Date: 2021-08-08 11:19
 * Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved
 **/
@Configuration
public class ApplicationContextConfig {

	/**
	 * @LoadBalanced : 这里主要是用于负载均衡（轮询的方式）
	 * 		我们在80消费者掉用服务的时候由单机：PAYMENT_URL = "http://localhost:8001"
	 * 							 改为集群：PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE"; 即：服务名的形势进行调用，不能识别调用谁处理
	 * 		因此：此处需要负载均衡，轮询的方式看调用谁
	 * @return
	 */
	@Bean
	// @LoadBalanced 自己手写轮询算法，此段注释
	public RestTemplate getRestTemplate(){
		return new RestTemplate();
	}
}
