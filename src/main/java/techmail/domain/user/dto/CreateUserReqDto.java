package techmail.domain.user.dto;


public record CreateUserReqDto(
        String email,
        String category,
        String code
){
}
