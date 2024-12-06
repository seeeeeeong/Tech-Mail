package techmail.domain.admin.dto;

import techmail.domain.question.entity.Question;
import techmail.domain.question.entity.QuestionCategory;

public record CreateQuestionReqDto(
        String title,
        String content,
        String category
) {
    public Question toQuestion() {
        return new Question(title, content, QuestionCategory.from(category));
    }
}
