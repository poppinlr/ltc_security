package com.leapstack.ltc.vo.auth;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class CompanyVO {

    private Integer companyId;

    @NotNull
    private String companyName;

    @NotNull
    private Integer level;

    @NotNull
    private Integer parentId;

    private List<RoleVO> roleVOS = new ArrayList<>();

    private List<UserLoginVO> userLoginVOS = new ArrayList<>();

    private Integer userSize;

    private Date createdAt;
}
