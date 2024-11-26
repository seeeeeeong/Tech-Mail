package bytemail.domain.admin.dto;

public record UpdateQuestionRequest(
        Long id,
        String title,
        String content,
        String category
){
}
