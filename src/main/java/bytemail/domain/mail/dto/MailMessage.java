package bytemail.domain.mail.dto;

public record MailMessage(
        String to,
        String subject,
        String text,
        String type
) {
}
