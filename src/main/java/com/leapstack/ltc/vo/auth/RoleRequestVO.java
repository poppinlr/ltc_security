package com.leapstack.ltc.vo.auth;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Created by zhuochen on 2017/7/18.
 */
@Data
public class RoleRequestVO {

    private Integer roleId;

    @NotNull(message = "角色名称不能为空")
    private String roleName;

    @NotNull(message = "所属公司不能为空")
    private Integer companyId;

    @NotNull(message = "激活状态")
    private Boolean active;

    private String comment;

    private List<Integer> accessIds;
}
