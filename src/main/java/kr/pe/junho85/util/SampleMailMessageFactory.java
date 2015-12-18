package kr.pe.junho85.util;

import org.springframework.mail.SimpleMailMessage;

public class SampleMailMessageFactory {
    public SimpleMailMessage create(String from, String to) {
        String subject = "test naver mail subject2";
        String text = "test naver mail2";

        SimpleMailMessage templateMessage;

        templateMessage = new SimpleMailMessage();

        templateMessage.setSubject(subject);
        templateMessage.setFrom(from);
        templateMessage.setTo(to);
        templateMessage.setText(text);

        SimpleMailMessage msg = new SimpleMailMessage(templateMessage);

        return msg;
    }

    public SimpleMailMessage create() {
        String from = "jworld2000@naver.com";
        String to = "junho85@daum.net";

        return create(from, to);
    }
}
