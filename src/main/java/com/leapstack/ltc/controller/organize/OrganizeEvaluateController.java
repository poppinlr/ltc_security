package com.leapstack.ltc.controller.organize;

import com.leapstack.ltc.entity.organization.evaluate.OrganizeEvaluateEntity;
import com.leapstack.ltc.service.organize.OrganizeEvaluateService;
import com.leapstack.ltc.vo.web.ResponseMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/auth/organize/evaluate")
public class OrganizeEvaluateController {

    @Autowired
    private OrganizeEvaluateService organizeService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @ResponseBody
    public Page<OrganizeEvaluateEntity> listOrganize(PageRequest pageRequest) {
        return organizeService.listOrganize(pageRequest);
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    @ResponseBody
    public ResponseMessage createOrganize(OrganizeEvaluateEntity evaluateOrganizeEntity) {
        return organizeService.createOrganize(evaluateOrganizeEntity);
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    @ResponseBody
    public ResponseMessage updateOrganize(OrganizeEvaluateEntity evaluateOrganizeEntity) {
        return organizeService.updateOrganize(evaluateOrganizeEntity);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public ResponseMessage deleteOrganize(Integer organizeId) {
        return organizeService.deleteOrganize(organizeId);
    }

}
