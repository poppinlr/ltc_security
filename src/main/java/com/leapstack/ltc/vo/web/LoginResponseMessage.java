package com.leapstack.ltc.vo.web;

import lombok.Data;

/**
 * Created by zhuochen on 2017/7/17.
 */
@Data
public class LoginResponseMessage {

    private Boolean success = false;
    private String message;
    private String name;
    private Integer userId;
    private String username;
    private Integer roleId;
    private String roleName;
//    private Object response;
}
