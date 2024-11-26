package bytemail.domain.question.repository;

import bytemail.domain.question.dto.QuestionResponse;
import bytemail.domain.question.entity.Question;
import bytemail.domain.question.enums.QuestionCategory;
import bytemail.domain.subscribe.entity.Subscribe;
import bytemail.global.repository.Querydsl5RepositorySupport;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQuery;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import static bytemail.domain.question.entity.QQuestion.question;

public class QuestionQueryRepositoryImpl extends Querydsl5RepositorySupport implements QuestionQueryRepository {

    public QuestionQueryRepositoryImpl() {
        super(Question.class);
    }

    @Override
    public Page<QuestionResponse> findQuestions(String category, Pageable pageable) {
        return applyPagination(pageable,
                queryFactory ->
                        queryFactory.select(Projections.constructor(
                                        QuestionResponse.class,
                                        question.id,
                                        question.title,
                                        question.content,
                                        question.category
                                ))
                                .from(question)
                                .where(eqCategory(category)),

                queryFactory ->
                        queryFactory.select(question.count())
                                .from(question)
                                .where(eqCategory(category))
        );
    }

    private BooleanExpression eqCategory(String category) {
        if (category == null || "all".equalsIgnoreCase(category)) {
            return null;
        }
        return question.category.eq(QuestionCategory.from(category));
    }
}
