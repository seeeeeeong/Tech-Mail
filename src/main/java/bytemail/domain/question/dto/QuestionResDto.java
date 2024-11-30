package bytemail.domain.question.dto;

import bytemail.domain.question.entity.Question;
import bytemail.domain.question.entity.QuestionCategory;

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
