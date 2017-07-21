package com.leapstack.ltc.repository.auth;

import com.leapstack.ltc.entity.auth.AccessEntity;
import com.leapstack.ltc.entity.auth.MenuEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuochen on 2017/7/12.
 */
@Repository
public interface MenuEntityRepository extends JpaRepository<MenuEntity,Integer>{

//    List<MenuEntity> findByMenuIdIn(List<Long> menuId);

//    List<MenuEntity> findByMenuEntityIn(List<MenuEntity> menuEntities);

    List<MenuEntity> findByMenuIdIn(List<Integer> menuIds);

    @Query(value =
            "select distinct(menu_id) " +
                "from access where access.access_id in(" +
                    "select access_id " +
                        "from access_role a, user_login u " +
                        "where a.role_id = u.role_id and u.user_id = :userId);", nativeQuery = true)
    List<Integer> getMenuIdsByUserId(@Param("userId") Integer userId);
}
