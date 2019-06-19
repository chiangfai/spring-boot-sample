package org.springboot.mail.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.springboot.mail.model.MailToBean;
import org.springboot.mail.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * @author chiangfai
 *
 * <p>
 *     Exception:
 *
 *     501 mail from address must be same as authorization user
 *
 *     SimpleMailMessage.setFrom value must equals ${spring.mail.username}
 * </p>
 **/
@Slf4j
@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public void sendSimpleMail(MailToBean bean) {
        SimpleMailMessage mailMessage =new SimpleMailMessage();
        mailMessage.setFrom(bean.getFrom());
        mailMessage.setTo(bean.getTo());
        mailMessage.setSubject(bean.getSubject());
        mailMessage.setText(bean.getText());

        try {
            mailSender.send(mailMessage);
        } catch (MailException e) {
            log.error("send mail error: ", e);
        }
    }
}
