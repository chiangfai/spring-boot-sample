package org.springboot.mail.model;

import lombok.Data;

import java.io.Serializable;

/**
 * @author chiangfai
 **/
@Data
public class MailToBean implements Serializable {

    private static final long serialVersionUID = -5187288152480687086L;

    private String from;
    private String to;
    private String subject;
    private String text;

}
