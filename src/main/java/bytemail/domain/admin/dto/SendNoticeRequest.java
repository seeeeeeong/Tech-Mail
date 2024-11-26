package bytemail.domain.admin.dto;

import java.time.LocalDateTime;

public record SendNoticeRequest(
        String title,
        String content,
        LocalDateTime reservedTime
){}
