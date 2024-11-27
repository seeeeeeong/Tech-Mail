package bytemail.domain.admin.dto;

import bytemail.domain.question.entity.Question;

public record CreateQuestionReqDto(
        String title,
        String content
) {
    public Question toQuestion() {
        return new Question(title, content);
    }
}
