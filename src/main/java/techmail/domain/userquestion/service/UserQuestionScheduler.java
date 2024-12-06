package techmail.domain.userquestion.service;

import techmail.domain.question.dto.QuestionResDto;
import techmail.domain.question.entity.QuestionCategory;
import techmail.domain.question.service.QuestionService;
import techmail.domain.user.entity.User;
import techmail.domain.user.repository.UserRepository;
import techmail.domain.userquestion.dto.UserQuestionMailDto;
import techmail.domain.userquestion.view.UserQuestionView;
import techmail.global.exception.BusinessException;
import techmail.global.exception.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class UserQuestionScheduler {

    private final UserRepository userRepository;
    private final UserQuestionMailService userQuestionMailService;
    private final UserQuestionView userQuestionView;
    private final QuestionService questionService;

    @Scheduled(cron = "0 0 7 ? * WED", zone = "Asia/Seoul")
    public void sendMail() {
        initCache();

        LocalDateTime now = ZonedDateTime.now(ZoneId.of("Asia/Seoul")).toLocalDateTime();
        List<User> users = userRepository.selectUserList(now);

        users.stream()
                .map(this::getQuestion)
                .filter(Objects::nonNull)
                .forEach(userQuestionMailService::sendMail);
    }

    private void initCache() {
        questionService.getAllByCategory(QuestionCategory.BACKEND.name());
    }

    private UserQuestionMailDto getQuestion(User user) {
        try {
            List<QuestionResDto> questionResDtoList = questionService.getAllByCategory(user.getCategory().name()).stream()
                    .filter(question -> !user.hasQuestion(question.id()))
                    .collect(Collectors.toList());

            String subject = "오늘의 지식을 보내드려요.";
            String text = createText(user, questionResDtoList.get(0));
            return new UserQuestionMailDto(user, questionResDtoList.get(0).toQuestion(), subject, text);
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
