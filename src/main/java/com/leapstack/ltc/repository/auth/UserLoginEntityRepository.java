package com.leapstack.ltc.repository.auth;

import com.leapstack.ltc.entity.auth.UserLoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
 * Created by zhuochen on 2017/7/17.
 */
@Repository
public interface UserLoginEntityRepository extends JpaRepository<UserLoginEntity, Integer>, QueryDslPredicateExecutor {
    UserLoginEntity findByUsername(String username);
}
