package com.leapstack.ltc.service.auth;

import com.leapstack.ltc.entity.auth.QRoleEntity;
import com.leapstack.ltc.entity.auth.QUserLoginEntity;
import com.leapstack.ltc.entity.auth.UserLoginEntity;
import com.leapstack.ltc.vo.web.LoginInfo;
import com.leapstack.ltc.vo.web.LoginResponseMessage;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.log4j.Log4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zhuochen on 2017/7/17.
 */
@Service
@Log4j
public class AuthService {

    @Autowired
    private JPAQueryFactory queryFactory;

    private static QUserLoginEntity qUserLoginEntity = QUserLoginEntity.userLoginEntity;
    private static QRoleEntity qRoleEntity = QRoleEntity.roleEntity;

    public LoginResponseMessage login(LoginInfo loginInfo) {
        LoginResponseMessage responseMessage = new LoginResponseMessage();

        if(loginInfo != null){
            UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(loginInfo.getUsername(),loginInfo.getPassword());
            Subject subject = SecurityUtils.getSubject();

            try{
                subject.login(usernamePasswordToken);

                UserLoginEntity userLoginEntity = (UserLoginEntity)subject.getPrincipal();
                responseMessage.setRoleId(userLoginEntity.getRoleEntity().getRoleId());
                responseMessage.setUserId(userLoginEntity.getUserId());
                responseMessage.setUsername(userLoginEntity.getUsername());
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
}
