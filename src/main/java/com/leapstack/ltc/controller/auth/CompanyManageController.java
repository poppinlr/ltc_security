package com.leapstack.ltc.controller.auth;

import com.leapstack.ltc.service.auth.CompanyManageService;
import com.leapstack.ltc.vo.auth.CompanyVO;
import com.leapstack.ltc.vo.web.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/auth/company")
public class CompanyManageController {

    @Autowired
    private CompanyManageService companyManageService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public List<CompanyVO> listCompany(){
        return companyManageService.getCompanyVOList();
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    @ResponseBody
    public ResponseMessage createCompany(@Valid CompanyVO companyVO){
        return companyManageService.saveCompany(companyVO);
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    @ResponseBody
    public ResponseMessage updateCompany(@Valid CompanyVO companyVO){
        return companyManageService.updateCompany(companyVO);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public ResponseMessage deleteCompany(Integer companyId){
        return companyManageService.deleteCompany(companyId);
    }
}
