package bytemail.domain.user.dto;

public record DeleteUserReqDto(
        String email,
        String token
) {
}
