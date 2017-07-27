package com.leapstack.ltc.service.auth;

import com.leapstack.ltc.entity.auth.*;
import com.leapstack.ltc.vo.auth.MenuResponseVO;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuService {

    @Autowired
    private JPAQueryFactory queryFactory;

    private static QMenuEntity qMenuEntity = QMenuEntity.menuEntity;
    private static QAccessEntity qAccessEntity = QAccessEntity.accessEntity;
    private static QAccessRoleEntity qAccessRoleEntity = QAccessRoleEntity.accessRoleEntity;
    private static QUserLoginEntity qUserLoginEntity = QUserLoginEntity.userLoginEntity;

    public List<MenuResponseVO> getMenuWithAccessList() {
        List<MenuEntity> menuEntities = new ArrayList<>();

        Subject subject = SecurityUtils.getSubject();
        if (subject.getPrincipal() != null) {
            UserLoginEntity userLoginEntity = (UserLoginEntity) subject.getPrincipal();
            menuEntities = queryFactory.selectFrom(qMenuEntity)
                    .where(qMenuEntity.menuId.in(
                            queryFactory.selectDistinct(qAccessEntity.menuEntity.menuId)
                                    .from(qAccessEntity)
                                    .where(qAccessEntity.accessId.in(
                                            queryFactory.select(qAccessRoleEntity.accessId)
                                                    .from(qAccessRoleEntity, qUserLoginEntity)
                                                    .where(qAccessRoleEntity.roleId.eq(qUserLoginEntity.roleEntity.roleId)
                                                            .and(qUserLoginEntity.userId.eq(userLoginEntity.getUserId())))))
                    )).fetch();
        }

        //do mapper
        List<MenuResponseVO> responseList = new ArrayList<>();
        for (MenuEntity entity : menuEntities) {
            responseList.add(new MenuResponseVO(entity));
        }
        return responseList;
    }
}
