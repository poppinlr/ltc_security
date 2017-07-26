package com.leapstack.ltc.service.auth;

import com.leapstack.ltc.entity.auth.*;
import com.leapstack.ltc.repository.auth.RoleEntityRepository;
import com.leapstack.ltc.repository.auth.UserLoginEntityRepository;
import com.leapstack.ltc.vo.web.PageResponse;
import com.leapstack.ltc.vo.web.ResponseMessage;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.hibernate.annotations.SQLUpdate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhuochen on 2017/7/19.
 */
@Service
public class UserManageService {

    @Autowired
    private UserLoginEntityRepository userLoginEntityRepository;

    @Autowired
    private RoleEntityRepository roleEntityRepository;

    @Autowired
    private CompanyManageService companyManageService;

    private static QUserLoginEntity qUserLoginEntity = QUserLoginEntity.userLoginEntity;

    public Page<UserLoginEntity> listUser(PageRequest pageRequest, Integer companyId, Integer roleId) {
        BooleanBuilder when = null;
        if(roleId == null){
            when = new BooleanBuilder(qUserLoginEntity.companyEntity.companyId.eq(companyId));
        }else{
            when = new BooleanBuilder(qUserLoginEntity.roleEntity.roleId.eq(roleId).and(qUserLoginEntity.companyEntity.companyId.eq(companyId)));
        }

        return userLoginEntityRepository.findAll(when, pageRequest);
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
//            entity.setCompanyId(userLoginEntity.getCompanyId());
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
