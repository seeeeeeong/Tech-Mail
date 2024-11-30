package bytemail.domain.user.entity;

import bytemail.domain.question.dto.QuestionResDto;
import bytemail.domain.question.entity.Question;
import bytemail.domain.question.entity.QuestionCategory;
import bytemail.domain.userquestion.entity.UserQuestion;
import bytemail.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
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

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private QuestionCategory category;

    @Column(nullable = false, unique = true)
    private String token;

    @Column(nullable = true)
    private LocalDateTime deletedAt;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private List<UserQuestion> userQuestions;

    public User(String email, QuestionCategory category) {
        this.email = email;
        this.category = category;
        this.token = UUID.randomUUID().toString();
        this.deletedAt = null;
    }

    public void deleteUser() {
        this.deletedAt = LocalDateTime.now();
    }

    public boolean hasQuestion(Long questionId) {
        return userQuestions.stream()
                .anyMatch(userQuestion -> userQuestion.getQuestion().getId().equals(questionId));
    }
}
