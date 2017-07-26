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
public class UserLoginVO {

    private Integer userId;

    private String username;

//    private RoleVO roleVO;

    public UserLoginVO(UserLoginEntity entity){
        if(entity != null){
            this.userId = entity.getUserId();
            this.username = entity.getUsername();
        }
    }
}
