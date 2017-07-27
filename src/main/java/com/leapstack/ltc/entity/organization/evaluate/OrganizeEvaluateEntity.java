package com.leapstack.ltc.entity.organization.evaluate;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.leapstack.ltc.common.listener.impl.CreateAndModifyListener;
import com.leapstack.ltc.entity.base.BaseExtendEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "evaluate_organize")
@EntityListeners(CreateAndModifyListener.class)
public class OrganizeEvaluateEntity extends BaseExtendEntity {

    @Id
    @GeneratedValue
    @Column(name = "evaluate_organize_id")
    private Integer organizeId;

    @Column(name = "number")
    private String orgNumber;

    @Column(name = "name")
    private String orgName;

    @Column(name = "type")
    private Integer orgType;//私立 公立

    @Column(name = "address")
    private String orgAddress;

    @Column(name = "organizer")
    private String organizer;//负责人

    @Column(name = "organizer_phone")
    private String organizerPhone;

    @Column(name = "legal_representative")
    private String legalRepresentative;//法人

    @Column(name = "legal_representative_phone")
    private String legalRepresentativePhone;

    @Column(name = "company_id")
    private Integer companyId;

    @OneToMany(mappedBy = "evaluateOrganizeEntity")
    @JsonManagedReference
    private List<OrganizeEvaluateExpertEntity> expertEntities;
}
