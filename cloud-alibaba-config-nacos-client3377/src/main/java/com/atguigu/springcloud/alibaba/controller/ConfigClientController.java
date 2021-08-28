package com.atguigu.springcloud.alibaba.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Method
 * @RefreshScope: 支持Nacos的动态刷新功能。
 * @Author likai31841
 * @Version 1.0
 * @Date 2021-08-19 18:50
 */
@RestController
@RefreshScope
public class ConfigClientController {

    /**
     * Nacos中的配置获取
     */
    @Value("${config.info}")
    private String configInfo;

    @GetMapping("/config/info")
    public String getConfigInfo() {
        return configInfo;
    }
}
