package bytemail.domain.admin.service;

import bytemail.domain.admin.dto.CreateQuestionReqDto;
import bytemail.domain.admin.dto.SendNoticeReqDto;
import bytemail.domain.admin.dto.UpdateQuestionReqDto;
import bytemail.domain.mail.dto.MailDto;
import bytemail.domain.mail.service.MailService;
import bytemail.domain.question.entity.Question;
import bytemail.domain.question.repository.QuestionRepository;
import bytemail.domain.user.repository.UserRepository;
import bytemail.global.exception.ErrorCode;
import bytemail.global.exception.notfound.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdminService {

    private final QuestionRepository questionRepository;
    private final UserRepository subscribeRepository;

    private final MailService mailService;

    @Transactional
    public void createQuestion(CreateQuestionReqDto request) {
        Question question = request.toQuestion();
        questionRepository.save(question);
    }

    @Transactional
    public void updateQuestion(UpdateQuestionReqDto request) {
        Question question = questionRepository.findById(request.id())
                .orElseThrow(() -> new EntityNotFoundException(ErrorCode.QUESTION_NOT_FOUND));
        question.setTitle(request.title());
        question.setContent(request.content());
    }

    @Transactional
    public void sendNotice(SendNoticeReqDto request) {
        List<String> emailList = subscribeRepository.selectEmailList();

        emailList.stream()
                .map(email -> new MailDto(email, request.title(), request.content(), "notice"))
                .forEach(mailService::sendMail);
    }
}
