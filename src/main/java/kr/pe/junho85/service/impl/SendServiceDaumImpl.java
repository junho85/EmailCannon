package kr.pe.junho85.service.impl;

import kr.pe.junho85.service.SendService;
import kr.pe.junho85.util.SampleMailMessageFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class SendServiceDaumImpl implements SendService {

    @Value("${smtp.daum.host}")
    private String host;

    @Value("${smtp.daum.username}")
    private String username;

    @Value("${smtp.daum.password}")
    private String password;

    @Override
    public void send() {
        int port = 465;

        Properties properties = new Properties();
        properties.put("mail.smtp.auth", true);
        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", port);
        properties.put("mail.transport.protocol", "smtps");
        properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        properties.put("mail.smtps.quitwait", false);
        properties.put("mail.smtp.socketFactory.port", port);
        properties.put("mail.smtp.starttls.enable", true);

        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        sender.setHost(host);
        sender.setPort(port);
        sender.setUsername(username);
        sender.setPassword(password);
        sender.setJavaMailProperties(properties);

        SampleMailMessageFactory sampleMailMessageFactory = new SampleMailMessageFactory();

        SimpleMailMessage msg = sampleMailMessageFactory.create("junho85@daum.net", "junho85@daum.net");
        msg.setSubject("daum test");

        sender.send(msg);
    }
}
