package com.sun.cloud.loadbalance;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author zhaoyang
 * @description
 * @create 2020-05-31 13:51
 */
public interface MySelfLoadBalance {

    ServiceInstance choose(List<ServiceInstance> instanceList);

}
