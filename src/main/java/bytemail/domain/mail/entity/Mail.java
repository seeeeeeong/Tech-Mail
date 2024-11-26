package bytemail.domain.mail.entity;

import bytemail.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Mail extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String type;

    private boolean isSuccess;

    public static Mail success(String email, String type) {
        return new Mail(null, email, type, true);
    }

    public static Mail fail(String email, String type) {
        return new Mail(null, email, type, false);
    }


}
