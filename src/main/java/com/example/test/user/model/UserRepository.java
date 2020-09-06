package com.example.test.user.model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> ,QuerydslPredicateExecutor<User>{

    User findByUserId(String userId);
    User findByUserIdAndName(String userId,String name);

}
