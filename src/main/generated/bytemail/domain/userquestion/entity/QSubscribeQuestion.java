package bytemail.domain.userquestion.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSubscribeQuestion is a Querydsl query type for SubscribeQuestion
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSubscribeQuestion extends EntityPathBase<UserQuestion> {

    private static final long serialVersionUID = -16002850L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSubscribeQuestion subscribeQuestion = new QSubscribeQuestion("subscribeQuestion");

    public final bytemail.global.entity.QBaseEntity _super = new bytemail.global.entity.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath isSuccess = createBoolean("isSuccess");

    public final bytemail.domain.question.entity.QQuestion question;

    public final bytemail.domain.user.entity.QSubscribe subscribe;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QSubscribeQuestion(String variable) {
        this(UserQuestion.class, forVariable(variable), INITS);
    }

    public QSubscribeQuestion(Path<? extends UserQuestion> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSubscribeQuestion(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSubscribeQuestion(PathMetadata metadata, PathInits inits) {
        this(UserQuestion.class, metadata, inits);
    }

    public QSubscribeQuestion(Class<? extends UserQuestion> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.question = inits.isInitialized("question") ? new bytemail.domain.question.entity.QQuestion(forProperty("question")) : null;
        this.subscribe = inits.isInitialized("subscribe") ? new bytemail.domain.user.entity.QSubscribe(forProperty("subscribe")) : null;
    }

}

