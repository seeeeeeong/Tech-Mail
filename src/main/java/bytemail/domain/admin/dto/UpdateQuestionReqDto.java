package bytemail.domain.admin.dto;

public record UpdateQuestionReqDto(
        Long id,
        String title,
        String content
){
}
