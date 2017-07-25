package com.leapstack.ltc.service.auth;

import com.leapstack.ltc.entity.auth.*;
import com.leapstack.ltc.vo.auth.MenuVO;
import com.leapstack.ltc.vo.web.LoginInfo;
import com.leapstack.ltc.vo.web.ResponseMessage;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.log4j.Log4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuochen on 2017/7/17.
 */
@Service
@Log4j
public class AuthService {

    @Autowired
    private JPAQueryFactory queryFactory;

    private static QMenuEntity qMenuEntity = QMenuEntity.menuEntity;
    private static QAccessEntity qAccessEntity = QAccessEntity.accessEntity;
    private static QAccessRoleEntity qAccessRoleEntity = QAccessRoleEntity.accessRoleEntity;
    private static QUserLoginEntity qUserLoginEntity = QUserLoginEntity.userLoginEntity;
    private static QRoleEntity qRoleEntity = QRoleEntity.roleEntity;


    public ResponseMessage login(LoginInfo loginInfo) {
        ResponseMessage responseMessage = new ResponseMessage();

        if(loginInfo != null){
            UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(loginInfo.getUsername(),loginInfo.getPassword());
            Subject subject = SecurityUtils.getSubject();

            try{
                subject.login(usernamePasswordToken);
                responseMessage.setSuccess(true);
            }catch (Exception e){
                responseMessage.setMessage("login fail");
                log.error("login error for username: " + loginInfo.getUsername(), e);
            }
        }
        return responseMessage;
    }

    public List<String> getRoleNamesByUserId(Integer userId) {
        return queryFactory.select(qRoleEntity.roleName)
                .from(qUserLoginEntity, qRoleEntity)
                .where(qUserLoginEntity.roleEntity.roleId.eq(qRoleEntity.roleId)
                        .and(qUserLoginEntity.userId.eq(userId))).fetch();
    }

    public List<MenuVO> getMenuWithAccessList(){
        List<MenuEntity> menuEntities = new ArrayList<>();

        Subject subject = SecurityUtils.getSubject();
        if(subject.getPrincipal() != null){
            UserLoginEntity userLoginEntity = (UserLoginEntity)subject.getPrincipal();
            menuEntities =  queryFactory.selectFrom(qMenuEntity)
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
        List<MenuVO> responseList = new ArrayList<>();
        for(MenuEntity entity : menuEntities){
            responseList.add(EntityMapperToVO.MenuVOMapper(entity));
        }
        return responseList;
    }
}
