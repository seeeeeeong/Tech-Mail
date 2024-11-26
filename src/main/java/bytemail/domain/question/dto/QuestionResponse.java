package bytemail.domain.question.dto;

import bytemail.domain.question.enums.QuestionCategory;

public record QuestionResponse(
    Long id,
    String title,
    String content,
    QuestionCategory category
){
}
