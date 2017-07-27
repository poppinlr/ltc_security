package com.leapstack.ltc.vo.auth;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class CompanyRequestVO {

    private Integer companyId;// for update

    @NotNull(message = "公司名称不能为空")
    private String companyName;

    @NotNull(message = "公司级别不能为空")
    private Integer level;

    @NotNull(message = "上级公司不能为空")
    private Integer parentId;

}
