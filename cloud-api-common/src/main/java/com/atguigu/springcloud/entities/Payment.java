package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: com.atguigu.springcloud
 * @Package: com.atguigu.springcloud.entities
 * @Description: note
 * @Author: likai31841
 * @CreateDate: 2021-08-07 19:46
 * @UpdateUser: likai31841
 * @UpdateDate: 2021-08-07 19:46
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * @Date: 2021-08-07 19:46
 * Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Payment implements Serializable {
	private Long id;         //ID
	private  String serial;  //流水号
}
