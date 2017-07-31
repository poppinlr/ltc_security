package com.leapstack.ltc.service.auth;

import com.google.common.collect.Lists;
import com.leapstack.ltc.entity.auth.CompanyEntity;
import com.leapstack.ltc.entity.auth.UserLoginEntity;
import com.leapstack.ltc.repository.auth.CompanyEntityRepository;
import com.leapstack.ltc.vo.auth.CompanyRequestVO;
import com.leapstack.ltc.vo.auth.CompanyResponseVO;
import com.leapstack.ltc.vo.web.ResponseMessage;
import lombok.extern.log4j.Log4j;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j
public class CompanyManageService {

    @Autowired
    private CompanyEntityRepository companyEntityRepository;

//    public List<CompanyResponseVO> getPureCompanyVOList() {
//
//    }

    public List<CompanyResponseVO> getCompanyVOList() {
        //get company entity list
        UserLoginEntity userLoginEntity = (UserLoginEntity) SecurityUtils.getSubject().getPrincipal();
        ArrayList<CompanyEntity> companyEntities = new ArrayList<>();
        CompanyEntity userCompany = companyEntityRepository.findOne(userLoginEntity.getCompanyEntity().getCompanyId());
        if (userCompany != null) {
            getCompany(companyEntities, Lists.newArrayList(userCompany));
        }

        //do mapper
        ArrayList<CompanyResponseVO> companyVOArrayList = new ArrayList<>();
        for (CompanyEntity entity : companyEntities) {
            companyVOArrayList.add(new CompanyResponseVO(entity));
        }

        return companyVOArrayList;
    }

    private void getCompany(List<CompanyEntity> list, List<CompanyEntity> companyEntities) {
        for (CompanyEntity entity : companyEntities) {
            list.add(entity);
            List<CompanyEntity> entities = companyEntityRepository.findByParentId(entity.getCompanyId());
            if (entities != null) {
                getCompany(list, entities);
            }
        }

    }

    public ResponseMessage saveCompany(CompanyRequestVO companyVO) {
        ResponseMessage responseMessage = new ResponseMessage();

        CompanyEntity companyEntity = new CompanyEntity();
        companyEntity.setCompanyName(companyVO.getCompanyName());
        companyEntity.setLevel(companyVO.getLevel());
        companyEntity.setParentId(companyVO.getParentId());

        try {
            companyEntityRepository.save(companyEntity);
            responseMessage.setSuccess(true);
        } catch (Exception e) {
            log.error("create company : " + companyEntity + " error: ", e);
            responseMessage.setMessage("创建公司失败");
        }

        return responseMessage;
    }

    public ResponseMessage updateCompany(CompanyRequestVO companyVO) {
        ResponseMessage responseMessage = new ResponseMessage();

        CompanyEntity companyEntity = companyEntityRepository.findOne(companyVO.getCompanyId());
        if (companyEntity == null) {
            responseMessage.setMessage("公司不存在");
        } else {
            companyEntity.setCompanyName(companyVO.getCompanyName());
            companyEntity.setParentId(companyVO.getParentId());
            companyEntity.setLevel(companyVO.getLevel());
            try {
                companyEntityRepository.save(companyEntity);
                responseMessage.setSuccess(true);
            } catch (Exception e) {
                log.error("update company : " + companyEntity + " error: ", e);
                responseMessage.setMessage("修改公司失败");
            }
        }

        return responseMessage;
    }

    public ResponseMessage deleteCompany(Integer companyId) {
        ResponseMessage responseMessage = new ResponseMessage();

        CompanyEntity companyEntity = companyEntityRepository.findOne(companyId);
        if (companyEntity == null) {
            responseMessage.setMessage("公司不存在");
        } else {
            companyEntity.setActive(false);
            try {
                companyEntityRepository.save(companyEntity);
                responseMessage.setSuccess(true);
            } catch (Exception e) {
                log.error("delete company : " + companyEntity + " error: ", e);
                responseMessage.setMessage("删除公司失败");
            }
        }

        return responseMessage;
    }

}
