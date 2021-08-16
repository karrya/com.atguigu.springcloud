package com.atguigu.springcloud.service;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: com.atguigu.springcloud
 * @Package: com.atguigu.springcloud.service
 * @Description: note
 * @Author: likai31841
 * @CreateDate: 2021-08-07 20:09
 * @UpdateUser: likai31841
 * @UpdateDate: 2021-08-07 20:09
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * @Date: 2021-08-07 20:09
 * Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved
 **/
public interface PaymentService {
	/**
	 * 插入
	 *
	 * @param payment 实体对象
	 * @return
	 */
	Integer create(Payment payment);


	/**
	 * 按id查找
	 *
	 * @param id id
	 * @return
	 */
	Payment getPaymentById(@Param("id") Long id);
}
