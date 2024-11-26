package bytemail.domain.admin.service;

import bytemail.domain.admin.dto.CreateQuestionRequest;
import bytemail.domain.admin.dto.SendNoticeRequest;
import bytemail.domain.admin.dto.UpdateQuestionRequest;
import bytemail.domain.mail.dto.MailMessage;
import bytemail.domain.mail.service.MailService;
import bytemail.domain.question.entity.Question;
import bytemail.domain.question.enums.QuestionCategory;
import bytemail.domain.question.repository.QuestionRepository;
import bytemail.domain.subscribe.repository.SubscribeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final QuestionRepository questionRepository;
    private final SubscribeRepository subscribeRepository;

    private final MailService mailService;

    @Transactional
    public void createQuestion(CreateQuestionRequest request) {
        Question question = Question.create(request.title(), request.content(), QuestionCategory.from(request.category()));
        questionRepository.save(question);
    }

    @Transactional
    public void updateQuestion(UpdateQuestionRequest request) {
        Question question = questionRepository.findById(request.id())
                .orElseThrow(NoSuchElementException::new);
        question.setTitle(request.title());
        question.setContent(request.content());
        question.setCategory(QuestionCategory.from(request.category()));
    }

    @Transactional
    public void sendNotice(SendNoticeRequest request) {
        List<String> emails = subscribeRepository.findEmails();

        emails.stream()
                .map(email -> createMessage(email, request.title(), request.content()))
                .forEach(mailService::sendMail);
    }

    private MailMessage createMessage(String email, String title, String content) {
        return new MailMessage(email, title, content, "notice");
    }

}
