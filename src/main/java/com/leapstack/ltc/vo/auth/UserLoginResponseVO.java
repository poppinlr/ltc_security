package com.leapstack.ltc.vo.auth;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.leapstack.ltc.entity.auth.UserLoginEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by zhuochen on 2017/7/18.
 */
@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserLoginResponseVO {

    private Integer userId;

    private String username;

    private String name;

    private String email;

    private Integer companyId;

    private Integer roleId;

    public UserLoginResponseVO(UserLoginEntity entity) {
        if (entity != null) {
            this.userId = entity.getUserId();
            this.username = entity.getUsername();
            this.name = entity.getName();
            this.email = entity.getEmail();
            if (entity.getCompanyEntity() != null) {
                this.companyId = entity.getCompanyEntity().getCompanyId();
            }

            if (entity.getRoleEntity() != null) {
                this.roleId = entity.getRoleEntity().getRoleId();
            }
        }
    }
}
