package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: com.atguigu.springcloud
 * @Package: com.atguigu.springcloud.controller
 * @Description: note
 * @Author: likai31841
 * @CreateDate: 2021-08-07 20:26
 * @UpdateUser: likai31841
 * @UpdateDate: 2021-08-07 20:26
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * @Date: 2021-08-07 20:26
 * Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved
 **/
@RestController
@Slf4j
public class PaymentController {

	@Autowired
	private PaymentService paymentService;

	/**
	 * 对外暴露服务信息
	 */
	@Autowired
	private DiscoveryClient discoveryClient;

	@Value("${server.port}")
	private String serverPort;

	@PostMapping(value = "/payment/create")
	public CommonResult create(@RequestBody Payment payment) {
		Integer result = paymentService.create(payment);
		log.info("**********插入结果：" + result);

		if (result > 0) {
			return new CommonResult(200, "**********插入数据库结果：serverPort: "+ serverPort +" "+ result, result);
		}
		return new CommonResult(500, "**********插入数据库失败：" + result);
	}

	@GetMapping(value = "/payment/get/{id}")
	public CommonResult getPaymentById(@PathVariable("id") Long id) {
		Payment paymentById = paymentService.getPaymentById(id);

		log.info("**********查询结果：O(∩_∩)O哈哈~" );


		if (paymentById != null) {
			return new CommonResult(200, "**********查询成功O(∩_∩)O哈哈~：serverPort: "+ serverPort +" "+ paymentById, paymentById);
		}
		return new CommonResult(500, "**********没有对应记录：ID" + id);
	}

	@GetMapping(value = "/payment/discovery")
	public Object discovery(){
		List<String> services = discoveryClient.getServices();
		for (String element : services) {
			log.info("**********element:" + element);
		}

		List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");

		for (ServiceInstance instance : instances) {
			log.info(instance.getInstanceId()+ "\t" + instance.getHost()
			+"\t" + instance.getPort() +"\t" + instance.getUri());
		}

		return this.discoveryClient;
	}

	/**
	 * 自写轮询算法测试
	 * @return
	 */
	@GetMapping(value = "/payment/lb")
	public String getPaymentLb(){
		return serverPort;
	}

	/**
	 * OpenFeign超时测试
	 * @return
	 */
	@GetMapping(value = "/payment/feign/timeout")
	public String paymentFeignTimeOut(){
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return serverPort;
	}
}
