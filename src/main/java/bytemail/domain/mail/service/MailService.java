package bytemail.domain.mail.service;

import bytemail.domain.mail.dto.MailDto;
import bytemail.domain.mail.entity.Mail;
import bytemail.domain.mail.repository.MailRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class MailService extends AbstractMailService<MailDto> {

    private final MailRepository mailRepository;

    public MailService(JavaMailSender javaMailSender, MailRepository mailRepository) {
        super(javaMailSender);
        this.mailRepository = mailRepository;
    }

    @Override
    protected MimeMessage createMimeMessage(MailDto mailDto) throws MessagingException {
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "UTF-8");
        helper.setFrom(FROM_EMAIL);
        helper.setTo(mailDto.to());
        helper.setSubject("[Tech Mail] " + mailDto.subject());
        helper.setText(mailDto.text(), true);
        return mimeMessage;
    }

    @Override
    protected void handleSuccess(MailDto mailDto) {
        mailRepository.save(Mail.success(mailDto.to(), mailDto.type()));
    }

    @Override
    protected void handleFailure(MailDto mailDto, Exception e) {
        mailRepository.save(Mail.fail(mailDto.to(), mailDto.type()));
    }
}
