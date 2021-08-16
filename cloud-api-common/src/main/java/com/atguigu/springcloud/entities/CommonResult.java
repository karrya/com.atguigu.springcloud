package com.atguigu.springcloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: com.atguigu.springcloud
 * @Package: com.atguigu.springcloud.entities
 * @Description: note
 * @Author: likai31841
 * @CreateDate: 2021-08-07 19:48
 * @UpdateUser: likai31841
 * @UpdateDate: 2021-08-07 19:48
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * @Date: 2021-08-07 19:48
 * Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
	private Integer code;
	private String message;
	private T data;

	public CommonResult(Integer code, String message) {
		this(code, message, null);
	}
}
