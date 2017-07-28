package com.leapstack.ltc.vo.organization.evaluate;

import com.leapstack.ltc.entity.organization.evaluate.OrganizeEvaluateExpertEntity;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@NoArgsConstructor
public class OrganizeEvaluateExpertResponse {

    private Integer organizeExpertId;

    private String name;

    private String phone;

    private Integer type;//专家A 专家B

    private Boolean onJob;//在职状态

    private String idNumber;//身份证

    private Integer gender;

    private String position;//职位

    private String title;//职称

    private Integer personalPhone;//私人电话

    private String education;//学历

    private String degree;//学位

    private String employeeNumber;//员工号

    private String workingAge;//工龄

    private String address;//联系地址

    private String certificate;//证书

    private String certificateNumber;//证书编号

    private String comment;

    private Integer evaluateOrganizeId;

    public OrganizeEvaluateExpertResponse(OrganizeEvaluateExpertEntity entity) {
        BeanUtils.copyProperties(entity, this);
    }
}
