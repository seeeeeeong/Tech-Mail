package techmail.domain.user.entity;

import techmail.global.entity.BaseEntity;
import techmail.global.exception.BusinessException;
import techmail.global.exception.ErrorCode;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class TempUser extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String verifyCode;

    @Column(nullable = false)
    private boolean isVerified;

    public TempUser(String email, String verifyCode) {
        this(null, email, verifyCode, false);
    }

    public void verify(String code) {
        if (!verifyCode.equals(code)) {
            throw new BusinessException(ErrorCode.INVALID_VERIFY_CODE);
        }
        this.isVerified = true;
    }

}
