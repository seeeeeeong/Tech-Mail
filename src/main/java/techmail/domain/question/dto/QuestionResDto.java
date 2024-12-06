package techmail.domain.question.dto;

import techmail.domain.question.entity.Question;
import techmail.domain.question.entity.QuestionCategory;

public record QuestionResDto(
    Long id,
    String title,
    String content,
    QuestionCategory category
){
    public Question toQuestion() {
        return new Question(this.id, this.title, this.content, category);
    }
}
