package bytemail.domain.user.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QTempUser is a Querydsl query type for TempUser
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTempUser extends EntityPathBase<TempUser> {

    private static final long serialVersionUID = 319204258L;

    public static final QTempUser tempUser = new QTempUser("tempUser");

    public final bytemail.global.entity.QBaseEntity _super = new bytemail.global.entity.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath email = createString("email");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath isVerified = createBoolean("isVerified");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final StringPath verifyCode = createString("verifyCode");

    public QTempUser(String variable) {
        super(TempUser.class, forVariable(variable));
    }

    public QTempUser(Path<? extends TempUser> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTempUser(PathMetadata metadata) {
        super(TempUser.class, metadata);
    }

}

