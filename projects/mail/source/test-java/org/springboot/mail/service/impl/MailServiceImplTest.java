package org.springboot.mail.service.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springboot.mail.MailApplication;
import org.springboot.mail.model.MailToBean;
import org.springboot.mail.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

/**
 * @author chiangfai
 **/
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MailApplication.class)
@WebAppConfiguration
public class MailServiceImplTest {

    @Autowired
    private MailService mailService;

    @Test
    public void sendSimpleMail() {
        MailToBean bean = new MailToBean();
        bean.setFrom("chiangfai@vip.qq.com");
        bean.setTo("502557213@qq.com");
        bean.setSubject("test simple");
        bean.setText("小梦梦你好，王者来开黑？");
        mailService.sendSimpleMail(bean);
    }
}