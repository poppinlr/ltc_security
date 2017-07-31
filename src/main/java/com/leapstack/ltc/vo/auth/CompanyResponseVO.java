package com.leapstack.ltc.vo.auth;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.leapstack.ltc.entity.auth.CompanyEntity;
import com.leapstack.ltc.entity.auth.RoleEntity;
import com.leapstack.ltc.entity.auth.UserLoginEntity;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@NoArgsConstructor
public class CompanyResponseVO {

    private Integer companyId;

    private String companyName;

    private Integer level;

    private Integer parentId;

    private List<RoleResponseVO> roleVOS = new ArrayList<>();

    private List<UserLoginResponseVO> userLoginVOS = new ArrayList<>();

    private Integer userSize;

    private Date createdAt;

    public CompanyResponseVO(CompanyEntity entity) {
        this.companyId = entity.getCompanyId();
        this.companyName = entity.getCompanyName();
        this.parentId = entity.getParentId();
        this.level = entity.getLevel();
        this.createdAt = entity.getCreatedAt();
//
//        for (RoleEntity roleEntity : entity.getRoleEntities()) {
//            this.roleVOS.add(new RoleResponseVO(roleEntity));
//        }
//
//        if (entity.getUserLoginEntities() != null) {
//            List<UserLoginEntity> userLoginEntity = entity.getUserLoginEntities();
//            this.userSize = userLoginEntity.size();
//            Integer loopSize = userLoginEntity.size() > 10 ? 10 : userLoginEntity.size();
//
//            for (int i = 0; i < loopSize; i++) {
//                this.userLoginVOS.add(new UserLoginResponseVO(entity.getUserLoginEntities().get(i)));
//            }
//        }
    }
}
