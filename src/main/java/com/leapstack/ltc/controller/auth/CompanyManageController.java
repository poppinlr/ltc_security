package com.leapstack.ltc.controller.auth;

import com.leapstack.ltc.entity.auth.CompanyEntity;
import com.leapstack.ltc.service.auth.CompanyManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/auth/company")
public class CompanyManageController {

    @Autowired
    private CompanyManageService companyManageService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public List<CompanyEntity> listCompany(){
        return companyManageService.listCompany();
    }
}
