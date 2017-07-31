package com.leapstack.ltc.repository.auth;

import com.leapstack.ltc.entity.auth.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by zhuochen on 2017/7/12.
 */
@Repository
public interface MenuEntityRepository extends JpaRepository<MenuEntity, Integer> {
}
