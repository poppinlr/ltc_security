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
    @Column(name = "organize_expert_id")
    private Integer organizeExpertId;

    @Column(name = "name")
    private String name;

    @Column(name = "phone")
    private String phone;

    @Column(name = "type")
    private Integer type;//专家A 专家B

    @Column(name = "on_job")
    private Boolean onJob;//在职状态

    @Column(name = "ID_number")
    private String idNumber;//身份证

    @Column(name = "gender")
    private Integer gender;

    @Column(name = "position")
    private String position;//职位

    @Column(name = "title")
    private String title;//职称

    @Column(name = "personal_phone")
    private Integer personalPhone;//私人电话

    @Column(name = "education")
    private String education;//学历

    @Column(name = "degree")
    private String degree;//学位

    @Column(name = "employee_number")
    private String employeeNumber;//员工号

    @Column(name = "working_age")
    private String workingAge;//工龄

    @Column(name = "address")
    private String address;//联系地址

    @Column(name = "certificate")
    private String certificate;//证书

    @Column(name = "certificate_number")
    private String certificateNumber;//证书编号

    @Column(name = "comment")
    private String comment;

    @Column(name = "evaluate_organize_id")
    private Integer evaluateOrganizeId;

    @ManyToOne
    @JoinColumn(name = "evaluate_organize_id", referencedColumnName = "evaluate_organize_id", insertable = false, updatable = false)
    @JsonBackReference
    private OrganizeEvaluateEntity evaluateOrganizeEntity;
}
