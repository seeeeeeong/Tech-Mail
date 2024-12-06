package techmail.domain.admin.dto;

public record UpdateQuestionReqDto(
        Long id,
        String title,
        String content
){
}
