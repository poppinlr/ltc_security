package com.leapstack.ltc.service.auth;

import com.leapstack.ltc.entity.auth.AccessEntity;
import com.leapstack.ltc.entity.auth.MenuEntity;
import com.leapstack.ltc.vo.auth.AccessVO;
import com.leapstack.ltc.vo.auth.MenuVO;

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
}
