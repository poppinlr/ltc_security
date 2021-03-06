package com.leapstack.ltc.repository.auth;

import com.leapstack.ltc.entity.auth.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

/**
 * Created by zhuochen on 2017/7/13.
 */
@Repository
public interface RoleEntityRepository extends JpaRepository<RoleEntity, Integer>, QueryDslPredicateExecutor {
}
