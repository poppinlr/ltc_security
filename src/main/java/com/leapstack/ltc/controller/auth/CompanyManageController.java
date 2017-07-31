package com.leapstack.ltc.controller.auth;

import com.leapstack.ltc.service.auth.CompanyManageService;
import com.leapstack.ltc.vo.auth.CompanyRequestVO;
import com.leapstack.ltc.vo.auth.CompanyResponseVO;
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

    @RequestMapping(value = "/pureList", method = RequestMethod.GET)
    @ResponseBody
    public List<CompanyResponseVO> listPureCompany() {
//        return companyManageService.getPureCompanyVOList();
        return null;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public List<CompanyResponseVO> listCompany() {
        return companyManageService.getCompanyVOList();
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    @ResponseBody
    public ResponseMessage createCompany(@Valid CompanyRequestVO requestVO) {
        return companyManageService.saveCompany(requestVO);
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    @ResponseBody
    public ResponseMessage updateCompany(@Valid CompanyRequestVO requestVO) {
        return companyManageService.updateCompany(requestVO);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public ResponseMessage deleteCompany(Integer companyId) {
        return companyManageService.deleteCompany(companyId);
    }
}
