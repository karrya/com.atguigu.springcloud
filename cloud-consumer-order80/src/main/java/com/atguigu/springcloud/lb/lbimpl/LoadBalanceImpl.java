package com.atguigu.springcloud.lb.lbimpl;

import com.atguigu.springcloud.lb.LoadBalance;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 文件描述
 *
 * @ProductName: Hundsun HEP
 * @ProjectName: com.atguigu.springcloud
 * @Package: com.atguigu.springcloud.controller
 * @Description: note
 * @Author: likai31841
 * @CreateDate: 2021-08-07 20:26
 * @UpdateUser: likai31841
 * @UpdateDate: 2021-08-07 20:26
 * @UpdateRemark: The modified content
 * @Version: 1.0
 * @Date: 2021-08-07 20:26
 * Copyright © 2021 Hundsun Technologies Inc. All Rights Reserved
 **/
@Component
public class LoadBalanceImpl implements LoadBalance {

    private AtomicInteger atomicIntege = new AtomicInteger(0);

    private final int getIncrement() {
        int current;
        int next;
        do {
            current = this.atomicIntege.get();
            next = current >= 2147483647 ? 0 : current + 1;
            //next = (current + 1) % modulo;
        } while (!this.atomicIntege.compareAndSet(current, next));

        System.out.printf("**************net:" + next);
        return next;
    }

    @Override
    public ServiceInstance instance(List<ServiceInstance> instance) {
        int index = getIncrement() % instance.size();
        return instance.get(index);
    }
}
