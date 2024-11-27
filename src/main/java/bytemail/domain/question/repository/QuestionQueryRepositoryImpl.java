package bytemail.domain.question.repository;

import bytemail.domain.question.dto.QuestionResDto;
import bytemail.domain.question.entity.Question;
import bytemail.domain.user.entity.User;
import bytemail.global.repository.Querydsl5RepositorySupport;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.JPAExpressions;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

import static bytemail.domain.question.entity.QQuestion.question;
import static bytemail.domain.userquestion.entity.QUserQuestion.userQuestion;


public class QuestionQueryRepositoryImpl extends Querydsl5RepositorySupport implements QuestionQueryRepository {

    public QuestionQueryRepositoryImpl() {
        super(Question.class);
    }

    @Override
    public Page<QuestionResDto> selectQuestionPageList(Pageable pageable) {
        return applyPagination(pageable,
                queryFactory ->
                        queryFactory.select(Projections.constructor(
                                        QuestionResDto.class,
                                        question.id,
                                        question.title,
                                        question.content
                                ))
                                .from(question),

                queryFactory ->
                        queryFactory.select(question.count())
                                .from(question)
        );
    }

    @Override
    public Optional<QuestionResDto> selectQuestionDetail(Long questionId) {
        return Optional.ofNullable(select(Projections.constructor(
                QuestionResDto.class,
                question.id,
                question.title,
                question.content
                ))
                .from(question)
                .where(question.id.eq(questionId))
                .fetchOne());
    }

    @Override
    public Optional<QuestionResDto> selectQuestionListNotIn(User user) {
        return Optional.ofNullable(
                select(
                        Projections.constructor(
                                QuestionResDto.class,
                                question.id,
                                question.title,
                                question.content
                        ))
                        .from(question)
                        .where(question.id.notIn(
                                JPAExpressions.select(userQuestion.question.id)
                                        .from(userQuestion)
                                        .where(userQuestion.user.id.eq(user.getId())
                        )))
                        .orderBy(question.id.asc())
                        .limit(1)
                        .fetchFirst()
        );
    }

    @Override
    public List<QuestionResDto> findAllQuestions() {
        return select(
                Projections.constructor(
                        QuestionResDto.class,
                        question.id,
                        question.title,
                        question.content
                ))
                .from(question)
                .fetch();
    }
}
