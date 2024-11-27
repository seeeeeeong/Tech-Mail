package bytemail.domain.userquestion.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserQuestion is a Querydsl query type for UserQuestion
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserQuestion extends EntityPathBase<UserQuestion> {

    private static final long serialVersionUID = 1034936346L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserQuestion userQuestion = new QUserQuestion("userQuestion");

    public final bytemail.global.entity.QBaseEntity _super = new bytemail.global.entity.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath isSuccess = createBoolean("isSuccess");

    public final bytemail.domain.question.entity.QQuestion question;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final bytemail.domain.user.entity.QUser user;

    public QUserQuestion(String variable) {
        this(UserQuestion.class, forVariable(variable), INITS);
    }

    public QUserQuestion(Path<? extends UserQuestion> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserQuestion(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserQuestion(PathMetadata metadata, PathInits inits) {
        this(UserQuestion.class, metadata, inits);
    }

    public QUserQuestion(Class<? extends UserQuestion> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.question = inits.isInitialized("question") ? new bytemail.domain.question.entity.QQuestion(forProperty("question")) : null;
        this.user = inits.isInitialized("user") ? new bytemail.domain.user.entity.QUser(forProperty("user")) : null;
    }

}

