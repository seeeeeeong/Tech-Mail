package bytemail.domain.subscribe.repository;

import bytemail.domain.subscribe.entity.Subscribe;
import bytemail.global.repository.Querydsl5RepositorySupport;

import java.util.List;

import static bytemail.domain.subscribe.entity.QSubscribe.subscribe;

public class SubscribeQueryRepositoryImpl extends Querydsl5RepositorySupport implements SubscribeQueryRepository {

    public SubscribeQueryRepositoryImpl() {
        super(Subscribe.class);
    }


    @Override
    public List<String> findEmails() {
        return select(subscribe.email)
                .from(subscribe)
                .where(subscribe.deletedAt.isNull())
                .distinct()
                .fetch();
    }
}
