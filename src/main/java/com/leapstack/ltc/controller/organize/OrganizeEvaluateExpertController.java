package com.leapstack.ltc.controller.organize;

import com.leapstack.ltc.entity.organization.evaluate.OrganizeEvaluateExpertEntity;
import com.leapstack.ltc.service.organize.OrganizeEvaluateExpertService;
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
    public PageResponse<OrganizeEvaluateExpertEntity> listOrganize(PageRequest pageRequest) {
        return organizeService.listOrganize(pageRequest);
    }

    @RequestMapping(value = "/create", method = RequestMethod.GET)
    @ResponseBody
    public ResponseMessage createOrganize(OrganizeEvaluateExpertEntity entity) {
        return organizeService.createOrganize(entity);
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    @ResponseBody
    public ResponseMessage updateOrganize(OrganizeEvaluateExpertEntity entity) {
        return organizeService.updateOrganize(entity);
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    @ResponseBody
    public ResponseMessage deleteOrganize(Integer expertId) {
        return organizeService.deleteOrganize(expertId);
    }
}
