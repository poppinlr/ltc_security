package com.leapstack.ltc.vo.auth;

import com.leapstack.ltc.entity.auth.RoleEntity;
import lombok.Data;

import javax.persistence.Column;

/**
 * Created by zhuochen on 2017/7/18.
 */
@Data
public class RoleVO {

    private Integer roleId;
    private String roleName;
    private String comment;
    private Boolean active;
    private Integer companyId;

    public RoleVO(RoleEntity roleEntity){
        if(roleEntity != null){
            this.setRoleId(roleEntity.getRoleId());
            this.setRoleName(roleEntity.getRoleName());
            this.setComment(roleEntity.getComment());
            this.setActive(roleEntity.getActive());
            this.setCompanyId(roleEntity.getCompanyId());
        }
    }
}
