package com.leapstack.ltc.vo.organization.evaluate;

import com.leapstack.ltc.vo.web.SortRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class OrganizeEvaluateFilter extends SortRequest {

    private String orgName;
    private String orgNumber;
    private String address;
}
