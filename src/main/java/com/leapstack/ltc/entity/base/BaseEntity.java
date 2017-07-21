package com.leapstack.ltc.entity.base;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.util.Date;

/**
 * Created by zhuochen on 2017/7/5.
 */
@MappedSuperclass
@Data
public class BaseEntity {

    @Column(name = "created_at", updatable = false)
    private Date createdAt;

    @Column(name = "modified_at")
    private Date modifiedAt;
}
