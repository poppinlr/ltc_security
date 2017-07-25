package com.leapstack.ltc.service.auth;

import com.leapstack.ltc.entity.auth.*;
import com.leapstack.ltc.repository.auth.RoleEntityRepository;
import com.leapstack.ltc.repository.auth.UserLoginEntityRepository;
import com.leapstack.ltc.vo.web.ResponseMessage;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.hibernate.annotations.SQLUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuochen on 2017/7/19.
 */
@Service
public class UserManageService {

    @Autowired
    private JPAQueryFactory queryFactory;

    @Autowired
    private UserLoginEntityRepository userLoginEntityRepository;

    @Autowired
    private RoleEntityRepository roleEntityRepository;

    private static QUserLoginEntity qUserLoginEntity = QUserLoginEntity.userLoginEntity;
    private static QRoleEntity qRoleEntity = QRoleEntity.roleEntity;

    public List<UserLoginEntity> listUser() {
        //TODO call adapter to get companyIds
        List<Integer> companyIds = new ArrayList<>();
        return queryFactory.selectFrom(qUserLoginEntity).join(qRoleEntity)
                .on(qUserLoginEntity.roleEntity.roleId.eq(qRoleEntity.roleId)
                        .and(qRoleEntity.companyEntity.companyId.in(companyIds))).fetch();
    }


    public ResponseMessage createUser(UserLoginEntity userLoginEntity, Integer roleId) {
        ResponseMessage responseMessage = new ResponseMessage();

        if(userLoginEntity != null){
            if(userLoginEntityRepository.findByUsername(userLoginEntity.getUsername()) == null){

                userLoginEntity.setRoleEntity(roleEntityRepository.findOne(roleId));
                userLoginEntityRepository.save(userLoginEntity);
                responseMessage.setSuccess(true);
            }else{
                responseMessage.setMessage("user name exist!");
            }
        }

        return responseMessage;

    }

    public ResponseMessage updateUser(UserLoginEntity userLoginEntity, Integer roleId) {
        ResponseMessage responseMessage = new ResponseMessage();

        UserLoginEntity entity = userLoginEntityRepository.findOne(userLoginEntity.getUserId());
        if(entity == null){
            responseMessage.setMessage("user doesn't exist");
        }else{
            entity.setUsername(userLoginEntity.getUsername());
            entity.setPassword(userLoginEntity.getPassword());
            entity.setActive(userLoginEntity.getActive());
            entity.setCompanyId(userLoginEntity.getCompanyId());
            entity.setRoleEntity(roleEntityRepository.findOne(roleId));
            userLoginEntityRepository.save(entity);
            responseMessage.setSuccess(true);
        }

        return responseMessage;
    }

    public ResponseMessage deleteUser(Integer userId) {
        ResponseMessage responseMessage = new ResponseMessage();

        UserLoginEntity entity = userLoginEntityRepository.findOne(userId);
        if(entity == null){
            responseMessage.setMessage("user doesn't exist");
        }else{
            entity.setActive(false);
            userLoginEntityRepository.save(entity);
            responseMessage.setSuccess(true);
        }

        return responseMessage;
    }
}
