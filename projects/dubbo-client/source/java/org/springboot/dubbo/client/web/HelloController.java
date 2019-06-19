package org.springboot.dubbo.client.web;

import org.apache.dubbo.config.annotation.Reference;
import org.springboot.dubbo.api.service.HelloService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chiangfai
 **/
@RestController
public class HelloController {

    @Reference(version = "${dubbo.service.version}")
    private HelloService helloService;

    @RequestMapping("/hello")
    public String hello() {
        return helloService.sayHello("橘右京");
    }
}
