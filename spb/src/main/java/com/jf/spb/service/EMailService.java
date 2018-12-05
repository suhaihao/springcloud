package com.jf.spb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.mail.internet.MimeMessage;
import java.io.File;

@Service
public class EMailService {
    @Autowired
    JavaMailSenderImpl javaMailSenderImpl;

    @Async
    public void fsEMail(){
        //        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        try {
            MimeMessage mimeMessage = javaMailSenderImpl.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
            helper.setSubject("渣渣");
            helper.setText("傻吊");
            helper.setTo("505604843@qq.com");
            helper.setFrom("505604843@qq.com");
            helper.addAttachment("1.jpg",new File("D:\\work_ide\\spb\\src\\main\\resources\\static\\1.jpg"));
            javaMailSenderImpl.send(mimeMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
