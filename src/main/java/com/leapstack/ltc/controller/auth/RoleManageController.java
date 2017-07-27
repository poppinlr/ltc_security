package com.leapstack.ltc.controller.auth;

import com.leapstack.ltc.service.auth.RoleManageService;
import com.leapstack.ltc.vo.auth.RoleRequestVO;
import com.leapstack.ltc.vo.web.ResponseMessage;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by zhuochen on 2017/7/19.
 */
@Controller
@RequestMapping("/auth/role")
@Log4j
public class RoleManageController {

    @Autowired
    private RoleManageService roleManageService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMessage createRole(RoleRequestVO requestVO) {
        return roleManageService.createRole(requestVO);
    }

    //TODO access_role table update id will +++++++
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMessage updateRole(RoleRequestVO requestVO) {
        return roleManageService.updateRole(requestVO);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public ResponseMessage deleteRole(Integer roleId) {
        return roleManageService.deleteRole(roleId);
    }
}
