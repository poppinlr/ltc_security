package com.leapstack.ltc.vo.auth;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class UserLoginRequestVO {

    private Integer userId;//for update

    @NotNull
    private String username;

    @NotNull
    private String password;

    @NotNull
    private String name;

    @NotNull
    private Integer companyId;

    private String email;

    Integer roleId;

    Boolean active = true;
}
