package com.atguigu.springcloud.dao;

import com.atguigu.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: com.atguigu.springcloud
 * @Package: com.atguigu.springcloud.dao
 * @Description: note
 * @Author: likai31841
 * @CreateDate: 2021-08-07 19:52
 * @UpdateUser: likai31841
 * @UpdateDate: 2021-08-07 19:52
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * @Date: 2021-08-07 19:52
 * Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved
 **/
@Mapper
@Repository
public interface PaymentDao {
	/**
	 * 插入
	 *
	 * @param payment 实体对象
	 * @return
	 */
	 int create(Payment payment);


	/**
	 * 按id查找
	 *
	 * @param id id
	 * @return
	 */
	 Payment getPaymentById(@Param("id") Long id);

}
