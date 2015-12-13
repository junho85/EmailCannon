package kr.pe.junho85.service.impl;

import kr.pe.junho85.service.SendService;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.Properties;

@Service
public class SendServiceNaverImpl implements SendService {

    private SimpleMailMessage templateMessage;

    @Override
    public void send() {
        String host = "smtp.naver.com";
        int port = 465;

        String username = ""; // TODO
        String password = ""; // TODO

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

        templateMessage = new SimpleMailMessage();

        templateMessage.setSubject(subject);
        templateMessage.setFrom(from);
        templateMessage.setTo(to);
        templateMessage.setText(text);

        SimpleMailMessage msg = new SimpleMailMessage(templateMessage);

        sender.send(msg);
    }
}
