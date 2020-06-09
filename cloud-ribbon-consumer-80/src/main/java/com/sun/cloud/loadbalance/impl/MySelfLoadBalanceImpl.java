package com.sun.cloud.loadbalance.impl;

import com.sun.cloud.loadbalance.MySelfLoadBalance;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhaoyang
 * @description
 * @create 2020-05-31 13:54
 */
@Component
public class MySelfLoadBalanceImpl implements MySelfLoadBalance {

    private AtomicInteger atomicInteger;

    public MySelfLoadBalanceImpl() {
        this.atomicInteger = new AtomicInteger(0);
    }

    @Override
    public ServiceInstance choose(List<ServiceInstance> instanceList) {
        if (instanceList == null || instanceList.size() == 0) {
            throw new RuntimeException("当前服务列表为空");
        }
        int total = incrementAndGetModulo();
        int index = total % instanceList.size();
        return instanceList.get(index);
    }

    private int incrementAndGetModulo() {
        int current;
        int next;
        do {
            current = atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        } while (!this.atomicInteger.compareAndSet(current, next));
        System.out.println(Thread.currentThread().getName() + "线程的第" + next + "次请求！");
        return next;
    }
}
