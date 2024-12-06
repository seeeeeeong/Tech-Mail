package techmail.domain.user.repository;

import techmail.domain.user.entity.User;
import techmail.domain.userquestion.entity.UserQuestion;
import techmail.global.repository.Querydsl5RepositorySupport;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static techmail.domain.user.entity.QUser.user;


public class UserQueryRepositoryImpl extends Querydsl5RepositorySupport implements UserQueryRepository {

    public UserQueryRepositoryImpl() {
        super(UserQuestion.class);
    }


    @Override
    public List<String> selectEmailList() {
        return select(user.email)
                .from(user)
                .where(user.deletedAt.isNull())
                .distinct()
                .fetch();
    }

    @Override
    public boolean isUserExists(String email) {
        return selectFrom(user)
                .where(user.email.eq(email), user.deletedAt.isNull())
                .fetchFirst() != null;
    }

    @Override
    public Optional<User> selectUser(String email, String token) {
        return Optional.ofNullable(
                selectFrom(user)
                        .where(user.email.eq(email), user.token.eq(token), user.deletedAt.isNull())
                        .fetchOne());
    }

    @Override
    public List<User> selectUserList(LocalDateTime baseDateTime) {
        return selectFrom(user)
                .where(user.createdAt.before(baseDateTime), user.deletedAt.isNull())
                .fetch();
    }
}
