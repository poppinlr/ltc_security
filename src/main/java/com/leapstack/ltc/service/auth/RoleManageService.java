package com.leapstack.ltc.service.auth;

import com.leapstack.ltc.entity.auth.RoleEntity;
import com.leapstack.ltc.repository.auth.AccessEntityRepository;
import com.leapstack.ltc.repository.auth.CompanyEntityRepository;
import com.leapstack.ltc.repository.auth.RoleEntityRepository;
import com.leapstack.ltc.vo.auth.RoleRequestVO;
import com.leapstack.ltc.vo.web.ResponseMessage;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by zhuochen on 2017/7/19.
 */
@Service
@Log4j
public class RoleManageService {

    @Autowired
    private RoleEntityRepository roleEntityRepository;

    @Autowired
    private AccessEntityRepository accessEntityRepository;

    @Autowired
    private CompanyEntityRepository companyEntityRepository;

    @Transactional
    public ResponseMessage createRole(RoleRequestVO requestVO) {
        ResponseMessage responseMessage = new ResponseMessage();

        RoleEntity entity = new RoleEntity();
        entity.setRoleName(requestVO.getRoleName());
        entity.setComment(requestVO.getComment());
        entity.setActive(requestVO.getActive());
        entity.setCompanyEntity(companyEntityRepository.findOne(requestVO.getCompanyId()));
        entity.setAccessEntities(accessEntityRepository.findByAccessIdIn(requestVO.getAccessIds()));
        try {
            roleEntityRepository.save(entity);
            responseMessage.setSuccess(true);
        } catch (Exception e) {
            responseMessage.setMessage("创建角色失败!");
            log.error("create RoleEntity fail : ", e);
        }

        return responseMessage;
    }

    public ResponseMessage updateRole(RoleRequestVO requestVO) {
        ResponseMessage responseMessage = new ResponseMessage();

        RoleEntity entity = roleEntityRepository.findOne(requestVO.getRoleId());
        if (entity == null) {
            responseMessage.setMessage("role don't exist");
        } else {
            entity.setRoleName(requestVO.getRoleName());
            entity.setActive(requestVO.getActive());
            entity.setComment(requestVO.getComment());
            entity.setCompanyEntity(companyEntityRepository.findOne(requestVO.getCompanyId()));
            entity.setAccessEntities(accessEntityRepository.findByAccessIdIn(requestVO.getAccessIds()));
            try {
                roleEntityRepository.save(entity);
                responseMessage.setSuccess(true);
            } catch (Exception e) {
                responseMessage.setMessage("修改角色失败!");
                log.error("update RoleEntity fail : ", e);
            }
        }

        return responseMessage;
    }

    public ResponseMessage deleteRole(Integer roleId) {
        ResponseMessage responseMessage = new ResponseMessage();

        RoleEntity roleEntity = roleEntityRepository.findOne(roleId);
        if (roleEntity == null) {
            responseMessage.setMessage("角色不存在");
        } else {
            roleEntity.setActive(false);
            try {
                roleEntityRepository.save(roleEntity);
                responseMessage.setSuccess(true);
            } catch (Exception e) {
                responseMessage.setMessage("删除角色失败!");
                log.error("delete RoleEntity fail : ", e);
            }
        }

        return responseMessage;
    }
}
