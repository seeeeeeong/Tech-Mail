package techmail.domain.mail.service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;

@RequiredArgsConstructor
public abstract class AbstractMailService<T> {

    protected final JavaMailSender javaMailSender;
    protected static final String FROM_EMAIL = "Tech-Mail <seeeeeeong2@gmail.com>";


    @Async("mailExecutor")
    public void sendMail(T mailMessage) {
        try {
            MimeMessage mimeMessage = createMimeMessage(mailMessage);
            javaMailSender.send(mimeMessage);
            handleSuccess(mailMessage);
        } catch (MessagingException | MailException e) {
            handleFailure(mailMessage, e);
        } catch (Exception e) {
            handleFailure(mailMessage, e);
        } finally {
            try {
                Thread.sleep(500);
            } catch (InterruptedException ignored) {
                Thread.currentThread().interrupt();
            }
        }
    }

    protected abstract MimeMessage createMimeMessage(T mailMessage) throws MessagingException;

    protected abstract void handleSuccess(T mailMessage);

    protected abstract void handleFailure(T mailMessage, Exception e);
}
