package org.springboot.dubbo.client;

import org.apache.dubbo.config.annotation.Reference;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springboot.dubbo.api.service.HelloService;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author chiangfai
 **/
@SpringBootApplication
public class DubboClientApplication {

    private final Logger log = LoggerFactory.getLogger(getClass());

    //@Reference(version = "${dubbo.service.version}", url = "dubbo://127.0.0.1:12345")
    @Reference(version = "${dubbo.service.version}")
    private HelloService helloService;

    public static void main(String[] args) {
        //SpringApplication.run(DubboClientApplication.class).close();
        SpringApplication.run(DubboClientApplication.class, args);
    }

    @Bean
    public ApplicationRunner runner() {
        return args -> {
            log.info(helloService.sayHello("world"));
        };
    }
}
