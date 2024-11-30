package bytemail.domain.user.dto;


import java.util.List;

public record CreateUserReqDto(
        String email,
        String category,
        String code
){
}
