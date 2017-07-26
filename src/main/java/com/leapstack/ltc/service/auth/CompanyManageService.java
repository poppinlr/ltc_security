package com.leapstack.ltc.service.auth;

import com.leapstack.ltc.entity.auth.CompanyEntity;
import com.leapstack.ltc.entity.auth.QCompanyEntity;
import com.leapstack.ltc.entity.auth.UserLoginEntity;
import com.leapstack.ltc.repository.auth.CompanyEntityRepository;
import com.leapstack.ltc.repository.auth.RoleEntityRepository;
import com.leapstack.ltc.repository.auth.UserLoginEntityRepository;
import com.leapstack.ltc.service.common.EntityMapperToVO;
import com.leapstack.ltc.vo.auth.CompanyVO;
import com.leapstack.ltc.vo.web.ResponseMessage;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.extern.log4j.Log4j;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Service
@Log4j
public class CompanyManageService {

    @Autowired
    private CompanyEntityRepository companyEntityRepository;

    @Autowired
    private RoleEntityRepository roleEntityRepository;

    @Autowired
    private UserLoginEntityRepository userLoginEntityRepository;

    @Autowired
    private JPAQueryFactory queryFactory;

    public List<CompanyVO> getCompanyVOList() {
        ArrayList<CompanyEntity> companyEntities = listCompany();
        //do mapper
        ArrayList<CompanyVO> companyVOArrayList = new ArrayList<>();
        for(CompanyEntity entity : companyEntities){
            companyVOArrayList.add(EntityMapperToVO.CompanyVOMapper(entity));
        }

        return companyVOArrayList;
    }

    public ArrayList<CompanyEntity> listCompany(){
        UserLoginEntity userLoginEntity = (UserLoginEntity)SecurityUtils.getSubject().getPrincipal();
        ArrayList<CompanyEntity> companyEntities = new ArrayList<>();
        if(userLoginEntity.getCompanyEntity() != null){
            getCompaniesAndChildrenByCompanyId(userLoginEntity.getCompanyEntity().getCompanyId());
        }

        return companyEntities;
    }

    public ArrayList<CompanyEntity> getCompaniesAndChildrenByCompanyId(Integer companyId){
        ArrayList<CompanyEntity> companyEntities = new ArrayList<>();
        companyEntities.add(companyEntityRepository.findOne(companyId));
        List<CompanyEntity> childCompanies = companyEntityRepository.findByParentId(companyId);
        getCompany(companyEntities, childCompanies);

        return companyEntities;
    }

    private void getCompany(List<CompanyEntity> list, List<CompanyEntity> companyEntities){
        for(CompanyEntity entity : companyEntities){
            list.add(entity);
            List<CompanyEntity> entities = companyEntityRepository.findByParentId(entity.getCompanyId());
            if(entities!= null){
                getCompany(list, entities);
            }
        }

    }

    public ResponseMessage saveCompany(CompanyVO companyVO) {
        ResponseMessage responseMessage = new ResponseMessage();

        CompanyEntity companyEntity = companyEntityRepository.findByCompanyName(companyVO.getCompanyName());
        if(companyEntity == null){
            companyEntity = new CompanyEntity();
            companyEntity.setCompanyName(companyEntity.getCompanyName());
            companyEntity.setLevel(companyVO.getLevel());
            companyEntity.setParentId(companyVO.getParentId());
        }else{
            companyEntity.setLevel(companyVO.getLevel());
            companyEntity.setParentId(companyVO.getParentId());
            companyEntity.setActive(true);
        }

        try{
            companyEntityRepository.save(companyEntity);
            responseMessage.setSuccess(true);
        }catch (Exception e){
            log.error("create company : " + companyEntity + " error: ", e);
            responseMessage.setMessage(e.getMessage());
        }


        return responseMessage;
    }

    public ResponseMessage updateCompany(CompanyVO companyVO) {
        ResponseMessage responseMessage = new ResponseMessage();

        CompanyEntity companyEntity = companyEntityRepository.findOne(companyVO.getCompanyId());
        if(companyEntity == null){
            responseMessage.setMessage("company id doesn't exist!");
        }else{
            companyEntity.setCompanyName(companyVO.getCompanyName());
            companyEntity.setParentId(companyVO.getParentId());
            companyEntity.setLevel(companyVO.getLevel());
        }

        try{
            companyEntityRepository.save(companyEntity);
            responseMessage.setSuccess(true);
        }catch (Exception e){
            log.error("update company : " + companyEntity + " error: ", e);
            responseMessage.setMessage(e.getMessage());
        }

        return responseMessage;
    }

    public ResponseMessage deleteCompany(CompanyVO companyVO) {
        ResponseMessage responseMessage = new ResponseMessage();

        CompanyEntity companyEntity = companyEntityRepository.findOne(companyVO.getCompanyId());
        if(companyEntity == null){
            responseMessage.setMessage("company id doesn't exist!");
        }else{
            companyEntity.setActive(false);
        }

        try{
            companyEntityRepository.save(companyEntity);
            responseMessage.setSuccess(true);
        }catch (Exception e){
            log.error("delete company : " + companyEntity + " error: ", e);
            responseMessage.setMessage(e.getMessage());
        }

        return responseMessage;
    }
}
