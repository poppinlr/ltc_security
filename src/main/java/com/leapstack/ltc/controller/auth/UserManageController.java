package com.leapstack.ltc.controller.auth;

import com.leapstack.ltc.entity.auth.UserLoginEntity;
import com.leapstack.ltc.service.auth.UserManageService;
import com.leapstack.ltc.vo.web.ResponseMessage;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhuochen on 2017/7/19.
 */
@Controller
@RequestMapping("/auth/user")
@Log4j
public class UserManageController {

    @Autowired
    private UserManageService userManageService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Page listUser(PageRequest pageRequest, Integer companyId, Integer roleId){
        return userManageService.listUser(pageRequest, companyId, roleId);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMessage createUser(UserLoginEntity userLoginEntity, Integer roleId){
        return userManageService.createUser(userLoginEntity, roleId);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMessage updateUser(UserLoginEntity userLoginEntity, Integer roleId){
        return userManageService.updateUser(userLoginEntity, roleId);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMessage deleteUser(Integer userId){
        return userManageService.deleteUser(userId);
    }
}
