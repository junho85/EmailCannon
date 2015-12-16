package kr.pe.junho85.service.impl;

import kr.pe.junho85.service.SendService;
import kr.pe.junho85.util.SampleMailMessageFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class SendServiceNaverImpl implements SendService {

    @Value("${smtp.naver.host}")
    private String host;

    @Value("${smtp.naver.username}")
    private String username;

    @Value("${smtp.naver.password}")
    private String password;

    @Override
    public void send() {
        int port = 465;

        String from = "jworld2000@naver.com";
        String to = "junho85@daum.net";
        String subject = "test naver mail subject";
        String text = "test naver mail";

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

        SimpleMailMessage msg = sampleMailMessageFactory.create();

        sender.send(msg);
    }
}
