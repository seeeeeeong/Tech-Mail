package bytemail.domain.admin.dto;

import bytemail.domain.question.entity.Question;
import bytemail.domain.question.entity.QuestionCategory;

public record CreateQuestionReqDto(
        String title,
        String content,
        String category
) {
    public Question toQuestion() {
        return new Question(title, content, QuestionCategory.from(category));
    }
}
