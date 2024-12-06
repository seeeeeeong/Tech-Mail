package techmail.domain.userquestion.repository;

import techmail.domain.question.dto.QuestionResDto;
import techmail.domain.userquestion.entity.UserQuestion;
import techmail.global.repository.Querydsl5RepositorySupport;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import static techmail.domain.question.entity.QQuestion.question;
import static techmail.domain.user.entity.QUser.user;
import static techmail.domain.userquestion.entity.QUserQuestion.userQuestion;

public class UserQuestionQueryRepositoryImpl extends Querydsl5RepositorySupport implements UserQuestionQueryRepository {

    public UserQuestionQueryRepositoryImpl() {
        super(UserQuestion.class);
    }

    @Override
    public Page<QuestionResDto> selectUserQuestionPageList(String email, Pageable pageable) {
        return applyPagination(pageable,
                queryFactory ->
                        queryFactory.select(Projections.constructor(
                                        QuestionResDto.class,
                                        question.id,
                                        question.title,
                                        question.content,
                                        question.category
                                ))
                                .from(userQuestion)
                                .join(user).on(userQuestion.user.eq(user))
                                .join(question).on(userQuestion.question.eq(question))
                                .where(eqEmail(email)
                                        .and(user.deletedAt.isNull()
                                                .and(userQuestion.isSuccess))),

                queryFactory ->
                        queryFactory.select(userQuestion.count())
                                .from(userQuestion)
                                .join(user).on(userQuestion.user.eq(user))
                                .where(eqEmail(email)
                                        .and(user.deletedAt.isNull())
                                        .and(userQuestion.isSuccess))
        );
    }
    private BooleanExpression eqEmail(String email) {
        return user.email.eq(email);
    }

}
