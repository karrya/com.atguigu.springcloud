package com.atguigu.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Method
 * @Author likai31841
 * @Version  1.0
 * @Date 2021-08-15 18:37
 */
@RestController
@RefreshScope
public class ConfigClientConroller {

    @Value("${config.info}")
    private String configInfo;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/configIngo")
    public String getConfigInfo() {
        return "configInfo: " + configInfo + "\t\n\n" + "serverPort: " + serverPort;
    }
}

