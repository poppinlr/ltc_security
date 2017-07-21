package com.leapstack.ltc.controller.auth;

import com.leapstack.ltc.entity.auth.UserLoginEntity;
import com.leapstack.ltc.service.auth.UserManageService;
import com.leapstack.ltc.util.SecurityConstant;
import com.leapstack.ltc.vo.web.ResponseMessage;
import lombok.extern.log4j.Log4j;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by zhuochen on 2017/7/19.
 */
@Controller
@RequestMapping("/auth")
@Log4j
public class UserManageController {

    @Autowired
    private UserManageService userManageService;

    //TODO map return vo without password
    @RequestMapping(value = "/user/list", method = RequestMethod.POST)
    @ResponseBody
    public List<UserLoginEntity> listUser(){
        return userManageService.listUser();
    }

    @RequestMapping(value = "/user/create", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMessage createUser(UserLoginEntity userLoginEntity, Integer roleId){
        return userManageService.createUser(userLoginEntity, roleId);
    }

    @RequestMapping(value = "/user/update", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMessage updateUser(UserLoginEntity userLoginEntity, Integer roleId){
        return userManageService.updateUser(userLoginEntity, roleId);
    }

    @RequestMapping(value = "/user/delete", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMessage deleteUser(Integer userId){
        return userManageService.deleteUser(userId);
    }
}
