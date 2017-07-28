package com.leapstack.ltc.controller.organize;

import com.leapstack.ltc.service.organize.OrganizeEvaluateExpertService;
import com.leapstack.ltc.vo.organization.evaluate.OrganizeEvaluateExpertFilter;
import com.leapstack.ltc.vo.organization.evaluate.OrganizeEvaluateExpertRequest;
import com.leapstack.ltc.vo.organization.evaluate.OrganizeEvaluateExpertResponse;
import com.leapstack.ltc.vo.web.PageResponse;
import com.leapstack.ltc.vo.web.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/auth/organize/evaluateExpert")
public class OrganizeEvaluateExpertController {

    @Autowired
    private OrganizeEvaluateExpertService organizeService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public PageResponse<OrganizeEvaluateExpertResponse> listOrganize(PageRequest pageRequest, OrganizeEvaluateExpertFilter filter) {
        return organizeService.listOrganize(pageRequest, filter);
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    @ResponseBody
    public ResponseMessage createOrganize(OrganizeEvaluateExpertRequest request) {
        return organizeService.createOrganize(request);
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    @ResponseBody
    public ResponseMessage updateOrganize(OrganizeEvaluateExpertRequest request) {
        return organizeService.updateOrganize(request);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public ResponseMessage deleteOrganize(Integer expertId) {
        return organizeService.deleteOrganize(expertId);
    }
}
