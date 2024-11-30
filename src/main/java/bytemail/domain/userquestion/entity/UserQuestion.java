package bytemail.domain.userquestion.entity;

import bytemail.domain.question.entity.Question;
import bytemail.domain.user.entity.User;
import bytemail.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "user_question")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class UserQuestion extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    private Question question;

    private boolean isSuccess;

    public UserQuestion(User user, Question question, boolean isSuccess) {
        this.user = user;
        this.question = question;
        this.isSuccess = isSuccess;
    }

    public static UserQuestion success(User user, Question question) {
        return new UserQuestion(user, question, true);
    }

    public static UserQuestion fail(User user, Question question) {
        return new UserQuestion(user, question, false);
    }

}
