package com.atguigu.springcloud.service.impl;

import com.atguigu.springcloud.dao.PaymentDao;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: com.atguigu.springcloud
 * @Package: com.atguigu.springcloud.service.impl
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
@Service
public class PaymentServiceImpl implements PaymentService {


	@Autowired
	private PaymentDao paymentDao;

	/**
	 * 插入
	 *
	 * @param payment 实体对象
	 * @return
	 */
	@Override
	public Integer create(Payment payment) {
		return paymentDao.create(payment);
	}

	/**
	 * 按id查找
	 *
	 * @param id id
	 * @return
	 */
	@Override
	public Payment getPaymentById(Long id) {
		return paymentDao.getPaymentById(id);
	}
}
