package bytemail.domain.admin.dto;

import java.time.LocalDateTime;

public record SendNoticeReqDto(
        String title,
        String content,
        LocalDateTime reservedTime
){}
