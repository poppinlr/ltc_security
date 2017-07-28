package com.leapstack.ltc.controller.organize;

import com.leapstack.ltc.service.organize.OrganizeEvaluateService;
import com.leapstack.ltc.vo.organization.evaluate.OrganizeEvaluateFilter;
import com.leapstack.ltc.vo.organization.evaluate.OrganizeEvaluateRequest;
import com.leapstack.ltc.vo.organization.evaluate.OrganizeEvaluateResponse;
import com.leapstack.ltc.vo.web.PageResponse;
import com.leapstack.ltc.vo.web.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
@RequestMapping(value = "/auth/organize/evaluate")
public class OrganizeEvaluateController {

    @Autowired
    private OrganizeEvaluateService organizeService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public PageResponse<OrganizeEvaluateResponse> listOrganize(PageRequest pageRequest, OrganizeEvaluateFilter filter) {
        return organizeService.listOrganize(pageRequest, filter);
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    @ResponseBody
    public ResponseMessage createOrganize(@Valid OrganizeEvaluateRequest request) {
        return organizeService.createOrganize(request);
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    @ResponseBody
    public ResponseMessage updateOrganize(@Valid OrganizeEvaluateRequest request) {
        return organizeService.updateOrganize(request);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public ResponseMessage deleteOrganize(Integer organizeId) {
        return organizeService.deleteOrganize(organizeId);
    }

}
