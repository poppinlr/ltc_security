package com.leapstack.ltc.controller.auth;

import com.leapstack.ltc.entity.auth.MenuEntity;
import com.leapstack.ltc.entity.auth.RoleEntity;
import com.leapstack.ltc.entity.auth.UserLoginEntity;
import com.leapstack.ltc.vo.web.LoginInfo;
import com.leapstack.ltc.vo.web.ResponseMessage;
import com.leapstack.ltc.service.auth.AuthService;
import lombok.extern.log4j.Log4j;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by zhuochen on 2017/7/17.
 */
@Controller
@Log4j
public class AuthController {

    @Autowired
    private AuthService authService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMessage login(LoginInfo loginInfo){
        return authService.login(loginInfo);
    }

    @RequestMapping(value = "/auth/menu", method = RequestMethod.GET)
    public List<MenuEntity> getMenuList(){
        return authService.getMenuWithAccessList();
    }

}
