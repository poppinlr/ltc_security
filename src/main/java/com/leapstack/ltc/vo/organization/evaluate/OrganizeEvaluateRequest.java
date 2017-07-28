package com.leapstack.ltc.vo.organization.evaluate;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class OrganizeEvaluateRequest {

    private Integer organizeId;//for update

    @NotNull
    private String orgNumber;

    @NotNull
    private String orgName;

    @NotNull
    private Integer orgType;//私立 公立

    @NotNull
    private String orgAddress;

    @NotNull
    private String organizer;//负责人

    @NotNull
    private String organizerPhone;

    @NotNull
    private String legalRepresentative;//法人

    @NotNull
    private String legalRepresentativePhone;

}
