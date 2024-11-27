package bytemail.domain.user.dto;


public record CreateUserReqDto(
        String email,
        String code
){
}
