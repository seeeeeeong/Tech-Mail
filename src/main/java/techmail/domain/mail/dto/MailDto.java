package techmail.domain.mail.dto;

public record MailDto(
        String to,
        String subject,
        String text,
        String type
) {
}
