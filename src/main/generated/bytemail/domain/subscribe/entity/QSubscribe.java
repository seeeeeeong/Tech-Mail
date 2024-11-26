package bytemail.domain.subscribe.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QSubscribe is a Querydsl query type for Subscribe
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QSubscribe extends EntityPathBase<Subscribe> {

    private static final long serialVersionUID = -1372340994L;

    public static final QSubscribe subscribe = new QSubscribe("subscribe");

    public final bytemail.global.entity.QBaseEntity _super = new bytemail.global.entity.QBaseEntity(this);

    public final EnumPath<bytemail.domain.question.enums.QuestionCategory> category = createEnum("category", bytemail.domain.question.enums.QuestionCategory.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final DateTimePath<java.time.LocalDateTime> deletedAt = createDateTime("deletedAt", java.time.LocalDateTime.class);

    public final StringPath email = createString("email");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> nextQuestionSequence = createNumber("nextQuestionSequence", Long.class);

    public final StringPath token = createString("token");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QSubscribe(String variable) {
        super(Subscribe.class, forVariable(variable));
    }

    public QSubscribe(Path<? extends Subscribe> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSubscribe(PathMetadata metadata) {
        super(Subscribe.class, metadata);
    }

}

