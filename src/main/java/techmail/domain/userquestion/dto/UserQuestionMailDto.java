package techmail.domain.userquestion.dto;

import techmail.domain.question.entity.Question;
import techmail.domain.user.entity.User;

public record UserQuestionMailDto(
        User user,
        Question question,
        String subject,
        String text
)
{}