package com.leapstack.ltc.service.common;

import com.leapstack.ltc.entity.auth.*;
import com.leapstack.ltc.vo.auth.*;

import java.util.List;

public class EntityMapperToVO {

    public static MenuVO MenuVOMapper(MenuEntity entity){
        MenuVO menuVO = new MenuVO();
        menuVO.setMenuId(entity.getMenuId());
        menuVO.setMenuName(entity.getMenuName());
        menuVO.setUrl(entity.getUrl());
        menuVO.setParentId(entity.getParentId());
        for(AccessEntity accessEntity : entity.getAccessEntities()){
            menuVO.getAccessEntities().add(new AccessVO(accessEntity.getAccessId(), accessEntity.getAccessName()));
        }
        return menuVO;
    }

    public static CompanyVO CompanyVOMapper(CompanyEntity entity) {
        CompanyVO companyVO = new CompanyVO();
        companyVO.setCompanyId(entity.getCompanyId());
        companyVO.setCompanyName(entity.getCompanyName());
        companyVO.setParentId(entity.getParentId());
        companyVO.setLevel(entity.getLevel());
        companyVO.setCreatedAt(entity.getCreatedAt());
        for(RoleEntity roleEntity : entity.getRoleEntities()){
            companyVO.getRoleVOS().add(new RoleVO(roleEntity));
        }

        if(entity.getUserLoginEntities() != null){
            List<UserLoginEntity> userLoginEntity = entity.getUserLoginEntities();
            companyVO.setUserSize(userLoginEntity.size());
            Integer loopSize = userLoginEntity.size() > 10 ? 10 : userLoginEntity.size();

            for(int i = 0 ; i < loopSize ; i++){
                companyVO.getUserLoginVOS().add(new UserLoginVO(entity.getUserLoginEntities().get(i)));
            }
        }

        return companyVO;
    }
}
