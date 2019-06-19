package org.springboot.mail.service;

import org.springboot.mail.model.MailToBean;

/**
 * @author chiangfai
 **/
public interface MailService {
    void sendSimpleMail(MailToBean bean);
}
