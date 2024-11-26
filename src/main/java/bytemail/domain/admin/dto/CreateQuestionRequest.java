package bytemail.domain.admin.dto;

public record CreateQuestionRequest(
        String title,
        String content,
        String category
) {
}
