package com.leapstack.ltc.controller.project;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by zhuochen on 2017/7/24.
 */
@Controller
@RequestMapping(value = "/auth/project")
public class ProjectManageController {

    @RequestMapping(value = "")
    public void list() {

    }
}
