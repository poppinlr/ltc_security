package com.leapstack.ltc.vo.organization.evaluate;

import com.leapstack.ltc.vo.web.SortRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class OrganizeEvaluateExpertFilter extends SortRequest {

    private String name;

    private String idNumber;//身份证

    private Integer type;//专家A 专家B

    private Integer evaluateOrganizeId;

    private String employeeNumber;//员工号
}
