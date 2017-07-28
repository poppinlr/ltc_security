package com.leapstack.ltc.vo.organization.evaluate;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.leapstack.ltc.entity.organization.evaluate.OrganizeEvaluateEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class OrganizeEvaluateResponse {

    private Integer organizeId;

    private String orgNumber;

    private String orgName;

    private Integer orgType;//私立 公立

    private String orgAddress;

    private String organizer;//负责人

    private String organizerPhone;

    private String legalRepresentative;//法人

    private String legalRepresentativePhone;

    private Integer companyId;

    public OrganizeEvaluateResponse(OrganizeEvaluateEntity evaluateEntity) {
        BeanUtils.copyProperties(evaluateEntity, this);
    }
}
