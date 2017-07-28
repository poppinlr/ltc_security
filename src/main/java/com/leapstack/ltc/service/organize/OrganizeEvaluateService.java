package com.leapstack.ltc.service.organize;

import com.leapstack.ltc.entity.auth.UserLoginEntity;
import com.leapstack.ltc.entity.organization.evaluate.OrganizeEvaluateEntity;
import com.leapstack.ltc.entity.organization.evaluate.QOrganizeEvaluateEntity;
import com.leapstack.ltc.repository.organize.OrganizeEvaluateEntityRepository;
import com.leapstack.ltc.util.UtilService;
import com.leapstack.ltc.vo.organization.evaluate.OrganizeEvaluateFilter;
import com.leapstack.ltc.vo.organization.evaluate.OrganizeEvaluateRequest;
import com.leapstack.ltc.vo.organization.evaluate.OrganizeEvaluateResponse;
import com.leapstack.ltc.vo.web.PageResponse;
import com.leapstack.ltc.vo.web.ResponseMessage;
import com.querydsl.core.BooleanBuilder;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Log4j
public class OrganizeEvaluateService {

    @Autowired
    private OrganizeEvaluateEntityRepository repository;

    private static QOrganizeEvaluateEntity qOrganize = QOrganizeEvaluateEntity.organizeEvaluateEntity;

    public PageResponse<OrganizeEvaluateResponse> listOrganize(PageRequest pageRequest, OrganizeEvaluateFilter filter) {
        UserLoginEntity userLoginEntity = UtilService.getUserLoginEntity();

        if (userLoginEntity.getCompanyEntity() != null) {
            BooleanBuilder when = new BooleanBuilder(qOrganize.companyId.eq(userLoginEntity.getCompanyEntity().getCompanyId()));

            //add filter query
            if (filter.getAddress() != null) {
                when.and(qOrganize.orgAddress.like(filter.getAddress()));
            }

            if (filter.getOrgName() != null) {
                when.and(qOrganize.orgName.like(filter.getOrgName()));
            }

            if (filter.getOrgNumber() != null) {
                when.and(qOrganize.orgNumber.like(filter.getOrgNumber()));
            }

            if (filter.getSort() != null) {
                pageRequest = UtilService.getPageRequestWithSorting(pageRequest, filter);
            }

            Page<OrganizeEvaluateEntity> page = repository.findAll(when, pageRequest);
            List<OrganizeEvaluateResponse> list = new ArrayList<>();
            for (OrganizeEvaluateEntity entity : page.getContent()) {
                list.add(new OrganizeEvaluateResponse(entity));
            }

            return new PageResponse<>(page, list);
        }

        return null;
    }

    public ResponseMessage createOrganize(OrganizeEvaluateRequest request) {
        ResponseMessage responseMessage = new ResponseMessage();
        OrganizeEvaluateEntity entity = new OrganizeEvaluateEntity();

        //copy properties from request to entity
        BeanUtils.copyProperties(entity, request);

        //set companyId by login user
        UserLoginEntity userLoginEntity = UtilService.getUserLoginEntity();
        entity.setCompanyId(userLoginEntity.getCompanyEntity().getCompanyId());

        //save
        if (repository.findByOrgNumber(request.getOrgNumber()) == null) {
            repository.save(entity);
            responseMessage.setSuccess(true);
        } else {
            responseMessage.setMessage("机构存在");
        }

        return responseMessage;
    }


    public ResponseMessage updateOrganize(OrganizeEvaluateRequest request) {
        ResponseMessage responseMessage = new ResponseMessage();

        OrganizeEvaluateEntity entity = repository.findOne(request.getOrganizeId());
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
