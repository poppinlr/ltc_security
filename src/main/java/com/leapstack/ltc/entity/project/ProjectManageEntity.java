package com.leapstack.ltc.entity.project;

import com.leapstack.ltc.common.listener.impl.CreateAndModifyListener;
import com.leapstack.ltc.entity.base.BaseExtendEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by zhuochen on 2017/7/24.
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "project_manage")
@EntityListeners(CreateAndModifyListener.class)
public class ProjectManageEntity extends BaseExtendEntity {

    @Id
    @GeneratedValue
    @Column(name = "project_id")
    private Integer projectId;

    @Column(name = "policy_num")
    private Integer policyNum;

    @Column(name = "project_name")
    private String projectName;

    @Column(name = "tongchou_type_id")
    private Integer tongchouTypeId;

    @Column(name = "province_id")
    private Integer provinceId;

    @Column(name = "city_id")
    private Integer cityId;

    @Column(name = "district_id")
    private Integer districtId;

    @Column(name = "start_date")
    private Date startDate;

    @Column(name = "end_date")
    private Date endDate;

    @Column(name = "applicant")
    private Integer applicant;

    @Column(name = "audit_status")
    private Integer auditStatus;

    @Column(name = "auditor")
    private Integer auditor;

    @Column(name = "audit_comment")
    private String auditComment;

    @Column(name = "audit_date")
    private Date auditDate;
}
