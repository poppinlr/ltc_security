package com.leapstack.ltc.controller.auth;

import com.leapstack.ltc.service.auth.UserManageService;
import com.leapstack.ltc.vo.auth.UserLoginRequestVO;
import com.leapstack.ltc.vo.auth.UserLoginResponseVO;
import com.leapstack.ltc.vo.web.PageResponse;
import com.leapstack.ltc.vo.web.ResponseMessage;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

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
    public PageResponse<UserLoginResponseVO> listUser(PageRequest pageRequest, @Nonnull Integer companyId, @Nullable Integer roleId) {
        return userManageService.listUser(pageRequest, companyId, roleId);
    }

    @RequestMapping(value = "/getByUserId", method = RequestMethod.GET)
    @ResponseBody
    public UserLoginResponseVO getUserByUserId(@Nonnull Integer userId){
        return userManageService.getUserByUserId(userId);
    }


    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMessage createUser(UserLoginRequestVO requestVO) {
        return userManageService.createUser(requestVO);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMessage updateUser(UserLoginRequestVO userLoginVO) {
        return userManageService.updateUser(userLoginVO);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public ResponseMessage deleteUser(Integer userId) {
        return userManageService.deleteUser(userId);
    }
}
