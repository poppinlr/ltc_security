package com.leapstack.ltc.service.auth;

import com.leapstack.ltc.entity.auth.RoleEntity;
import com.leapstack.ltc.repository.auth.AccessEntityRepository;
import com.leapstack.ltc.repository.auth.RoleEntityRepository;
import com.leapstack.ltc.vo.web.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by zhuochen on 2017/7/19.
 */
@Service
public class RoleManageService {

    @Autowired
    private RoleEntityRepository roleEntityRepository;

    @Autowired
    private AccessEntityRepository accessEntityRepository;

    @Transactional
    public ResponseMessage createRole(RoleEntity roleEntity, List<Integer> accessIds) {
        ResponseMessage responseMessage = new ResponseMessage();

        if(roleEntityRepository.findByRoleName(roleEntity.getRoleName()) == null){
            roleEntity.setAccessEntities(accessEntityRepository.findByAccessIdIn(accessIds));
            roleEntityRepository.save(roleEntity);
            responseMessage.setSuccess(true);
        }else{
            responseMessage.setMessage("role name exist");
        }

        return responseMessage;
    }

    public ResponseMessage updateRole(RoleEntity roleEntity, List<Integer> accessIds) {
        ResponseMessage responseMessage = new ResponseMessage();

        RoleEntity entity = roleEntityRepository.findOne(roleEntity.getRoleId());
        if(entity == null){
            responseMessage.setMessage("role don't exist");
        }else{
            entity.setRoleName(roleEntity.getRoleName());
            entity.setActive(roleEntity.getActive());
            entity.setComment(roleEntity.getComment());
            entity.setCompanyEntity(roleEntity.getCompanyEntity());
            entity.setAccessEntities(accessEntityRepository.findByAccessIdIn(accessIds));
            roleEntityRepository.save(entity);
            responseMessage.setSuccess(true);
        }

        return responseMessage;
    }

    public ResponseMessage deleteRole(Integer roleId) {
        ResponseMessage responseMessage = new ResponseMessage();

        RoleEntity roleEntity = roleEntityRepository.findOne(roleId);
        if(roleEntity == null){
            responseMessage.setMessage("role don't exist");
        }else{
            roleEntity.setActive(false);
            roleEntityRepository.save(roleEntity);
            responseMessage.setSuccess(true);
        }

        return responseMessage;
    }
}
