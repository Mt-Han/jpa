package com.example.test.user.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = -125960312L;

    public static final QUser user = new QUser("user");

    public final com.example.test.common.QBaseEntity _super = new com.example.test.common.QBaseEntity(this);

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    //inherited
    public final DateTimePath<java.util.Date> createDt = _super.createDt;

    public final EnumPath<User.genderType> gender = createEnum("gender", User.genderType.class);

    public final NumberPath<Long> idx = createNumber("idx", Long.class);

    public final ListPath<com.example.test.item.model.Item, com.example.test.item.model.QItem> items = this.<com.example.test.item.model.Item, com.example.test.item.model.QItem>createList("items", com.example.test.item.model.Item.class, com.example.test.item.model.QItem.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final StringPath password = createString("password");

    //inherited
    public final DateTimePath<java.util.Date> updateDt = _super.updateDt;

    public final StringPath userId = createString("userId");

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

