package com.leapstack.ltc.service.organize;

import com.leapstack.ltc.entity.auth.UserLoginEntity;
import com.leapstack.ltc.entity.organization.evaluate.OrganizeEvaluateExpertEntity;
import com.leapstack.ltc.entity.organization.evaluate.QOrganizeEvaluateEntity;
import com.leapstack.ltc.entity.organization.evaluate.QOrganizeEvaluateExpertEntity;
import com.leapstack.ltc.repository.organize.OrganizeEvaluateExpertEntityRepository;
import com.leapstack.ltc.util.UtilService;
import com.leapstack.ltc.vo.organization.evaluate.OrganizeEvaluateExpertFilter;
import com.leapstack.ltc.vo.organization.evaluate.OrganizeEvaluateExpertRequest;
import com.leapstack.ltc.vo.organization.evaluate.OrganizeEvaluateExpertResponse;
import com.leapstack.ltc.vo.web.PageResponse;
import com.leapstack.ltc.vo.web.ResponseMessage;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrganizeEvaluateExpertService {

    @Autowired
    private OrganizeEvaluateExpertEntityRepository repository;

    @Autowired
    private JPAQueryFactory queryFactory;

    private static QOrganizeEvaluateExpertEntity qExpert = QOrganizeEvaluateExpertEntity.organizeEvaluateExpertEntity;
    private static QOrganizeEvaluateEntity qOrganize = QOrganizeEvaluateEntity.organizeEvaluateEntity;

    public PageResponse<OrganizeEvaluateExpertResponse> listOrganize(PageRequest pageRequest, OrganizeEvaluateExpertFilter filter) {
        UserLoginEntity userLoginEntity = UtilService.getUserLoginEntity();

        if (userLoginEntity.getCompanyEntity() == null) {
            List<Integer> organizeIds = queryFactory.select(qOrganize.organizeId).from(qOrganize).where(qOrganize.companyId.eq(userLoginEntity.getCompanyEntity().getCompanyId())).fetch();
            BooleanBuilder when = new BooleanBuilder(qExpert.evaluateOrganizeId.in(organizeIds));

            if (filter.getName() != null) {
                when.and(qExpert.name.eq(filter.getName()));
            }

            if (filter.getIdNumber() != null) {
                when.and(qExpert.idNumber.eq(filter.getIdNumber()));
            }

            if (filter.getType() != null) {
                when.and(qExpert.type.eq(filter.getType()));
            }

            if (filter.getEvaluateOrganizeId() != null) {
                when.and(qExpert.evaluateOrganizeId.eq(filter.getEvaluateOrganizeId()));
            }

            if (filter.getEmployeeNumber() != null) {
                when.and(qExpert.employeeNumber.eq(filter.getEmployeeNumber()));
            }

            if (filter.getSort() != null) {
                pageRequest = UtilService.getPageRequestWithSorting(pageRequest, filter);
            }

            Page<OrganizeEvaluateExpertEntity> page = repository.findAll(when, pageRequest);
            List<OrganizeEvaluateExpertResponse> list = new ArrayList<>();
            for (OrganizeEvaluateExpertEntity entity : page.getContent()) {
                list.add(new OrganizeEvaluateExpertResponse(entity));
            }
            return new PageResponse<>(page, list);
        }

        return null;
    }

    public ResponseMessage createOrganize(OrganizeEvaluateExpertRequest request) {
        ResponseMessage responseMessage = new ResponseMessage();

        OrganizeEvaluateExpertEntity entity = repository.findByIdNumber(request.getIdNumber());
        if (entity == null) {
            entity = new OrganizeEvaluateExpertEntity();
            BeanUtils.copyProperties(entity, request);
            repository.save(entity);
            responseMessage.setSuccess(true);
        } else {
            responseMessage.setMessage("身份证已注册");
        }

        return responseMessage;
    }


    public ResponseMessage updateOrganize(OrganizeEvaluateExpertRequest request) {
        ResponseMessage responseMessage = new ResponseMessage();

        OrganizeEvaluateExpertEntity entity = repository.findOne(request.getOrganizeExpertId());
        if (entity == null) {
            responseMessage.setMessage("身份证不存在");
        } else {
            BeanUtils.copyProperties(entity, request);
            repository.save(entity);
            responseMessage.setSuccess(true);
        }

        return responseMessage;
    }

    public ResponseMessage deleteOrganize(Integer expertId) {
        ResponseMessage responseMessage = new ResponseMessage();

        OrganizeEvaluateExpertEntity entity = repository.findOne(expertId);
        if (entity == null) {
            responseMessage.setMessage("身份证不存在");
        } else {
            entity.setActive(false);
            repository.save(entity);
            responseMessage.setSuccess(true);
        }

        return responseMessage;
    }
}
