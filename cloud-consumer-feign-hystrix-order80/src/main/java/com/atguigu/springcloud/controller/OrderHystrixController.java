package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.OrderHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Method
 * @Author likai31841
 * @Version  1.0
 * @Date 2021-08-14 12:17
 */
@RestController
@Slf4j
public class OrderHystrixController {

    @Autowired
    private OrderHystrixService orderHystrixService;

    /**
     * 正常访问
     *
     * @param id
     * @return
     */
    @GetMapping("/consume/payment/hystrix/ok/{id}")
    String paymentInfoOK(@PathVariable("id") Integer id){
        return orderHystrixService.paymentInfoOk(id);
    }

    /**
     * 超时访问
     *
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentInfoTimeOutHandler",
            commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds"
                    , value = "500000")})
    @GetMapping("/consume/payment/hystrix/timeout/{id}")
    String paymentInfoTimeOut(@PathVariable("id") Integer id){
        //int i = 10 /0 ;
        return orderHystrixService.paymentInfoTimeOut(id);
    }

    /**
     * 服务降级兜底方法，当方法paymentInfoTimeOut()出现异常或超时
     *就调用下面的方法进行兜底
     * @param id
     * @return
     */
    public String paymentInfoTimeOutHandler(Integer id) {
        return "线程池： " + Thread.currentThread().getName()
                + "  【80系统：异常】系统忙，请稍后重试！！,id: " +
                id + "\t" + "！！！！！！！o(╥﹏╥)o！！！！！！";
    }

}
