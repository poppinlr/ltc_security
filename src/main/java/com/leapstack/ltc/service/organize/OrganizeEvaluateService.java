package com.leapstack.ltc.service.organize;

import com.leapstack.ltc.entity.auth.UserLoginEntity;
import com.leapstack.ltc.entity.organization.evaluate.OrganizeEvaluateEntity;
import com.leapstack.ltc.entity.organization.evaluate.QOrganizeEvaluateEntity;
import com.leapstack.ltc.repository.organize.OrganizeEvaluateEntityRepository;
import com.leapstack.ltc.util.LoginSecurityUtils;
import com.leapstack.ltc.vo.web.ResponseMessage;
import com.querydsl.core.BooleanBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class OrganizeEvaluateService {

    @Autowired
    private OrganizeEvaluateEntityRepository repository;

    private static QOrganizeEvaluateEntity qOrganizeEvaluateEntity = QOrganizeEvaluateEntity.organizeEvaluateEntity;

    public Page<OrganizeEvaluateEntity> listOrganize(PageRequest pageRequest) {
        UserLoginEntity userLoginEntity = LoginSecurityUtils.getUserLoginEntity();
        if (userLoginEntity.getCompanyEntity() != null) {
            BooleanBuilder when = new BooleanBuilder(qOrganizeEvaluateEntity.companyId.eq(userLoginEntity.getCompanyEntity().getCompanyId()));
            return repository.findAll(when, pageRequest);
        }
        return null;
    }

    public ResponseMessage createOrganize(OrganizeEvaluateEntity evaluateOrganizeEntity) {
        ResponseMessage responseMessage = new ResponseMessage();

        OrganizeEvaluateEntity entity = repository.findByOrgNumber(evaluateOrganizeEntity.getOrgNumber());
        if (entity == null) {
            repository.save(evaluateOrganizeEntity);
            responseMessage.setSuccess(true);
        } else {
            responseMessage.setMessage("机构存在");
        }

        return responseMessage;
    }


    public ResponseMessage updateOrganize(OrganizeEvaluateEntity evaluateOrganizeEntity) {
        ResponseMessage responseMessage = new ResponseMessage();

        OrganizeEvaluateEntity entity = repository.findOne(evaluateOrganizeEntity.getOrganizeId());
        if (entity == null) {
            responseMessage.setMessage("机构不存在");
        } else {
            repository.save(entity);
            responseMessage.setSuccess(true);
        }

        return responseMessage;
    }

    public ResponseMessage deleteOrganize(Integer organizeId) {
        ResponseMessage responseMessage = new ResponseMessage();

        OrganizeEvaluateEntity entity = repository.findOne(organizeId);
        if (entity == null) {
            responseMessage.setMessage("机构不存在");
        } else {
            entity.setActive(false);
            repository.save(entity);
            responseMessage.setSuccess(true);
        }

        return responseMessage;
    }
}
