package bytemail.domain.mail.service;

import bytemail.domain.mail.dto.MailMessage;
import bytemail.domain.mail.entity.Mail;
import bytemail.domain.mail.repository.MailRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class MailService {

    private static final int MAIL_SENDER_RATE_MILLISECONDS = 500;
    private static final String FROM_EMAIL = "Byte Mail <seeeeeeong2@gmail.com>";

    private final JavaMailSender javaMailSender;

    private final MailRepository mailRepository;

    public void sendMail(MailMessage mailMessage) {
        try {
            MimeMessage mimeMessage = createMimeMessage(mailMessage);
            javaMailSender.send(mimeMessage);
            handleSuccess(mailMessage);
        } catch (MessagingException | MailException e) {
            handleFailure(mailMessage);
        } catch (Exception e) {
            handleFailure(mailMessage);
        } finally {
            try {
                Thread.sleep(MAIL_SENDER_RATE_MILLISECONDS);
            } catch (InterruptedException ignored) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private MimeMessage createMimeMessage(MailMessage message) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "UTF-8");
        helper.setFrom(FROM_EMAIL);
        helper.setTo(message.to());
        helper.setSubject("[Byte Mail] " + message.subject());
        helper.setText(message.text(), true);
        return mimeMessage;
    }

    private void handleSuccess(MailMessage message) {
        mailRepository.save(Mail.success(message.to(), message.type()));
    }

    private void handleFailure(MailMessage message) {
        mailRepository.save(Mail.fail(message.to(), message.type()));
    }
}
