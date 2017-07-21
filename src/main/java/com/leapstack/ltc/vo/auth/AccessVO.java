package com.leapstack.ltc.vo.auth;

import com.leapstack.ltc.entity.auth.AccessEntity;
import lombok.Data;

import javax.persistence.Column;

/**
 * Created by zhuochen on 2017/7/18.
 */
@Data
public class AccessVO {

    private Integer accessId;

    private String accessName;

    private MenuVO menuVO;

    public AccessVO(AccessEntity accessEntity){
        if(accessEntity != null){
            this.accessId = accessEntity.getAccessId();
            this.accessName = accessEntity.getAccessName();
//            this.menuVO = new MenuVO(accessEntity.getMenuEntity());
        }
    }
}
