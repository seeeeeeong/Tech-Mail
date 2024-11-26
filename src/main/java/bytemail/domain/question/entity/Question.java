package bytemail.domain.question.entity;

import bytemail.domain.question.enums.QuestionCategory;
import bytemail.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Question extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String content;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private QuestionCategory category;

    public static Question create(
            final String title,
            final String content,
            final QuestionCategory category
    ) {
        return Question
                .builder()
                .title(title)
                .content(content)
                .category(category)
                .build();
    }

}
