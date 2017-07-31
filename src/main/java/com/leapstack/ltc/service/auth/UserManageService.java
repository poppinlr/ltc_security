package com.leapstack.ltc.service.auth;

import com.leapstack.ltc.entity.auth.QUserLoginEntity;
import com.leapstack.ltc.entity.auth.UserLoginEntity;
import com.leapstack.ltc.repository.auth.CompanyEntityRepository;
import com.leapstack.ltc.repository.auth.RoleEntityRepository;
import com.leapstack.ltc.repository.auth.UserLoginEntityRepository;
import com.leapstack.ltc.vo.auth.UserLoginRequestVO;
import com.leapstack.ltc.vo.auth.UserLoginResponseVO;
import com.leapstack.ltc.vo.web.PageResponse;
import com.leapstack.ltc.vo.web.ResponseMessage;
import com.querydsl.core.BooleanBuilder;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by zhuochen on 2017/7/19.
 */
@Service
@Log4j
public class UserManageService {

    @Autowired
    private UserLoginEntityRepository userLoginEntityRepository;

    @Autowired
    private RoleEntityRepository roleEntityRepository;

    @Autowired
    private CompanyEntityRepository companyEntityRepository;

    private static QUserLoginEntity qUserLoginEntity = QUserLoginEntity.userLoginEntity;

    public UserLoginResponseVO getUserByUserId(Integer userId) {
        return new UserLoginResponseVO(userLoginEntityRepository.findOne(userId));
    }

    public PageResponse<UserLoginResponseVO> listUser(PageRequest pageRequest, Integer companyId, Integer roleId) {

        //get page data
        BooleanBuilder when;
        if (roleId == null) {
            when = new BooleanBuilder(qUserLoginEntity.companyEntity.companyId.eq(companyId));
        } else {
            when = new BooleanBuilder(qUserLoginEntity.roleEntity.roleId.eq(roleId).and(qUserLoginEntity.companyEntity.companyId.eq(companyId)));
        }
        Page<UserLoginEntity> page = userLoginEntityRepository.findAll(when, pageRequest);

        //do mapper
        if (page.getTotalElements() > 0) {
            ArrayList<UserLoginResponseVO> list = new ArrayList<>();
            for (UserLoginEntity entity : page.getContent()) {
                list.add(new UserLoginResponseVO(entity));
            }
            return new PageResponse<>(page, list);
        }

        return null;
    }


    public ResponseMessage createUser(UserLoginRequestVO requestVO) {
        ResponseMessage responseMessage = new ResponseMessage();

        UserLoginEntity userLoginEntity = new UserLoginEntity();
        userLoginEntity.setUsername(requestVO.getUsername());
        userLoginEntity.setPassword(requestVO.getPassword());
        userLoginEntity.setName(requestVO.getName());
        userLoginEntity.setEmail(requestVO.getEmail());
        userLoginEntity.setActive(requestVO.getActive());
        userLoginEntity.setCompanyId(requestVO.getCompanyId());
        userLoginEntity.setRoleId(requestVO.getRoleId());
        try {
            userLoginEntityRepository.save(userLoginEntity);
            responseMessage.setSuccess(true);
        } catch (Exception e) {
            responseMessage.setMessage("创建用户失败");
            log.error("create UserLoginEntity fail : ", e);
        }

        return responseMessage;

    }

    public ResponseMessage updateUser(UserLoginRequestVO userLoginVO) {
        ResponseMessage responseMessage = new ResponseMessage();

        UserLoginEntity entity = userLoginEntityRepository.findOne(userLoginVO.getUserId());
        if (entity == null) {
            responseMessage.setMessage("用户不存在");
        } else {
            entity.setUsername(userLoginVO.getUsername());
            entity.setPassword(userLoginVO.getPassword());
            entity.setName(userLoginVO.getName());
            entity.setEmail(userLoginVO.getEmail());
            entity.setActive(userLoginVO.getActive());
            entity.setCompanyId(userLoginVO.getCompanyId());
            entity.setRoleId(userLoginVO.getRoleId());
            try {
                userLoginEntityRepository.save(entity);
                responseMessage.setSuccess(true);
            } catch (Exception e) {
                responseMessage.setMessage("修改用户失败");
                log.error("update UserLoginEntity fail : ", e);
            }
        }

        return responseMessage;
    }

    public ResponseMessage deleteUser(Integer userId) {
        ResponseMessage responseMessage = new ResponseMessage();

        UserLoginEntity entity = userLoginEntityRepository.findOne(userId);
        if (entity == null) {
            responseMessage.setMessage("用户不存在");
        } else {
            entity.setActive(false);
            try {
                userLoginEntityRepository.save(entity);
                responseMessage.setSuccess(true);
            } catch (Exception e) {
                responseMessage.setMessage("删除用户失败");
                log.error("delete UserLoginEntity fail : ", e);
            }
        }

        return responseMessage;
    }

}
