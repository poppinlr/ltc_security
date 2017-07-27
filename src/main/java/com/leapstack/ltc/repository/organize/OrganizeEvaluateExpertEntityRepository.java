package com.leapstack.ltc.repository.organize;

import com.leapstack.ltc.entity.organization.evaluate.OrganizeEvaluateEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganizeEvaluateExpertEntityRepository extends JpaRepository<OrganizeEvaluateEntity, Integer>, QueryDslPredicateExecutor {
}
