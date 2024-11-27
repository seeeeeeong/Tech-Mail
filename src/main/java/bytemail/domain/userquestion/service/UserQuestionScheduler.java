package bytemail.domain.userquestion.service;

import bytemail.domain.question.dto.QuestionResDto;
import bytemail.domain.question.service.QuestionService;
import bytemail.domain.user.entity.User;
import bytemail.domain.user.repository.UserRepository;
import bytemail.domain.userquestion.dto.UserQuestionMailDto;
import bytemail.domain.userquestion.service.UserQuestionMailService;
import bytemail.domain.userquestion.view.UserQuestionView;
import bytemail.global.exception.BusinessException;
import bytemail.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class UserQuestionScheduler {

    private final UserRepository subscribeRepository;
    private final UserQuestionMailService userQuestionMailService;
    private final UserQuestionView userQuestionView;
    private final QuestionService questionService;

    public void sendMail() {
        LocalDateTime now = ZonedDateTime.now(ZoneId.of("Asia/Seoul")).toLocalDateTime();
        List<User> users = subscribeRepository.selectUserList(now);

        users.stream()
                .map(this::getQuestion)
                .filter(Objects::nonNull)
                .forEach(userQuestionMailService::sendMail);
    }

    private UserQuestionMailDto getQuestion(User user) {
        try {
            QuestionResDto questionResDto = questionService.getQuestionListNotIn(user);
            String subject = "오늘의 면접 질문을 보내드려요.";
            String text = createText(user, questionResDto);
            return new UserQuestionMailDto(user, questionResDto.toQuestion(), subject, text);
        } catch (Exception e) {
            throw new BusinessException(ErrorCode.QUESTION_NOT_FOUND);
        }
    }

    private String createText(User user, QuestionResDto response) {
        HashMap<Object, Object> attribute = new HashMap<>();
        attribute.put("questionId", response.id());
        attribute.put("question", response.title());
        attribute.put("email", user.getEmail());
        attribute.put("token", user.getToken());

        return userQuestionView.render(attribute);
    }
}
