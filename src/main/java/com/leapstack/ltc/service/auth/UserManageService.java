package com.leapstack.ltc.service.auth;

import com.leapstack.ltc.entity.auth.QUserLoginEntity;
import com.leapstack.ltc.entity.auth.UserLoginEntity;
import com.leapstack.ltc.repository.auth.CompanyEntityRepository;
import com.leapstack.ltc.repository.auth.RoleEntityRepository;
import com.leapstack.ltc.repository.auth.UserLoginEntityRepository;
import com.leapstack.ltc.vo.auth.UserLoginVO;
import com.leapstack.ltc.vo.web.ResponseMessage;
import com.querydsl.core.BooleanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

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
    private CompanyEntityRepository companyEntityRepository;

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


    public ResponseMessage createUser(UserLoginVO userLoginVO, Integer roleId) {
        ResponseMessage responseMessage = new ResponseMessage();

        if(userLoginVO != null){
            if(userLoginEntityRepository.findByUsername(userLoginVO.getUsername()) == null){
                UserLoginEntity userLoginEntity = new UserLoginEntity();
                userLoginEntity.setCompanyEntity(companyEntityRepository.findOne(userLoginVO.getCompanyId()));
                userLoginEntity.setUsername(userLoginVO.getUsername());
                userLoginEntity.setPassword(userLoginVO.getPassword());
                userLoginEntity.setName(userLoginVO.getName());
                userLoginEntity.setEmail(userLoginVO.getEmail());
                userLoginEntity.setRoleEntity(roleEntityRepository.findOne(roleId));
                userLoginEntityRepository.save(userLoginEntity);
                responseMessage.setSuccess(true);
            }else{
                responseMessage.setMessage("user name exist!");
            }
        }

        return responseMessage;

    }

    public ResponseMessage updateUser(UserLoginVO userLoginVO, Integer roleId) {
        ResponseMessage responseMessage = new ResponseMessage();

        UserLoginEntity entity = userLoginEntityRepository.findOne(userLoginVO.getUserId());
        if(entity == null){
            responseMessage.setMessage("user doesn't exist");
        }else{
            entity.setUsername(userLoginVO.getUsername());
            entity.setPassword(userLoginVO.getPassword());
            entity.setName(userLoginVO.getName());
            entity.setEmail(userLoginVO.getEmail());
            entity.setCompanyEntity(companyEntityRepository.findOne(userLoginVO.getCompanyId()));
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
