package bytemail.domain.userquestion.service;

import bytemail.domain.mail.service.AbstractMailService;
import bytemail.domain.user.entity.User;
import bytemail.domain.userquestion.dto.UserQuestionMailDto;
import bytemail.domain.userquestion.entity.UserQuestion;
import bytemail.domain.userquestion.repository.UserQuestionRepository;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
public class UserQuestionMailService extends AbstractMailService<UserQuestionMailDto> {

    private final UserQuestionRepository userQuestionRepository;

    public UserQuestionMailService(JavaMailSender javaMailSender, UserQuestionRepository subscribeQuestionRepository) {
        super(javaMailSender);
        this.userQuestionRepository = subscribeQuestionRepository;
    }

    @Override
    protected MimeMessage createMimeMessage(UserQuestionMailDto mailMessage) throws MessagingException {
        User user = mailMessage.user();

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();
        mimeMessage.setHeader("X-SES-CONFIGURATION-SET", "my-first-configuration-set");
        mimeMessage.setHeader("X-SES-MESSAGE-TAGS", "mail-open");

        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, false, "UTF-8");
        helper.setFrom(FROM_EMAIL);
        helper.setTo(user.getEmail());
        helper.setSubject("[TechMail] " + mailMessage.subject());
        helper.setText(mailMessage.text(), true);
        return mimeMessage;
    }

    @Override
    protected void handleSuccess(UserQuestionMailDto mailMessage) {
        userQuestionRepository.save(UserQuestion.success(mailMessage.user(), mailMessage.question()));

    }

    @Override
    protected void handleFailure(UserQuestionMailDto mailMessage, Exception e) {
        userQuestionRepository.save(UserQuestion.fail(mailMessage.user(), mailMessage.question()));
    }
}
