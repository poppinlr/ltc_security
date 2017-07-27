package com.leapstack.ltc.repository.auth;

import com.leapstack.ltc.entity.auth.AccessRoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by zhuochen on 2017/7/19.
 */
@Repository
public interface AccessRoleEntityRepository extends JpaRepository<AccessRoleEntity, Integer>{
}
