package bytemail.domain.question.dto;

import bytemail.domain.question.entity.Question;

public record QuestionResDto(
    Long id,
    String title,
    String content
){
    public Question toQuestion() {
        return new Question(this.id, this.title, this.content);
    }
}
