package com.leapstack.ltc.controller.auth;

import com.leapstack.ltc.service.auth.AuthService;
import com.leapstack.ltc.vo.web.LoginInfo;
import com.leapstack.ltc.vo.web.LoginResponseMessage;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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
    public LoginResponseMessage login(LoginInfo loginInfo){
        return authService.login(loginInfo);
    }

}
