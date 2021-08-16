package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * <h3>cloud2020</h3>
 *
 * @author : Likai
 * @date : 2020-06-24 14:24
 **/
@RestController
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/payment/hsytrix/ok/{id}")
    public String paymentInfoOk(@PathVariable("id") Integer id){
        String result = paymentService.paymentInfoOk(id);

        log.info("**********result:" + result);
        return result;
    }

    @GetMapping(value = "/payment/hsytrix/timeout/{id}")
    public String paymentInfoTimeOut(@PathVariable("id") Integer id){
        String result = paymentService.paymentInfoTimeOut(id);

        log.info("**********result:" + result);
        return result;
    }

    /**
     * ***************************服务熔断***********************
     * @param id
     * @return
     */
    @GetMapping(value = "/payment/cricuit/{id}")
    public String paymentCricuitBreak(@PathVariable("id")Integer id){
        String result = paymentService.paymentCricuitBreak(id);
        log.info("******************reslut: "+result);
        return result;
    }

}
