package org.springboot.dubbo.server.service;

import org.apache.dubbo.config.annotation.Service;
import org.springboot.dubbo.api.service.HelloService;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author chiangfai
 * <p>
 *      @Service注解在包org.apache.dubbo.config.annotation.Service，并非Spring中@Service
 * </p>
 **/
@Service(version = "${dubbo.service.version}")
public class HelloServiceImpl implements HelloService {

    /**
     * The default value of ${dubbo.application.name} is ${spring.application.name}
     */
    @Value("${dubbo.application.name}")
    private String serviceId;

    @Override
    public String sayHello(String param) {
        return String.format("[%s] : Hello, %s", serviceId, param);
    }
}
