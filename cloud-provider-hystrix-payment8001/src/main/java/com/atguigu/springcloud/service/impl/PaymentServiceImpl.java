package com.atguigu.springcloud.service.impl;

import cn.hutool.core.util.IdUtil;
import com.atguigu.springcloud.service.PaymentService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * <h3>cloud2020</h3>
 *
 * @author : Likai
 * @date : 2020-06-24 14:27
 **/
@Service
@DefaultProperties(defaultFallback = "paymentGlobalFallBack")
public class PaymentServiceImpl implements PaymentService {

    /***************************服务降级***********************/
    @Override
    @HystrixCommand
    public String paymentInfoOk(Integer id) {
        //int i =10/0;
        return "线程池： " + Thread.currentThread().getName() +
                "  paymentInfo_Ok,id: " + id + "\t" + "O(∩_∩)O哈哈~";
    }

    @Override
    @HystrixCommand(fallbackMethod = "paymentInfoTimeOutHandler",
            commandProperties = {@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds"
                    , value = "5000")})
    public String paymentInfoTimeOut(Integer id) {
        //设置异常！！！
        int timeOut = 3000;
        //int i =10/0;
        try {
            TimeUnit.MILLISECONDS.sleep(timeOut);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "线程池： " + Thread.currentThread().getName()
                + "  【8001系统：正常】 paymentInfo_TimeOut,id: " + id + "\t" + "O(∩_∩)O哈哈~"
                + " 耗时: " + timeOut + " 毫秒钟！！！";
    }



    /**
     * 1对1的服务降级方法，处理起来都得有
     * 服务降级兜底方法，当方法paymentInfoTimeOut()出现异常或超时
     *就调用下面的方法进行兜底
     * @param id
     * @return
     */
    public String paymentInfoTimeOutHandler(Integer id) {
        return "线程池： " + Thread.currentThread().getName()
                + "  【8001系统：异常】系统忙，请稍后重试！！,id: " +
                id + "\t" + "！！！！！！！o(╥﹏╥)o！！！！！！";
    }

    /**
     * 全局兜底方法
     * @return
     */
    public String paymentGlobalFallBack(){
        return "我们是全局的兜底方法.......";
    }


    /**
     * huo
     * @param id
     * @return
     */
    @HystrixCommand(fallbackMethod = "paymentCricuitBreakfallBack",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"), //是否开启短路器
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"), //请求次数
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"), //时间窗口期
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60") //失败率达到多少后跳闸
    })
    public String paymentCricuitBreak(Integer id){
        if (id < 0){
            throw new RuntimeException("###################id 不能为负数！！");
        }
        String serialNumber = IdUtil.simpleUUID();

        return Thread.currentThread().getName()+"\t"+"掉用成功，流水号： "+serialNumber;
    }

    public String paymentCricuitBreakfallBack(Integer id) {
        return "id 不能为负数，请稍后重试！！，o(╥﹏╥)o~   id:" + id;
    }

}