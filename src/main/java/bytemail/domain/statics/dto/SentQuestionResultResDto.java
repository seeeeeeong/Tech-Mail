package bytemail.domain.statics.dto;

public record SentQuestionResultResDto(
        String type,
        Long success,
        Long fail
) {
}
