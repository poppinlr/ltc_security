package com.leapstack.ltc.service.auth;

import com.leapstack.ltc.entity.auth.CompanyEntity;
import com.leapstack.ltc.entity.auth.UserLoginEntity;
import com.leapstack.ltc.repository.auth.CompanyEntityRepository;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CompanyManageService {

    @Autowired
    private CompanyEntityRepository companyEntityRepository;

    //TODO
    public List<CompanyEntity> listCompany() {
        UserLoginEntity userLoginEntity = (UserLoginEntity)SecurityUtils.getSubject().getPrincipal();
        ArrayList<CompanyEntity> companyEntities = new ArrayList<>();
        if(userLoginEntity.getCompanyEntity() != null){
            companyEntities.add(userLoginEntity.getCompanyEntity());
            Integer companyId = userLoginEntity.getCompanyEntity().getCompanyId();
            List<CompanyEntity> childCompanies = companyEntityRepository.findByParentId(companyId);
            getCompany(companyEntities, childCompanies);
        }

        //get company list by company Id
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
}
