package bytemail.domain.user.entity;

import bytemail.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@Table(name = "user")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false, unique = true)
    private String token;

    @Column(nullable = true)
    private LocalDateTime deletedAt;

    public User(String email) {
        this.email = email;
        this.token = UUID.randomUUID().toString();
        this.deletedAt = null;
    }

    public void unSubscribe() {
        this.deletedAt = LocalDateTime.now();
    }
}
