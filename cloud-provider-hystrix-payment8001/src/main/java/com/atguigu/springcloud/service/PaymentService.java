package com.atguigu.springcloud.service;

/**
 * <h3>cloud2020</h3>
 *
 * @author : Likai
 * @date : 2020-06-24 14:26
 **/
public interface PaymentService {

    //***************************服务降级***********************//

    /**
     * 正常的方法
     * @param id
     * @return
     */
     String paymentInfoOk(Integer id);

    /**
     * 超时的方法
     * @param id
     * @return
     */
     String paymentInfoTimeOut(Integer id);

    //***************************服务熔断***********************//

    /**
     * 服务熔断相关测试方法
     * @param id
     * @return
     */
     String paymentCricuitBreak(Integer id);

}