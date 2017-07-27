package com.leapstack.ltc.repository.auth;

import com.leapstack.ltc.entity.auth.AccessEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhuochen on 2017/7/13.
 */
@Repository
public interface AccessEntityRepository extends JpaRepository<AccessEntity, Integer>{
    List<AccessEntity> findByAccessIdIn(List<Integer> ids);

}
