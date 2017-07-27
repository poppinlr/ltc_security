package com.leapstack.ltc.entity.base;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

/**
 * Created by zhuochen on 2017/7/12.
 */
@MappedSuperclass
@Data
@EqualsAndHashCode(callSuper = false)
public class BaseExtendEntity extends BaseEntity {

    @Column(name = "created_by", updatable = false)
    private Integer createdBy;

    @Column(name = "modified_by")
    private Integer modifiedBy;

    @Column(name = "active")
    private Boolean active = true;//default true
}
