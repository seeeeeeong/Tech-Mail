package techmail.domain.user.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = -481335506L;

    public static final QUser user = new QUser("user");

    public final techmail.global.entity.QBaseEntity _super = new techmail.global.entity.QBaseEntity(this);

    public final EnumPath<techmail.domain.question.entity.QuestionCategory> category = createEnum("category", techmail.domain.question.entity.QuestionCategory.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final DateTimePath<java.time.LocalDateTime> deletedAt = createDateTime("deletedAt", java.time.LocalDateTime.class);

    public final StringPath email = createString("email");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath token = createString("token");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final ListPath<techmail.domain.userquestion.entity.UserQuestion, techmail.domain.userquestion.entity.QUserQuestion> userQuestions = this.<techmail.domain.userquestion.entity.UserQuestion, techmail.domain.userquestion.entity.QUserQuestion>createList("userQuestions", techmail.domain.userquestion.entity.UserQuestion.class, techmail.domain.userquestion.entity.QUserQuestion.class, PathInits.DIRECT2);

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

