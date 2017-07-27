package com.leapstack.ltc.entity.organization.evaluate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.leapstack.ltc.common.listener.impl.CreateAndModifyListener;
import com.leapstack.ltc.entity.base.BaseExtendEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "organize_expert")
@EntityListeners(CreateAndModifyListener.class)
public class OrganizeEvaluateExpertEntity extends BaseExtendEntity {

    @Id
    @GeneratedValue
    private Integer organizeExpertId;

    private String name;

    private String phone;

    private Integer type;//专家A 专家B

    private Boolean onJob;//在职状态

    private String IDNumber;//身份证

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

    @ManyToOne
    @JoinColumn(name = "organize_id")
    @JsonBackReference
    private OrganizeEvaluateEntity evaluateOrganizeEntity;
}
