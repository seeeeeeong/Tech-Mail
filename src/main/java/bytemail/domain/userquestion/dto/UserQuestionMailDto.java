package bytemail.domain.userquestion.dto;

import bytemail.domain.question.entity.Question;
import bytemail.domain.user.entity.User;

public record UserQuestionMailDto(
        User user,
        Question question,
        String subject,
        String text
)
{}