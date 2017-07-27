package com.leapstack.ltc.service.organize;

import com.leapstack.ltc.entity.organization.evaluate.OrganizeEvaluateExpertEntity;
import com.leapstack.ltc.entity.organization.evaluate.QOrganizeEvaluateExpertEntity;
import com.leapstack.ltc.repository.organize.OrganizeEvaluateExpertEntityRepository;
import com.leapstack.ltc.vo.web.PageResponse;
import com.leapstack.ltc.vo.web.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class OrganizeEvaluateExpertService {

    @Autowired
    private OrganizeEvaluateExpertEntityRepository repository;

    private static QOrganizeEvaluateExpertEntity qOrganizeEvaluateExpertEntity = QOrganizeEvaluateExpertEntity.organizeEvaluateExpertEntity;

    public PageResponse<OrganizeEvaluateExpertEntity> listOrganize(PageRequest pageRequest) {

        return null;
    }

    public ResponseMessage createOrganize(OrganizeEvaluateExpertEntity evaluateOrganizeEntity) {
        ResponseMessage responseMessage = new ResponseMessage();

//        OrganizeEvaluateEntity entity = repository.findByOrgNumber(evaluateOrganizeEntity.getOrgNumber());
//        if(entity == null){
//            repository.save(evaluateOrganizeEntity);
//            responseMessage.setSuccess(true);
//        }else{
//            responseMessage.setMessage("机构存在");
//        }

        return responseMessage;
    }


    public ResponseMessage updateOrganize(OrganizeEvaluateExpertEntity evaluateOrganizeEntity) {
        ResponseMessage responseMessage = new ResponseMessage();

//        OrganizeEvaluateEntity entity = repository.findOne(evaluateOrganizeEntity.getOrganizeId());
//        if(entity == null){
//            responseMessage.setMessage("机构不存在");
//        }else {
//            repository.save(entity);
//            responseMessage.setSuccess(true);
//        }

        return responseMessage;
    }

    public ResponseMessage deleteOrganize(Integer expertId) {
        ResponseMessage responseMessage = new ResponseMessage();

//        OrganizeEvaluateEntity entity = repository.findOne(organizeId);
//        if(entity == null){
//            responseMessage.setMessage("机构不存在");
//        }else {
//            entity.setActive(false);
//            repository.save(entity);
//            responseMessage.setSuccess(true);
//        }

        return responseMessage;
    }
}
