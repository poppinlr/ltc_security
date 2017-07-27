package com.leapstack.ltc.vo.auth;

import com.leapstack.ltc.entity.auth.RoleEntity;
import lombok.Data;

@Data
public class RoleResponseVO {

    private Integer roleId;

    private String roleName;

    private String comment;

    private String companyName;

    public RoleResponseVO(RoleEntity entity) {
        if (entity != null) {
            this.roleId = entity.getRoleId();
            this.roleName = entity.getRoleName();
            this.comment = entity.getComment();
        }
    }
}
