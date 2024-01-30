package com.alibaba.nacos.console.config;

import com.alibaba.cloud.nacos.registry.NacosAutoServiceRegistration;
import com.alibaba.nacos.api.naming.remote.request.InstanceRequest;
import com.alibaba.nacos.api.remote.request.Request;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component
public class RetryRunner implements ApplicationRunner {

    private final NacosAutoServiceRegistration serviceRegistration;

    public RetryRunner(NacosAutoServiceRegistration serviceRegistration){
        this.serviceRegistration = serviceRegistration;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        InstanceRequest nacos = Request.REQUEST_MAP.get("nacos");
        Method method = serviceRegistration.getClass().getDeclaredMethod("register");
        method.setAccessible(true);
        method.invoke(serviceRegistration);
    }
}
