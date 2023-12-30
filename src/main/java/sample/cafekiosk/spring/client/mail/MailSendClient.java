package sample.cafekiosk.spring.client.mail;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MailSendClient {
    public boolean sendEmail(String fromEmail, String toEmail, String subject, String content) {
        log.info("메일 전송");
        log.info("fromEmail: " + fromEmail);
        throw new IllegalArgumentException("메일 전송에 실패했습니다.");
    }
}