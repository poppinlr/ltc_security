package com.leapstack.ltc.controller.auth;

import com.leapstack.ltc.service.auth.MenuService;
import com.leapstack.ltc.vo.auth.MenuResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(value = "/auth/menu")
public class MenuManageController {

    @Autowired
    private MenuService menuService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public List<MenuResponseVO> getMenuList() {
        return menuService.getMenuWithAccessList();
    }
}
