package bytemail.domain.subscribe.entity;

import bytemail.domain.question.enums.QuestionCategory;
import bytemail.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Subscribe extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private QuestionCategory category;

    @Column(nullable = false)
    private Long nextQuestionSequence;

    @Column(nullable = false, unique = true)
    private String token;

    @Column(nullable = true)
    private LocalDateTime deletedAt;

    public Subscribe(String email, QuestionCategory category) {
        this.email = email;
        this.category = category;
        this.nextQuestionSequence = getSequenceByQuestionCategory(category);
        this.token = UUID.randomUUID().toString();
        this.deletedAt = null;
    }

    private long getSequenceByQuestionCategory(QuestionCategory category) {
        if (category == QuestionCategory.BACKEND) {
            return 15L;
        }

        return 0L;
    }

    public void unSubscribe() {
        this.deletedAt = LocalDateTime.now();
    }
}
