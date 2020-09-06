package com.example.test.user.model.predicate;

import com.example.test.user.model.QUser;
import com.example.test.user.model.req.UserRequest;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.util.ObjectUtils;

public class UserPredicate {
    public static Predicate search(UserRequest request){
        BooleanBuilder builder = new BooleanBuilder();
        builder.and(ageSearch(request.getAge()));
        return builder;
    }
    public static Predicate ageSearch(int age){
        BooleanBuilder builder = new BooleanBuilder();
        QUser user = QUser.user;
        if (!ObjectUtils.isEmpty(age))
            builder.and(user.age.eq(age));
        return builder;
    }
}
