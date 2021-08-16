package com.atguigu.springloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * @Method 采用配置的方式进行，不再使用配置的方式
 * @Author likai31841
 * @Version 1.0
 * @Date 2021-08-15 15:15
 */
@Component
public class GateWayConfig {


    /**
     * routes:
     * - id: payment_route # 路由的id,没有规定规则但要求唯一,建议配合服务名
     * uri: lb://cloud-payment-service
     * predicates:
     * - Path=/payment/get/**    #断言，路径相匹配的进行路由
     *
     * @param routeLocatorBuilder
     * @return
     */
    @Bean
    RouteLocator routes(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        // 访问localhost:9527/guonei 就会映射到 https://news.baidu.com/guonei
        routes.route("route_id", r -> r.path("/guonei")
                .uri("https://news.baidu.com/guonei")).build();

        return routes.build();
    }
}
