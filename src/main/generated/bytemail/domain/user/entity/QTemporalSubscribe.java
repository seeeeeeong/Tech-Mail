package bytemail.domain.user.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QTemporalSubscribe is a Querydsl query type for TemporalSubscribe
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTemporalSubscribe extends EntityPathBase<TempUser> {

    private static final long serialVersionUID = -1073911812L;

    public static final QTemporalSubscribe temporalSubscribe = new QTemporalSubscribe("temporalSubscribe");

    public final bytemail.global.entity.QBaseEntity _super = new bytemail.global.entity.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath email = createString("email");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath isVerified = createBoolean("isVerified");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final StringPath verificationCode = createString("verificationCode");

    public QTemporalSubscribe(String variable) {
        super(TempUser.class, forVariable(variable));
    }

    public QTemporalSubscribe(Path<? extends TempUser> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTemporalSubscribe(PathMetadata metadata) {
        super(TempUser.class, metadata);
    }

}

