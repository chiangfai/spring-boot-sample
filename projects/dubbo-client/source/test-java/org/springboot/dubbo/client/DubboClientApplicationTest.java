package org.springboot.dubbo.client;

import org.apache.dubbo.config.annotation.Reference;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springboot.dubbo.api.service.HelloService;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author chiangfai
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DubboClientApplication.class)
@WebAppConfiguration
public class DubboClientApplicationTest {
    private final Logger log = LoggerFactory.getLogger(getClass());

    //@Reference(version = "${dubbo.service.version}", url = "dubbo://127.0.0.1:12345")
    @Reference(version = "${dubbo.service.version}")
    private HelloService helloService;

    @Test
    public void test() {
        log.info(helloService.sayHello("小梦梦是猪！"));
    }
}